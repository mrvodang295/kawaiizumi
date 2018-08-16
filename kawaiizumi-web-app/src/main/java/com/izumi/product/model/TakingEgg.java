/**
 * 
 */
package com.izumi.product.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.izumi.product.constant.ChickenConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author vle28
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = ChickenConstants.TABLE_CHICKEN_TAKING_EGG)
public class TakingEgg extends UUIDBase {

	private int periodOfEgg; // The period of time that hen produces egg

	private long spawningDay; // The day of first egg born

	private long hactchingDay; // The day of final egg born

	private long breakingDay; // The day of hen leaves her eggs

	private long childCareDay; // The day of hen takes care her children

	private int noOfEgg; // The number of eggs was born

	@JsonIgnore // Ignore due to it's just a reference key to parent object 
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "chickNoRef")
	private Chicken chickNoRef;	// The foreign key of hen refers to Chicken
}
