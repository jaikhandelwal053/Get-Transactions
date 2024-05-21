package com.transactions.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.transactions.service.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

	private final TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		this.transactionService = transactionService;
	}


	@GetMapping("/{accountNumber}")
	public Map<String, Object> getTransactions(@PathVariable String accountNumber,@RequestParam(defaultValue = "ALL") String status) {
		if ("ALL".equalsIgnoreCase(status)) {
	        return transactionService.getTransactions(accountNumber);
		} else {
			return transactionService.getTransactions(accountNumber, status);
		}
	}
}
