/**
 * 
 */
package com.izumi.product.model;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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

	@Id
	@GeneratedValue(generator = ChickenConstants.UUID2)
	@GenericGenerator(name = ChickenConstants.UUID2, strategy = ChickenConstants.UUID2)
	@Override
	public UUID getUuid() {
		return super.getUuid();
	}

	private int periodOfEgg; // The period of time that hen produces egg

	private long spawningDay; // The day of first egg born

	private long hactchingDay; // The day of final egg born

	private long breakingDay; // The day of hen leaves her eggs

	private long childCareDay; // The day of hen takes care her children

	private int noOfEgg; // The number of eggs was born

	// private UUID chickNoRef; // The foreign key of hen refers to Chicken

	private Chicken chickNoRef;

	// @ManyToOne(fetch = FetchType.LAZY)
	// @JoinColumn(name = "chickNoRef_uuid")
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Chicken.class)
	@JoinColumn(name = "chickNoRef")
	public Chicken getChickNoRef() {
		return chickNoRef;
	}

}
