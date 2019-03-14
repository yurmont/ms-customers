package customers.repository;

import java.util.List;

import customers.domain.Customer;

public interface CustomerRepository {
	
	Integer insert(Customer customer);
	
	List<Customer> findAll();	

}
