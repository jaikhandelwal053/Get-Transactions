package com.transactions.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.transactions.service.TransactionService;

@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    private MockMvc mockMvc;

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(transactionController).build();
    }

    @Test
    public void testGetTransactionsAll() throws Exception {
        // Mock data
//        Map<String, Object> mockResponse = new HashMap<>();
//        mockResponse.put("success", new Object[]{});
//        mockResponse.put("failure", new Object[]{});
//        mockResponse.put("pending", new Object[]{});
    	
        Map<String, Object> mockResponse = new HashMap<>();
        List<Map<String, Object>> successList = new ArrayList<>();
        List<Map<String, Object>> failureList = new ArrayList<>();
        List<Map<String, Object>> pendingList = new ArrayList<>();
        
        Map<String, Object> successTransaction1 = new HashMap<>();
        successTransaction1.put("transactionid", "123456789");
        successTransaction1.put("status", "success");
        successTransaction1.put("amount", "500");
        successTransaction1.put("date", "30-05-2023");
        successList.add(successTransaction1);
     
        Map<String, Object> failureTransaction1 = new HashMap<>();
        failureTransaction1.put("transactionid", "345577721");
        failureTransaction1.put("status", "fail");
        failureTransaction1.put("amount", "500");
        failureTransaction1.put("date", "30-04-2023");
        failureList.add(failureTransaction1);
        
        // Add lists to mockTransactions
        mockResponse.put("success", successList);
        mockResponse.put("failure", failureList);
        mockResponse.put("pending", pendingList);

        when(transactionService.getTransactions("12233300011001")).thenReturn(mockResponse);

        
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/12233300011001?status=ALL");
        mockMvc.perform(requestBuilder)
//        		.contentType(MediaType.APPLICATION_JSON))
			    .andExpect(status().isOk())
			    .andExpect(MockMvcResultMatchers.jsonPath("$.success.length()").value(1))
			    .andExpect(MockMvcResultMatchers.jsonPath("$.failure.length()").value(1))
			    .andExpect(MockMvcResultMatchers.jsonPath("$.pending.length()").value(0));
        
//        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    public void testGetTransactionsSuccess() throws Exception {
        // Mock data
        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("success", new Object[]{});

        when(transactionService.getTransactions(anyString(), eq("success"))).thenReturn(mockResponse);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/12233300011001?status=success");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.success", hasSize(0)));
    }

    @Test
    public void testGetTransactionsFailure() throws Exception {
        
        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("failure", new Object[]{});

        when(transactionService.getTransactions(anyString(), eq("failure"))).thenReturn(mockResponse);

       
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/12233300011001?status=failure");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.failure", hasSize(0)));
    }

    @Test
    public void testGetTransactionsPending() throws Exception {
        
        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("pending", new Object[]{});

        when(transactionService.getTransactions(anyString(), eq("pending"))).thenReturn(mockResponse);

        
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/12233300011001?status=pending");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.pending", hasSize(0)));
    }

    @Test
    public void testGetTransactionsInvalidStatus() throws Exception {
        
        Map<String, Object> mockResponse = new HashMap<>();
        mockResponse.put("error", "Oops! Something went wrong");
        mockResponse.put("message", "Please provide a valid Account Number or Status ");

        when(transactionService.getTransactions(anyString(), eq("invalid"))).thenReturn(mockResponse);

        
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/transactions/12233300011001?status=invalid");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.error", is("Oops! Something went wrong")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message", is("Please provide a valid Account Number or Status ")));
    }
    
//    @Test
//    public void testGetTransactionsWithEmptyStatus() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/12233300011001?status=")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
//    @Test
//    public void testGetTransactionsWithInvalidStatus() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/12233300011001?status=invalid")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest());
//    }
//    
//    @Test
//    public void testGetTransactionsWithInvalidAccountNumber() throws Exception {
//        when(transactionService.getTransactions("invalidAccountNumber", "ALL")).thenThrow(new IllegalArgumentException("Invalid account number"));
//
//        mockMvc.perform(MockMvcRequestBuilders.get("/transactions/invalidAccountNumber?status=ALL")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.error").value("Invalid Account Number"))
//                .andExpect(jsonPath("$.message").value("Invalid account number"));
//    }
    
}
