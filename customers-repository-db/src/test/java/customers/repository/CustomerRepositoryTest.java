package customers.repository;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.jdbc.core.JdbcTemplate;

import customers.repository.CustomerRepositoryImpl;
import customers.repository.utils.SimpleJdbcCallFactory;

@RunWith(MockitoJUnitRunner.class)
@SuppressWarnings({ "unchecked", "rawtypes" })
public class CustomerRepositoryTest {

	@Mock
	private JdbcTemplate jdbcTemplate;

	@Mock
	SimpleJdbcCallFactory simpleJdbcCallFactory;

	@InjectMocks
	CustomerRepositoryImpl documentRepositoryImpl;

	@Test
	public void insert_document_verifyJdcCallIsExecuted() throws ParseException {
		
	}
}
