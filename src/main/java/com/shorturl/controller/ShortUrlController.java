package com.shorturl.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shorturl.repository.ShortUrlRepoSitory;
import com.shorturl.service.UrlService;

@RestController
public class ShortUrlController {

	@Autowired
	UrlService urlService;

	@Autowired
	ShortUrlRepoSitory shortUrlRepoSitory;

	@PostMapping("/")
	public String shortenUrl(HttpServletRequest request) {
		return urlService.generateUrl(request);
	}

	@GetMapping(value = "/{code}")
	public void redirectToUrl(@PathVariable String code, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		urlService.redirectUrl(request, response, code);
	}

}
