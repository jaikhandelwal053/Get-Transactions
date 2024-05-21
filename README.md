# JAVA MINI Assignment 1

## API for Feign Client Application 
## "Get Transactions" Endpoint Implementation

## Description
This project implements a RESTful endpoint to retrieve transactions for a given account number based on the transaction status (ALL, success, pending, failure). It utilizes Spring Boot, JPA, Completable Future, and Factory Design Pattern.

## Technologies Used
    Java 8+
    Spring Boot
    JPA
    Completable Future
    Feign Client/WebClient
    JUnit
    Mockito

## How to Run
### Backend Servers
  Run Backend Server 1: http://localhost:8081
  Run Backend Server 2: http://localhost:8082
  Run Backend Server 3: http://localhost:8083
  
### Main Application
  Run the main application: http://localhost:8090


IN Application I am use Account Number (accountNumber): 12233300011001

# API Endpoints
**Transactions Service** 

Scenario A: When the status value is "ALL":\
```URL : http://localhost:8090/transactions/{accountNumber}?status=all```: 
```
{
    "success": [
        {
            "transactionid": "123456789",
            "status": "success",
            "amount": "500",
            "date": "11-05-2023"
        },
        {
            "transactionid": "789566233",
            "status": "success",
            "amount": "100",
            "date": "12-05-2023"
        },
        {
            "transactionid": "789566888",
            "status": "success",
            "amount": "1000",
            "date": "13-05-2023"
        }
    ],
    "failure": [
        {
            "transactionid": "123456789",
            "status": "failure",
            "amount": "500",
            "date": "01-05-2024"
        },
        {
            "transactionid": "789566233",
            "status": "failure",
            "amount": "100",
            "date": "10-05-2024"
        }
    ],
    "pending": [
        {
            "transactionid": "123456789",
            "status": "pending",
            "amount": "500",
            "date": "30-04-2024"
        }
    ]
}

```
Scenario B: When the status value is "Success," "Failure," or "Pending,"

1. When status value is "success":
```URL : http://localhost:8090/transactions/{accountNumber}?status=success```: 

```
{
    "success": [
        {
            "transactionid": "123456789",
            "status": "success",
            "amount": "500",
            "date": "11-05-2023"
        },
        {
            "transactionid": "789566233",
            "status": "success",
            "amount": "100",
            "date": "12-05-2023"
        },
        {
            "transactionid": "789566888",
            "status": "success",
            "amount": "1000",
            "date": "13-05-2023"
        }
    ]
}
```

```URL : http://localhost:8090/transactions/{accountNumber}?status=failure```: 

```
{
    "failure": [
        {
            "transactionid": "123456789",
            "status": "failure",
            "amount": "500",
            "date": "01-05-2024"
        },
        {
            "transactionid": "789566233",
            "status": "failure",
            "amount": "100",
            "date": "10-05-2024"
        }
    ]
}
```

```URL : http://localhost:8090/transactions/{accountNumber}?status=pending```: 

```
{
    "pending": [
        {
            "transactionid": "123456789",
            "status": "pending",
            "amount": "500",
            "date": "30-04-2024"
        }
    ]
}
```
## Component 1 (Act as Backend Server 1 for returning success transactions): 

**BackendService1: For Success transactions**

```URL : http://localhost:8081/backendserver1/success/{accountNumber}```: 

```
{
    "AccountNumber": "12233300011001",
    "success": [
        {
            "transactionid": "123456789",
            "status": "success",
            "amount": "500",
            "date": "11-05-2023"
        },
        {
            "transactionid": "789566233",
            "status": "success",
            "amount": "100",
            "date": "12-05-2023"
        },
        {
            "transactionid": "789566888",
            "status": "success",
            "amount": "1000",
            "date": "13-05-2023"
        }
    ]
}
```

## Component 2 (Act as Backend Server 2 for returning failure transactions): 

**BackendService2: For Failure transactions**

```URL : http://localhost:8082/backendserver2/failure/{accountNumber}```: 

```
{
    "AccountNumber": "12233300011001",
    "failure": [
        {
            "transactionid": "123456789",
            "status": "failure",
            "amount": "500",
            "date": "01-05-2024"
        },
        {
            "transactionid": "789566233",
            "status": "failure",
            "amount": "100",
            "date": "10-05-2024"
        }
    ]
}
```

## Component 1 (Act as Backend Server 1 for returning success transactions): 

**BackendService1: For Success transactions**

```URL : http://localhost:8083/backendserver3/pending/{accountNumber}```: 

```
{
    "AccountNumber": "12233300011001",
    "pending": [
        {
            "transactionid": "123456789",
            "status": "pending",
            "amount": "500",
            "date": "30-04-2024"
        }
    ]
}
```

