package com.blogspot.babdev.bookapi;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.AdGroup;
import com.blogspot.babdev.bookapi.model.AdList;

@RestResource(path = "adGroups", rel = "adGroups")
public interface AdGroupRepository extends PagingAndSortingRepository<AdGroup, Long>  {

	public List<AdList> findByName(@Param("name") String name);

	public List<AdList> findByActive(@Param("active") boolean active);

}
