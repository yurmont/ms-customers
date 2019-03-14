package customers.service;

import java.util.List;

import customers.dto.CustomerDto;
import customers.dto.CustomerKpiDto;

public interface CustomerService {
	
	void insert(CustomerDto customer);
	
	CustomerKpiDto getCustomerKpi();
	
    List<CustomerDto> findAll();

}
