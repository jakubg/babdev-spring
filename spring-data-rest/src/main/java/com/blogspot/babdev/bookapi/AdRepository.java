package com.blogspot.babdev.bookapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.Ad;
import com.blogspot.babdev.bookapi.model.AdList;

@RestResource(path = "ads", rel = "ads")
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
	
	Page<AdList> findByActive(boolean active, Pageable pageable);
}
