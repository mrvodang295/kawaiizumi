/**
 * 
 */
package com.izumi.product.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.izumi.product.model.Chicken;

/**
 * @author vle28
 *
 */
@RepositoryRestResource(collectionResourceRel = "chickens", path = "chickens")
@Transactional
public interface ChickenRepositoryDAO<T extends Chicken> extends PagingAndSortingRepository<T, Long> {

	@RestResource(rel = "chickens", path = "chickens")
	@Query(value = "Select chicken From Chicken chicken")
	Page<T> findAll(Pageable pageable);

	
}
