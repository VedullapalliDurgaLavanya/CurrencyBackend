package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.Bank;

public interface BankRepository extends JpaRepository<Bank, Long> {
	

}
