package customers.service;

import java.util.List;

import customers.dto.CustomerResponse;
import customers.dto.CustomerKpiResponse;
import customers.dto.CustomerCreateRequest;

public interface CustomerService {
	
	Integer create(CustomerCreateRequest request);
	
	CustomerKpiResponse getKpi();
	
    List<CustomerResponse> findAll();
}
