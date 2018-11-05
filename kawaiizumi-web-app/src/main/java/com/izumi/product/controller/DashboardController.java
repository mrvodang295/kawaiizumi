/**
 * 
 */
package com.izumi.product.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.izumi.product.kawaiizumiwebapp.ApplicationConfiguration;
import com.izumi.product.model.Chicken;
import com.izumi.product.model.Parent;
import com.izumi.product.model.TakingEgg;
import com.izumi.product.model.User;
import com.izumi.product.service.ChickenManagementService;
import com.izumi.product.service.TakingEggService;

/**
 * @author vle28
 *
 */
@Controller
@RequestMapping(value = "${server.request-mapping.chicken-management.root-api}")
public class DashboardController {

	@Autowired
	private ChickenManagementService<Chicken> chickenManagementService;

	@Autowired
	private ApplicationConfiguration applicationConfiguration;

	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private TakingEggService<TakingEgg> takingEggService;

	@RequestMapping(value = "${server.request-mapping.chicken-management.dashboard-api}", method = RequestMethod.GET)
	public String dashboard(Map<String, Object> model) {
		return "bs-simple-admin/index";
	}

	@GetMapping
	public String welcome(Map<String, Object> model) {
		String a = null;
		a.toString();
		model.put("time", new Date());
		model.put("message", messageSource.getMessage(applicationConfiguration.getChickenManagementTitle(), null,
				LocaleContextHolder.getLocale()));
//		model.put("users", chickenRepositoryDAO.findAll());

		return "welcome";
	}

	@Transactional
	@RequestMapping("/incubation")
	public String foo(Map<String, Object> model) throws Exception{
		chickenManagementService.registerChickens(this.getChickens());
		return "incubation";
	}
	
	@RequestMapping("/get-list")
	public ResponseEntity<?> test(Map<String, Object> model) throws Exception {
		List<Resource<Chicken>> chickens = chickenManagementService.getChickens();
		// Define Resource JSON like Spring HATEOAS definition
		Resources<Resource<Chicken>> result = new Resources<>(chickens);

		return ResponseEntity.ok(result);
	}
	
	@RequestMapping("/taking-egg")
	public ResponseEntity<?> test1(Map<String, Object> model) throws Exception {
		List<Resource<TakingEgg>> takingEggs = takingEggService.getTakingEgg();
		// Define Resource JSON like Spring HATEOAS definition
		Resources<Resource<TakingEgg>> result = new Resources<>(takingEggs);
		
		return ResponseEntity.ok(result);
	}

	private List<User> getUsers() {
		User user = new User();
		user.setEmail("johndoe123@gmail.com");
		user.setName("John Doe");
		user.setAddress("Bangalore, Karnataka");
		User user1 = new User();
		user1.setEmail("amitsingh@yahoo.com");
		user1.setName("Amit Singh");
		user1.setAddress("Chennai, Tamilnadu");
		User user2 = new User();
		user2.setEmail("bipulkumar@gmail.com");
		user2.setName("Bipul Kumar");
		user2.setAddress("Bangalore, Karnataka");
		User user3 = new User();
		user3.setEmail("prakashranjan@gmail.com");
		user3.setName("Prakash Ranjan");
		user3.setAddress("Chennai, Tamilnadu");
		return Arrays.asList(user, user1, user2, user3);
	}

	private List<Chicken> getChickens() {
		Chicken chick1 = new Chicken();
		chick1.setChickNo("123");
		chick1.setName("chicken 1");
		chick1.setDescription("This is chickent number 1");
		chick1.setBirthday(System.currentTimeMillis());
		chick1.setGender(true);
		chick1.setType("Take Egg");
		chick1.setWeekNo(16);
		Parent parent1 = new Parent();
		chick1.setParent(parent1);
		parent1.setFatherCode("COCKS_123");
		parent1.setMotherCode("HEN_123");

		TakingEgg eggs = new TakingEgg();
		eggs.setNoOfEgg(10);
		chick1.setTakingEgg(Arrays.asList(eggs));
		eggs.setChickNoRef(chick1);

		Chicken chick2 = new Chicken();
		chick2.setChickNo("456");
		chick2.setName("chicken 2");
		chick2.setDescription("This is chickent number 2");
		chick2.setBirthday(System.currentTimeMillis());
		chick2.setGender(false);
		chick2.setType("Take meat");
		chick2.setWeekNo(16);
		Parent parent2 = new Parent();
		chick2.setParent(parent2);
		parent2.setFatherCode("COCKS_345");
		parent2.setMotherCode("HEN_345");
		TakingEgg eggs2 = new TakingEgg();
		eggs2.setNoOfEgg(10);
		chick2.setTakingEgg(Arrays.asList(eggs2));
		eggs2.setChickNoRef(chick2);
		
		return Arrays.asList(chick1, chick2);
	}

}
