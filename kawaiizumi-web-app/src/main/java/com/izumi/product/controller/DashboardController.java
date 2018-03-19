/**
 * 
 */
package com.izumi.product.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.izumi.product.model.User;
import com.izumi.product.repository.ChickenRepositoryDAO;

/**
 * @author vle28
 *
 */
@Controller
public class DashboardController {

	@Autowired
	private ChickenRepositoryDAO chickenRepositoryDAO;

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Map<String, Object> model) {
		return "bs-simple-admin/index";
	}

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		model.put("users", chickenRepositoryDAO.findAll());

		return "welcome";
	}

	@RequestMapping("/incubation")
	public String foo(Map<String, Object> model) {
		chickenRepositoryDAO.save(this.getUsers());
		return "incubation";
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
}
