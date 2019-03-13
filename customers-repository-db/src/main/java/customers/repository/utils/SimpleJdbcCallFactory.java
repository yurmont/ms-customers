package customers.repository.utils;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

@Component
public class SimpleJdbcCallFactory {
	
	public SimpleJdbcCall create(JdbcTemplate jdbcTemplate, String procName) {
		return new SimpleJdbcCall(jdbcTemplate).withProcedureName(procName);
	}
	
}