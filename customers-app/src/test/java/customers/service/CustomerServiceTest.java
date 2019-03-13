package customers.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import customers.service.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerServiceImpl asbancDocumentServiceImpl;
		
	@Test
	public void search_cuentasCorriente_returnDocuments() throws Exception {	
		
	}
}
