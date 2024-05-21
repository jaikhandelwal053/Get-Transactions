package com.backendServer2.service.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.backendServer2.entity.TransactionEntity;
import com.backendServer2.service.BackendServer2_Service;

@Service
public class BackendServer2_ServiceImpl implements BackendServer2_Service {

	@Override
    public Map<String, Object> getFailureTransactions(String accountNumber) {
	      
		Map<String, Object> mapResult = new LinkedHashMap<>();
		
		if("12233300011001".equals(accountNumber)) {
			List<TransactionEntity> failureTransactionsList = new ArrayList<>();
			
			failureTransactionsList.add(new TransactionEntity("123456789", "failure", "500", "01-05-2024"));
			failureTransactionsList.add(new TransactionEntity("789566233", "failure", "100", "10-05-2024"));

			mapResult.put("AccountNumber", accountNumber);
			mapResult.put("failure", failureTransactionsList);
		} else {
			mapResult.put("Error", "404");
			mapResult.put("message", "Account Number does not exist");
		}
		return mapResult;
	}
}
