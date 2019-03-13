package customers.service;

import java.util.List;

import customers.domain.Customer;

public interface CustomerService {
	
    List<Customer> search() throws Exception;

}
