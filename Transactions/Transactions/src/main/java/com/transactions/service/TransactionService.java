package com.transactions.service;

import java.util.Map;

public interface TransactionService {
	Map<String, Object> getTransactions(String accountNumber, String status);
	Map<String, Object> getTransactions(String accountNumber);
}
