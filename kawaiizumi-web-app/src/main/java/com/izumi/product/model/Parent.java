/**
 * 
 */
package com.izumi.product.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * @author vle28
 *
 */
@Data
@Embeddable
public class Parent implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2746186896388569872L;
	private String fatherCode;
	private String motherCode;

	@Override
	public String toString() {
		return String.format("Father: %s - Mother: %s", fatherCode, motherCode);
	}
}
