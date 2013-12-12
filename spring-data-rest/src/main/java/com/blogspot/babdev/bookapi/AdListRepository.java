package com.blogspot.babdev.bookapi;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.AdList;

@RestResource(path = "adlists", rel = "adlists")
public interface AdListRepository extends PagingAndSortingRepository<AdList, Long> {

	public List<AdList> findByName(@Param("name") String name);
	@RestResource(path = "active", rel = "active")
	public List<AdList> findByActiveTrue();

}
