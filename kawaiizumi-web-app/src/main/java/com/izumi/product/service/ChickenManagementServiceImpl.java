/**
 * 
 */
package com.izumi.product.service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import com.izumi.product.model.Chicken;
import com.izumi.product.repository.ChickenRepository;

/**
 * @author vle28
 *
 */
@Service
public class ChickenManagementServiceImpl<T extends Chicken> implements ChickenManagementService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChickenManagementServiceImpl.class);

	@Autowired
	private ChickenRepository<T> chickenRepository;
	
	@Override
	public List<T> registerChickens(List<T> chickenModels) {
		List<T> registeredChickens = new ArrayList<>();

		try {
			Iterable<T> chickens = chickenRepository.save(chickenModels);

			chickens.iterator().forEachRemaining(registeredChickens::add);
		} catch (Exception e) {
			LOGGER.error(this.getClass().getSimpleName() + ".registerChickens failed", e);
			throw e;
		}
		return registeredChickens;
	}

	@Override
	public List<Resource<T>> getChickens() {
		List<Resource<T>> chickens = new ArrayList<>();

		try {
			Iterable<T> allChickens = chickenRepository.findAll();
			allChickens.forEach(chicken->{
				// Convert to resource to add HAL links
				Resource<T> resource = this.buildResourceWithRelatedRels(chicken);
				chickens.add(resource);
			});
		} catch (Exception e) {
			LOGGER.error(this.getClass().getSimpleName() + ".getChickens failed", e);
			throw e;
		}
		return chickens;
		
	}
	
	/**
	 * build resources
	 * 
	 * @param application
	 * @return
	 */
	private Resource<T> buildResourceWithRelatedRels(T object) {

		RepositoryRestResource restResource = AnnotationUtils.findAnnotation(chickenRepository.getClass(),
				RepositoryRestResource.class);

		// RestResource restResources = AnnotationUtils.findAnnotation(chickenRepositoryDAO.getClass(), RestResource.class);

		Resource<T> resource = new Resource<>(object);
		String restResourcePath = restResource.path();

		Link self = linkTo(chickenRepository.getClass()).slash(restResourcePath).slash(object.getUuid()).withSelfRel();
		resource.add(self);

		return resource;
	}
	
}
