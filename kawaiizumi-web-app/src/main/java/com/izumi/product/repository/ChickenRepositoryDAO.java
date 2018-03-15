/**
 * 
 */
package com.izumi.product.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.izumi.product.model.User;

/**
 * @author vle28
 *
 */
@Transactional
public interface ChickenRepositoryDAO extends CrudRepository<User, Long> {
}
