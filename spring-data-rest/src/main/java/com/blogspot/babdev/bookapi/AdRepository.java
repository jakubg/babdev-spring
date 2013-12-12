package com.blogspot.babdev.bookapi;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.Ad;

@RestResource(path = "ads", rel = "ads")
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
	
	public List<Ad> findByActive(@Param("active") boolean active);
	public List<Ad> findByObjectId(@Param("objectId") String name);
}
