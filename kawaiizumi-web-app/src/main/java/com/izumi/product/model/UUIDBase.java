/**
 * 
 */
package com.izumi.product.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.izumi.product.constant.ChickenConstants;

import lombok.Data;

/**
 * @author vle28
 *
 */
@Data
@Embeddable
public class UUIDBase implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4460254090941996234L;

	/*
	 * The UUID code for mapping
	 * 
	 * @GeneratedValue(generator = ChickenConstants.UUID2)
	 * 
	 * @GenericGenerator(name = ChickenConstants.UUID2, strategy =
	 * ChickenConstants.UUID2)
	 * 
	 * @Id
	 */
	@Column(columnDefinition = ChickenConstants.BINARY16)
	UUID uuid;
}
