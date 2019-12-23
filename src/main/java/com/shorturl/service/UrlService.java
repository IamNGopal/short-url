package com.shorturl.service;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.shorturl.model.ShortUrl;
import com.shorturl.model.ShortUrlHit;
import com.shorturl.repository.ShortUrlRepoSitory;
import com.shorturl.repository.ShortUrlhitRepository;

@Service
public class UrlService {

	@Autowired
	ShortUrlRepoSitory shortUrlRepoSitory;

	@Autowired
	ShortUrlhitRepository shortUrlhitRepository;

	public String generateUrl(HttpServletRequest request) {
		String url = request.getParameter("longUrl");
		Calendar calendar = Calendar.getInstance();

		if (isUrlValid(url)) {

			ShortUrl shortUrl = new ShortUrl();
			shortUrl.setShorturlOriginalUrl(url);
			shortUrl.setShorturlDate(calendar.getTime());

			calendar.add(Calendar.MINUTE, 10);
			shortUrl.setShorturlValiddate(calendar.getTime());

			Long id = shortUrlRepoSitory.save(shortUrl).getShorturlId();

			final String code = Hashing.murmur3_32().hashString(url + id, StandardCharsets.UTF_8).toString();
			shortUrl.setShorturlCode(code);
			shortUrlRepoSitory.save(shortUrl);

			String prefix = request.getScheme() + "://" + request.getHeader("HOST");

			return prefix + "/" + code;

		} else {
			return "Enter Valid Url!!!";
		}
	}

	public void redirectUrl(HttpServletRequest request, HttpServletResponse response, String code) throws IOException {
		ShortUrl shortUrl = shortUrlRepoSitory.findByShorturlCode(code);

		if (shortUrl != null && (shortUrl.getShorturlValiddate().compareTo(new Date()) > 0)) {
			int hitCount = shortUrl.getShorturlHitcount();
			String hitIp = request.getRemoteAddr();
			if (hitIp.equalsIgnoreCase("0:0:0:0:0:0:0:1")) {
				InetAddress inetAddress = InetAddress.getLocalHost();
				String ipAddress = inetAddress.getHostAddress();
				hitIp = ipAddress;
			}
			final String url = shortUrl.getShorturlOriginalUrl();
			if (url != null) {
				response.addHeader("Location", url);
				response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);

				shortUrl.setShorturlHitcount(hitCount + 1);
				shortUrlRepoSitory.save(shortUrl);

				ShortUrlHit shortUrlHit = new ShortUrlHit();
				shortUrlHit.setHitShorturlId(shortUrl.getShorturlId());
				shortUrlHit.setHitDate(new Date());
				shortUrlHit.setHitIp(hitIp);
				shortUrlhitRepository.save(shortUrlHit);

			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND);
			}
		} else {
			response.sendError(HttpServletResponse.SC_GATEWAY_TIMEOUT);
		}
	}

	private boolean isUrlValid(String url) {
		boolean valid = true;
		try {
			new URL(url);
		} catch (MalformedURLException e) {
			valid = false;
		}
		return valid;
	}

}
