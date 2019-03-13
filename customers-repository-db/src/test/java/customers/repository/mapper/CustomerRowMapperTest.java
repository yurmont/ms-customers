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
	public void mapRow_FromResultSet_returnDocument() throws SQLException {
		// Arrange		
				
		// Act
		Customer actual = documentRowMapper.mapRow(resultSet, 1);	
		
	}
}
