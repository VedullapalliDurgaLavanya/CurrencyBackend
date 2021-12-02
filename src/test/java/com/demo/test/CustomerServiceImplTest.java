package com.demo.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.demo.model.Customer;
import com.demo.service.CustomerService;

@SpringBootTest
public class CustomerServiceImplTest {
	
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ApplicationContext context;
	
	@Test
	void testToAddUser() {
		Customer expected = context.getBean(Customer.class);
		expected.setCustomerName("Agrawal");
		expected.setPassword("agrawal");
		boolean result = customerService.addUser(expected);
		assertTrue(result);
	}
	
	
//	@Test
//	void testToLoginCustomer() {
//		Customer expected = context.getBean(Customer.class);
//		expected.setCustomerId(1);
//		expected.setPassword("vanshika");
//		Customer actual = customerService.loginUser(expected.getCustomerName(), expected.getPassword());
//		assertEquals(expected.getCustomerName(), actual.getCustomerName());
//		assertEquals(expected.getPassword(), actual.getPassword());
//	}
}
