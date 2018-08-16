/**
 * 
 */
package com.izumi.product.service;

import java.util.List;

import org.springframework.hateoas.Resource;

import com.izumi.product.model.Chicken;

/**
 * @author vle28
 *
 */
public interface ChickenManagementService<T extends Chicken> {
	List<T> registerChickens(List<T> chickenModels);

	List<Resource<T>> getChickens();

}
