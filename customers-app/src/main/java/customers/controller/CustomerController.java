package customers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import customers.dto.CustomerCreateRequest;
import customers.dto.CustomerKpiResponse;
import customers.dto.CustomerResponse;
import customers.service.CustomerService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public ResponseEntity<Integer> create(@RequestBody CustomerCreateRequest request) {

		Integer customerId = customerService.create(request);

		return new ResponseEntity<Integer>(customerId, HttpStatus.CREATED);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/kpi")
	public ResponseEntity<CustomerKpiResponse> getKpi() {

		CustomerKpiResponse kpi = customerService.getKpi();

		return new ResponseEntity<CustomerKpiResponse>(kpi, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerResponse>> findAll() {

		List<CustomerResponse> customers = customerService.findAll();

		return new ResponseEntity<List<CustomerResponse>>(customers, HttpStatus.OK);
	}

}
