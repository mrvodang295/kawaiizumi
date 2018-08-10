/**
 * 
 */
package com.izumi.product.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.izumi.product.constant.ChickenConstants;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author vle28
 *
 */
@Data
@Entity
@Table(name = ChickenConstants.TABLE_CHICKEN)
@EqualsAndHashCode(callSuper = false)
public class Chicken extends UUIDBase {

	@Id
	@GeneratedValue(generator = ChickenConstants.UUID2)
	@GenericGenerator(name = ChickenConstants.UUID2, strategy = ChickenConstants.UUID2)
	@Override
	public UUID getUuid() {
		return super.getUuid();
	}

	private String chickNo; // The identify code of chicken - COCKS_XXX/HEN_XXX/CHICK_XXX

	private String name; // The name of chicken

	private String description; // The individual feature of chicken

	private long birthday; // The day of birth

	private int weekNo; // The number of week that chicken is grown up

	private boolean gender; // The sex of chicken

	private String type; // The style of chicken - EGG/SPERM/SEED

	@Embedded
	private Parent parent; // The parent of chicken - refer to chickNo

	@Transient
	private List<TakingEgg> takingEgg = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chickNoRef", orphanRemoval = true)
	public List<TakingEgg> getTakingEgg() {
		return takingEgg;
	}

	@Override
	public String toString() {
		return String.format(
				"UUID: %s - chickNo: %s - name: %s - description: %s - weekNo: %s - gender: %s - type: %s - parent: %s",
				uuid, chickNo, name, description, weekNo, gender, type, parent.toString());
	}
}
