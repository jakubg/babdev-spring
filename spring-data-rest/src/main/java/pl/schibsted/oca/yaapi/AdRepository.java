package pl.schibsted.oca.yaapi;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.repository.annotation.RestResource;

import pl.schibsted.oca.yaapi.model.Ad;


@RestResource(path = "ads", rel = "ads")
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {

	@RestResource(path = "active", rel = "active")
	public Page<Ad> findByActiveTrue(Pageable pageable);

	public Page<Ad> findByObjectId(@Param("objectId") String objectId, Pageable pageable);
}
