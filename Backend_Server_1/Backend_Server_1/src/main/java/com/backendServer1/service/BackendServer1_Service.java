package com.backendServer1.service;

import java.util.Map;

public interface BackendServer1_Service {
	Map<String, Object> getSuccessTransactions(String accountNumber);
//	List<TransactionEntity> getSuccessTransactions(String accountNumber);
}
