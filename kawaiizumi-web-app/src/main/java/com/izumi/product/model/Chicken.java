/**
 * 
 */
package com.izumi.product.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	private String chickNo; // The identify code of chicken - COCKS_XXX/HEN_XXX/CHICK_XXX

	private String name; // The name of chicken

	private String description; // The individual feature of chicken

	private long birthday; // The day of birth

	private int weekNo; // The number of week that chicken is grown up

	private boolean gender; // The sex of chicken

	private String type; // The style of chicken - EGG/SPERM/SEED

	@Embedded
	private Parent parent; // The parent of chicken - refer to chickNo

//	@Transient
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "chickNoRef", orphanRemoval = true)
	private List<TakingEgg> takingEgg	 = new ArrayList<>();

	@Override
	public String toString() {
		return String.format(
				"UUID: %s - chickNo: %s - name: %s - description: %s - weekNo: %s - gender: %s - type: %s - parent: %s",
				uuid, chickNo, name, description, weekNo, gender, type, parent.toString());
	}
}
