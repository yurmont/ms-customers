package customers.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import customers.domain.Customer;
import customers.repository.CustomerRepositoryImpl;
import customers.repository.mapper.CustomerRowMapper;
import customers.repository.utils.SimpleJdbcCallFactory;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CustomerRepositoryTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	SimpleJdbcCallFactory simpleJdbcCallFactory;

	@InjectMocks
	CustomerRepositoryImpl customerRepositoryImpl;

	@Test
	public void insert_customer_verifyJdcCallIsExecuted() throws ParseException {
		// Arrange
		DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Customer customer = new Customer();
		
		customer.setCustomerId(100);
		customer.setName("Mike");
		customer.setLastName("Smith");		
		customer.setBirthDate(format.parse("01-01-1984"));
		
		SimpleJdbcCall mockedJdbcCall = Mockito.mock(SimpleJdbcCall.class);
		when(simpleJdbcCallFactory.create(jdbcTemplate, "customer_insert")).thenReturn(mockedJdbcCall);
		
		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("p_customer_id", 100);
		when(mockedJdbcCall.execute(any(HashMap.class))).thenReturn(maps);
		
		// Act
		int actual = customerRepositoryImpl.insert(customer);
		
		// Assert
		ArgumentCaptor<HashMap> argument = ArgumentCaptor.forClass(HashMap.class);
		verify(mockedJdbcCall, times(1)).execute(argument.capture());

		assertEquals(4, argument.getValue().values().size());		
		assertEquals(customer.getName(), argument.getValue().get("p_name"));
		assertEquals(customer.getLastName(), argument.getValue().get("p_last_name"));
		assertEquals(customer.getBirthDate(), argument.getValue().get("p_birth_date"));
		assertEquals(100, actual);
	}
	
	@Test
	public void findAll_customers_verifyJdcCallIsExecuted() {
		// Arrange
		List<Customer> customers = Arrays.asList(new Customer(), new Customer());

		Map<String, Object> maps = new HashMap<String, Object>();
		maps.put("items", customers);

		SimpleJdbcCall mockedJdbcCall = Mockito.mock(SimpleJdbcCall.class);
		when(simpleJdbcCallFactory.create(jdbcTemplate, "customer_find_all")).thenReturn(mockedJdbcCall);
		when(mockedJdbcCall.returningResultSet(any(String.class), any(CustomerRowMapper.class))).thenReturn(mockedJdbcCall);
		when(mockedJdbcCall.execute()).thenReturn(maps);
		
		// Act
		List<Customer> actual = customerRepositoryImpl.findAll();

		// Assert			
		assertSame(customers, actual);
	}
}
