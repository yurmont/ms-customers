package customers.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import customers.domain.Customer;
import customers.repository.CustomerRepository;
import customers.repository.utils.SimpleJdbcCallFactory;

import java.util.List;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	SimpleJdbcCallFactory simpleJdbcCallFactory;
	
	@Override
	public List<Customer> search() {		

		return (List<Customer>) null;
	}
}
