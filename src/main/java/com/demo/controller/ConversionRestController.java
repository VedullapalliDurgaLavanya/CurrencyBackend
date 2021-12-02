package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exceptions.UnknownCurrencyException;
import com.demo.model.ConversionRequestIn;
import com.demo.model.ConversionResponse;
import com.demo.service.AdminService;

import java.math.BigDecimal;

import javax.mail.MessagingException;


@RestController
@RequestMapping
public class ConversionRestController {
	
	@Autowired
	private AdminService service;

  @GetMapping("/convert")
  public ConversionResponse convert(@RequestParam(name = "from", defaultValue = "USD") String fromCurrency,
                                    @RequestParam("to") String toCurrency,
                                    @RequestParam("amount") BigDecimal amount) throws MessagingException {
    if (!fromCurrency.equalsIgnoreCase("USD")) {
      throw new UnknownCurrencyException("Unknown 'from' currency: " + fromCurrency + ", only USD supported.");
    }
    BigDecimal factor = conversionFactorFor(toCurrency);
    
    service.sendConversionEmail(fromCurrency,toCurrency,factor.multiply(amount));
    return new ConversionResponse(toCurrency, factor.multiply(amount));
    
  }
  

  
  private BigDecimal conversionFactorFor(String toCurrency) {
	    BigDecimal factor;
	    if (toCurrency.equalsIgnoreCase("BTC") || toCurrency.equalsIgnoreCase("XBT")) {
	      factor = BigDecimal.valueOf(0.000018); 
	    } else if (toCurrency.equalsIgnoreCase("INR")) {
	        factor = BigDecimal.valueOf(74.34);
	      }
	    else if (toCurrency.equalsIgnoreCase("GBP")) {
	      factor = BigDecimal.valueOf(0.708);
	    } else if (toCurrency.equalsIgnoreCase("JPY")) {
	      factor = BigDecimal.valueOf(108.86);
	    } else if (toCurrency.equalsIgnoreCase("DOGE")) {
	      factor = BigDecimal.valueOf(2.15);
	    } else {
	      throw new UnknownCurrencyException("Unknown 'to' currency: " + toCurrency + ". Must be one of BTC,INR, GBP, JPY, or DOGE");
	    }
	    return factor;
	  }
  
  
  
  
  
  
  
  
  
 
  



  
}
