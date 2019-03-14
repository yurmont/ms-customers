package customers.controller;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import customers.controller.CustomerController;
import customers.dto.CustomerCreateRequest;
import customers.dto.CustomerKpiResponse;
import customers.dto.CustomerResponse;
import customers.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	CustomerService mockCustomerService;	
	
	@InjectMocks
	CustomerController customerController;
	
	@Test
	public void findAll_customers_serviceIsCalledAndReturnResponse() {	
		// Arrange
		List<CustomerResponse> customers = Arrays.asList(new CustomerResponse(), new CustomerResponse());
		
		when(mockCustomerService.findAll()).thenReturn(customers);	
		
		// Act
		ResponseEntity<List<CustomerResponse>> actual = customerController.findAll();
				
		// Assert		
		verify(mockCustomerService, times(1)).findAll();			
		
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertEquals(2, actual.getBody().size());
	}
	
	@Test
	public void create_customer_serviceIsCalledAndReturnResponse() {	
		// Arrange
		CustomerCreateRequest request = new CustomerCreateRequest();
		Integer customerId = 10;
		
		when(mockCustomerService.create(request)).thenReturn(customerId);
	
		// Act
		ResponseEntity<Integer> actual = customerController.create(request);	
		
		// Assert		
		verify(mockCustomerService, times(1)).create(request);
				
		assertEquals(HttpStatus.CREATED, actual.getStatusCode());
		assertEquals(customerId, actual.getBody());		
	}
	
	@Test
	public void getKpi_fromCustomers_serviceIsCalledAndReturnResponse() {	
		// Arrange
		CustomerKpiResponse response = new CustomerKpiResponse();
		
		when(mockCustomerService.getKpi()).thenReturn(response);	
		
		// Act
		ResponseEntity<CustomerKpiResponse> actual = customerController.getKpi();
				
		// Assert		
		verify(mockCustomerService, times(1)).getKpi();			
		
		assertEquals(HttpStatus.OK, actual.getStatusCode());
		assertEquals(response, actual.getBody());
	}
}
