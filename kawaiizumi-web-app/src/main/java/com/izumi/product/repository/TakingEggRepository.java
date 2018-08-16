/**
 * 
 */
package com.izumi.product.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.izumi.product.model.TakingEgg;

/**
 * @author vle28
 *
 */
@RepositoryRestResource(collectionResourceRel = "taking-egg", path = "taking-egg")
@Transactional
public interface TakingEggRepository<T extends TakingEgg> extends PagingAndSortingRepository<T, Long> {

	// @RestResource(rel = "taking-egg", path = "taking-egg")
	// @Query(value = "Select chicken From Chicken chicken")
	// Page<T> findAll(Pageable pageable);

}
