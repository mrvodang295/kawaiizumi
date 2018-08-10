/**
 * 
 */
package com.izumi.product.model;

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
public class UUIDBase {

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
