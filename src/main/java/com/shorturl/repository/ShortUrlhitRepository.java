package com.shorturl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shorturl.model.ShortUrlHit;

public interface ShortUrlhitRepository extends JpaRepository<ShortUrlHit, Long> {

}
