package customers.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import customers.domain.Customer;
import customers.dto.CustomerCreateRequest;
import customers.dto.CustomerKpiResponse;
import customers.dto.CustomerResponse;
import customers.repository.CustomerRepository;
import customers.service.CustomerServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

	@Mock
	CustomerRepository mockCustomerRepository;

	@InjectMocks
	CustomerServiceImpl customerServiceImpl;

	@Test
	public void findAll_customers_returnResponse() throws ParseException {
		// Arrange
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Customer customer1 = new Customer();
		customer1.setCustomerId(101);
		customer1.setName("Name1");
		customer1.setLastName("LastName1");
		customer1.setBirthDate(format.parse("01-01-1984"));

		Customer customer2 = new Customer();
		customer2.setCustomerId(102);
		customer2.setName("Name2");
		customer2.setLastName("LastName2");
		customer2.setBirthDate(format.parse("01-01-1994"));

		List<Customer> customers = Arrays.asList(customer1, customer2);

		when(mockCustomerRepository.findAll()).thenReturn(customers);

		// Act
		List<CustomerResponse> actual = customerServiceImpl.findAll();

		// Assert
		assertTrue(actual.size() == 2);
		verify(mockCustomerRepository, times(1)).findAll();

		assertEquals(customer1.getCustomerId(), actual.get(0).getCustomerId());
		assertEquals(customer1.getName(), actual.get(0).getName());
		assertEquals(customer1.getLastName(), actual.get(0).getLastName());
		assertEquals(customer1.getBirthDate(), actual.get(0).getBirthDate());
		assertEquals(35, actual.get(0).getAge());
		assertEquals(format.parse("01-01-2059"), actual.get(0).getEstimatedDeathDate());

		assertEquals(customer2.getCustomerId(), actual.get(1).getCustomerId());
		assertEquals(customer2.getName(), actual.get(1).getName());
		assertEquals(customer2.getLastName(), actual.get(1).getLastName());
		assertEquals(customer2.getBirthDate(), actual.get(1).getBirthDate());
		assertEquals(25, actual.get(1).getAge());
		assertEquals(format.parse("01-01-2069"), actual.get(1).getEstimatedDeathDate());
	}
	
	@Test
	public void getKpi_fromCustomers_returnResponse() throws ParseException {
		// Arrange
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");

		Customer customer1 = new Customer();
		customer1.setCustomerId(101);
		customer1.setName("Name1");
		customer1.setLastName("LastName1");
		customer1.setBirthDate(format.parse("01-01-1979"));

		Customer customer2 = new Customer();
		customer2.setCustomerId(102);
		customer2.setName("Name2");
		customer2.setLastName("LastName2");
		customer2.setBirthDate(format.parse("01-01-1989"));
		
		Customer customer3 = new Customer();
		customer3.setCustomerId(103);
		customer3.setName("Name3");
		customer3.setLastName("LastName3");
		customer3.setBirthDate(format.parse("01-01-1999"));
		
		Customer customer4 = new Customer();
		customer4.setCustomerId(104);
		customer4.setName("Name4");
		customer4.setLastName("LastName4");
		customer4.setBirthDate(format.parse("01-01-2009"));

		List<Customer> customers = Arrays.asList(customer1, customer2, customer3, customer4);

		when(mockCustomerRepository.findAll()).thenReturn(customers);

		// Act
		CustomerKpiResponse actual = customerServiceImpl.getKpi();

		// Assert		
		verify(mockCustomerRepository, times(1)).findAll();
		
		assertEquals(25.0, actual.getAgeAverage(), 0.1);
		assertEquals(12.90994, actual.getStandardDeviation(), 0.00001);
	}
	
	@Test
	public void create_customers_verifyRepositoriesIsCalled() {	
		// Arrange
		int customerId = 100;
		CustomerCreateRequest request = new CustomerCreateRequest();
		
		when(mockCustomerRepository.insert(any(Customer.class))).thenReturn(customerId);
		
		// Act
		int actual = customerServiceImpl.create(request);
		
		// Assert
		verify(mockCustomerRepository, times(1)).insert(any(Customer.class));		
		assertEquals(customerId, actual);
	}
}
