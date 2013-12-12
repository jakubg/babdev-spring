package pl.schibsted.oca.yaapi;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import pl.schibsted.oca.yaapi.model.AdGroup;
import pl.schibsted.oca.yaapi.model.AdList;


@RestResource(path = "adGroups", rel = "adGroups")
public interface AdGroupRepository extends PagingAndSortingRepository<AdGroup, Long>  {

	@RestResource(path = "active", rel = "active")
	public Page<AdList> findByActiveTrue(Pageable pageable);

	public List<AdList> findByName(@Param("name") String name);

}
