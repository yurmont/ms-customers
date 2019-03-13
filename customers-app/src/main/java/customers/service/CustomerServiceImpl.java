package customers.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import customers.domain.Customer;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);


	@Override
	public List<Customer> search() {

		ArrayList<Customer> documents = new ArrayList<Customer>();		

		return documents;
	}
	
}
