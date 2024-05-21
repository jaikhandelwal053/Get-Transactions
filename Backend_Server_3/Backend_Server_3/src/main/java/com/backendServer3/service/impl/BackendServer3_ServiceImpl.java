package com.backendServer3.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.backendServer3.entity.TransactionEntity;
import com.backendServer3.service.BackendServer3_Service;

@Service
public class BackendServer3_ServiceImpl implements BackendServer3_Service {
	
	@Override
    public Map<String, Object> getPendingTransactions(String accountNumber) {
	      
		Map<String, Object> mapResult = new LinkedHashMap<>();
		
		if("12233300011001".equals(accountNumber)) {
			List<TransactionEntity> pendingTransactionsList = new ArrayList<>();
			pendingTransactionsList.add(new TransactionEntity("123456789", "pending", "500", "30-04-2024"));

			mapResult.put("AccountNumber", accountNumber);
			mapResult.put("pending", pendingTransactionsList);
		} else {
			mapResult.put("Error", "404");
			mapResult.put("message", "Account Number does not exist");
		}
		return mapResult;
    }
}
