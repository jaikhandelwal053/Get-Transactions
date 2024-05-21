package com.backendServer3.service;

import java.util.Map;

public interface BackendServer3_Service {
	Map<String, Object> getPendingTransactions(String accountNumber);

}
