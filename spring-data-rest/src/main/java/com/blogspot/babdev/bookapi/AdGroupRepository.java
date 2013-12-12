package com.blogspot.babdev.bookapi;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.repository.annotation.RestResource;

import com.blogspot.babdev.bookapi.model.AdGroup;

@RestResource(path = "adGroups", rel = "adGroups")
public interface AdGroupRepository extends PagingAndSortingRepository<AdGroup, Long>  {

}
