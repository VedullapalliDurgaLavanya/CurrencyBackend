package com.demo.service;

import java.math.BigDecimal;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.mail.javamail.JavaMailSender;

import com.demo.model.Admin;
import com.demo.model.Bank;
import com.demo.model.ConversionRequestIn;
import com.demo.model.Customer;

public interface AdminService {
	public boolean addAdmin(Admin admin);// done

	public boolean loginAdmin(Admin admin);// done

	

	public List<Bank> viewBankDetails();// done

	public List<Customer> viewAllCustomer();// done

	public boolean deleteCustomerById(Integer customerId);// done
	

	public void mailService(JavaMailSender javaMailSender);

//	public void sendConversionEmail(ConversionRequestIn conversionRequestIn) throws MessagingException;

	public void sendConversionEmail(String fromCurrency, String toCurrency, BigDecimal multiply)throws MessagingException;

}
