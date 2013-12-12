package com.blogspot.babdev.bookapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.Ad;
import com.blogspot.babdev.bookapi.model.AdList;

@RestResource(path = "ads", rel = "ads")
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
	
	Page<Ad> findByActive(@Param("active") boolean active, Pageable pageable);
	public List<Ad> findByObjectId(@Param("objectId") String name);
}
