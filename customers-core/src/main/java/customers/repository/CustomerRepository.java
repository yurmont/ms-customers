package customers.repository;

import java.util.List;

import customers.domain.Customer;

public interface CustomerRepository {
	
	List<Customer> search();

}
