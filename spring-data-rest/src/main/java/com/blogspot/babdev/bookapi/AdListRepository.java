package com.blogspot.babdev.bookapi;

import java.util.List;

import com.blogspot.babdev.bookapi.model.AdList;
import com.blogspot.babdev.bookapi.model.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

@RestResource(path = "adlists", rel = "adlists")
public interface AdListRepository extends PagingAndSortingRepository<AdList, Long> {

	public List<AdList> findByName(@Param("name") String name);

	public List<AdList> findByActive(@Param("active") boolean active);

}
