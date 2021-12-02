package com.demo.test;



import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.demo.model.Admin;
import com.demo.model.Customer;
import com.demo.service.AdminService;

@SpringBootTest
public class AdminServiceImplTest {
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ApplicationContext context;
	
	
	// ADMIN-TESTING
	
	@Test
	void testToAddAdmin() {
		Admin expected = context.getBean(Admin.class);
		expected.setAdminId(2);
		expected.setPassword("vanshika");
		boolean result = adminService.addAdmin(expected);
		assertTrue(result);
	}
	
	
//	@Test
//	void testToLoginAdmin() {
//		Admin expected = context.getBean(Admin.class);
//		expected.setAdminId(1);
//		expected.setPassword("vanshika");
//		Admin actual = adminService.loginAdmin(expected.admin.getAdminId(), expected.admin.getPassword());
//		assertEquals(expected.getAdminId(), actual.getAdminId());
//		assertEquals(expected.getPassword(), actual.getPassword());
//	}
//	
	// CURRENCY-TESTING
	
//	void testToAddCurrency() {
//		Currencies expected = context.getBean(Currencies.class);
//		expected.setId(1);
//		expected.setDollar("Dollar");
//		expected.setEuro("Euro");
//		expected.setPound("Pound");
//		expected.setRupee("Rupee");
//		expected.setYen("Yen");
//		boolean result = adminService.addCurrencies(expected);
//		assertTrue(result);
//	}
	
//	@Test
//	void testToRemoveCustomerById() {
//		Customer expected = context.getBean(Customer.class);
//		expected.setCustomerId(1);
//		expected.setCustomerName("Vanshika");
//		expected.setPassword("Vanshika");
//		adminService.addAdmin(null);
//
//		boolean result = adminService.deleteCustomerById(null); // ask lavanya
//		assertTrue(result);
//	}
	
	@Test
	public void testToViewAllCustomer() {
		int source = adminService.viewAllCustomer().size();
		int count = 0;
		Customer expected = context.getBean(Customer.class);
		List<Customer> list = new ArrayList<Customer>();
		for (int i = 0; i < source; i++) {
			list.add(expected);
			count += 1;
		}
		List<Customer> actual = adminService.viewAllCustomer();
		assertEquals(count, actual.size());
	}
	
//	@Test
//	void testFindCurrenciesByNameShouldReturnCurrencies() {
//		Currencies expected = context.getBean(Currencies.class);
//		expected
//		Candidates actual = adminService.findCandidateByName(expected.getCandidateName());
//		assertThat(actual.equals(expected));
//	}
}
