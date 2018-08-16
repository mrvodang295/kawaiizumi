/**
 * 
 */
package com.izumi.product.service;

import java.util.List;

import org.springframework.hateoas.Resource;

import com.izumi.product.model.TakingEgg;

/**
 * @author vle28
 *
 */
public interface TakingEggService<T extends TakingEgg> {

	List<Resource<T>> getTakingEgg();
}
