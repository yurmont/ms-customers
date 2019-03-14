package customers.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import customers.domain.Customer;
import customers.repository.CustomerRepository;
import customers.repository.mapper.CustomerRowMapper;
import customers.repository.utils.SimpleJdbcCallFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	SimpleJdbcCallFactory simpleJdbcCallFactory;

	@Override
	public void insert(Customer customer) {
		SimpleJdbcCall jdbcCall = simpleJdbcCallFactory.create(jdbcTemplate, "customer_insert");

		Map<String, Object> parameters = new HashMap<String, Object>(16);
		parameters.put("p_name", customer.getName());
		parameters.put("p_last_name", customer.getLastName());
		parameters.put("p_birth_date", customer.getBirthDate());

		jdbcCall.execute(parameters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> findAll() {

		SimpleJdbcCall jdbcCall = simpleJdbcCallFactory.create(jdbcTemplate, "customer_find_all")
				.returningResultSet("items", new CustomerRowMapper());

		Map<String, Object> out = jdbcCall.execute();

		return (List<Customer>) out.get("items");
	}

}
