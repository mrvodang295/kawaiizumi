/**
 * 
 */
package com.izumi.product.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.hateoas.ResourceSupport;

import com.izumi.product.constant.ChickenConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author vle28
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class UUIDBase extends ResourceSupport {

	/*
	 * The UUID code for mapping
	 */
	@Id
	@GeneratedValue(generator = ChickenConstants.UUID2)
	@GenericGenerator(name = ChickenConstants.UUID2, strategy = ChickenConstants.UUID2)
	@Column(name = "uuid", columnDefinition = ChickenConstants.BINARY16)
	UUID uuid;
}
