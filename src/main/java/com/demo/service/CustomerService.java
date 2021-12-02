package com.demo.service;

import java.util.List;

import com.demo.exceptions.CustomerNotFoundException;
import com.demo.model.Bank;
import com.demo.model.Customer;


public interface CustomerService {
	public boolean addUser(Customer customer);//done
	public boolean loginUser(String customerName,String password);//done
	public List<Customer> getAllCustomer();
	public Customer viewUser(Integer customerId) throws CustomerNotFoundException;//done
	public boolean updateUser(Customer customer);
	public boolean deleteUser(Integer customerId) throws CustomerNotFoundException;//done
	public boolean addBankDetails(Bank bank);//done
	public List<Bank> viewBankDetails();//done
	public boolean deleteBank(long accountNumbers);//done
	
}
