package customers.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customers.dto.CustomerDto;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/customers")
public class CustomerController {

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CustomerDto>> search() throws Exception {

		return new ResponseEntity<>(null, HttpStatus.OK);
	}	

}
