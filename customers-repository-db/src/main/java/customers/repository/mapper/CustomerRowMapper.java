package customers.repository.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import customers.domain.Customer;

public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {

		Customer document = new Customer();
		document.setCustomerId(rs.getInt("customerId"));
		document.setName(rs.getString("name"));
		document.setLastName(rs.getString("lastName"));
		document.setBirthDate(rs.getDate("birthDate"));		

		return document;
	}
}
