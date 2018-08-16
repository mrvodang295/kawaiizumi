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

import com.izumi.product.model.TakingEgg;
import com.izumi.product.repository.TakingEggRepository;

/**
 * @author vle28
 *
 */
@Service
public class TakingEggServiceImpl<T extends TakingEgg> implements TakingEggService<T> {

	private static final Logger LOGGER = LoggerFactory.getLogger(TakingEggServiceImpl.class);

	@Autowired
	private TakingEggRepository<T> takingEggRepository;

	@Override
	public List<Resource<T>> getTakingEgg() {
		List<Resource<T>> takingEggs = new ArrayList<>();

		try {
			Iterable<T> allChickens = takingEggRepository.findAll();
			allChickens.forEach(chicken->{
				// Convert to resource to add HAL links
				Resource<T> resource = this.buildResourceWithRelatedRels(chicken);
				takingEggs.add(resource);
			});
		} catch (Exception e) {
			LOGGER.error(this.getClass().getSimpleName() + ".getTakingEgg failed", e);
			throw e;
		}
		return takingEggs;
		
	}
	
	/**
	 * build resources
	 * 
	 * @param application
	 * @return
	 */
	private Resource<T> buildResourceWithRelatedRels(T object) {

		RepositoryRestResource restResource = AnnotationUtils.findAnnotation(takingEggRepository.getClass(),
				RepositoryRestResource.class);

		// RestResource restResources = AnnotationUtils.findAnnotation(chickenRepositoryDAO.getClass(), RestResource.class);

		Resource<T> resource = new Resource<>(object);
		String restResourcePath = restResource.path();

		Link self = linkTo(takingEggRepository.getClass()).slash(restResourcePath).slash(object.getUuid()).withSelfRel();
		resource.add(self);

		return resource;
	}
	
}
