package com.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shorturl.model.ShortUrl;

@Repository
public interface ShortUrlRepoSitory extends JpaRepository<ShortUrl, Long> {

	public String findShorturlUrlByShorturlCode(String shorturlCode);

	public ShortUrl findByShorturlCode(String shorturlCode);

}
