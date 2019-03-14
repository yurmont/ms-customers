package customers.repository.mapper;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import customers.domain.Customer;
import customers.repository.mapper.CustomerRowMapper;

@RunWith(MockitoJUnitRunner.class)
public class CustomerRowMapperTest {
	
	@Mock
    private ResultSet resultSet;
	
	@InjectMocks
	CustomerRowMapper documentRowMapper;	
	
	@SuppressWarnings("deprecation")
	@Test
	public void mapRow_FromResultSet_returnCustomer() throws SQLException {
		// Arrange
		Customer expected = new Customer();
		expected.setCustomerId(100);
		expected.setName("Mike");
		expected.setLastName("Smith");
		expected.setBirthDate(new Date(1984, 01, 01));
				
		when(resultSet.getInt("customerId")).thenReturn(expected.getCustomerId());
		when(resultSet.getString("name")).thenReturn(expected.getName());
		when(resultSet.getString("lastName")).thenReturn(expected.getLastName());		
		when(resultSet.getDate("birthDate")).thenReturn((Date) expected.getBirthDate());
		
		// Act
		Customer actual = documentRowMapper.mapRow(resultSet, 1);	
	
		// Assert
		assertEquals(expected.getCustomerId(), actual.getCustomerId());
		assertEquals(expected.getName(), actual.getName());
		assertEquals(expected.getLastName(), actual.getLastName());
		assertEquals(expected.getBirthDate(), actual.getBirthDate());
	}
}
