package customers.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import customers.controller.CustomerController;
import customers.service.CustomerService;

@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

	@Mock
	CustomerService mockDocumentService;	
	
	@InjectMocks
	CustomerController documentController;
	
	@Test
	public void search_documents_serviceIsCalledAndReturnResponse() throws Exception {	
		
	}
	
}
