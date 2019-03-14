package customers.service;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.domain.Customer;
import customers.dto.CustomerResponse;
import customers.dto.CustomerKpiResponse;
import customers.dto.CustomerCreateRequest;
import customers.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

	static final int LIFE_EXPECTANCY_IN_YEARS = 75;

	@Autowired
	public CustomerRepository customerRepository;

	@Override
	public Integer create(CustomerCreateRequest request) {
		Customer customer = new Customer();
		customer.setName(request.getName());
		customer.setLastName(request.getLastName());
		customer.setBirthDate(request.getBirthDate());

		return customerRepository.insert(customer);
	}

	@Override
	public CustomerKpiResponse getKpi() {

		List<CustomerResponse> customerResponseDtos = findAll();
		CustomerKpiResponse customerKpi = new CustomerKpiResponse();

		double ageAverage = calculateAgeAverage(customerResponseDtos);
		double standardDeviation = calculateStandardDeviation(customerResponseDtos, ageAverage);

		customerKpi.setAgeAverage(ageAverage);
		customerKpi.setStandardDeviation(standardDeviation);

		return customerKpi;
	}

	@Override
	public List<CustomerResponse> findAll() {

		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponse> customerResponseDtos = new ArrayList<CustomerResponse>();

		for (Customer customer : customers) {
			CustomerResponse customerDto = new CustomerResponse();
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setName(customer.getName());
			customerDto.setLastName(customer.getLastName());
			customerDto.setBirthDate(customer.getBirthDate());
			customerDto.setAge(calculateCustomerAge(customer.getBirthDate()));
			customerDto.setEstimatedDeathDate(calculateEstimatedDeathDate(customer.getBirthDate()));

			customerResponseDtos.add(customerDto);
		}

		return customerResponseDtos;
	}

	private int calculateCustomerAge(Date birthDate) {
		Period period = new Period(new DateTime(birthDate), new DateTime());
		return period.getYears();
	}

	private Date calculateEstimatedDeathDate(Date birthDate) {
		DateTime birthDateTime = new DateTime(birthDate);
		DateTime estimatedDeathDatetime = birthDateTime.plusYears(LIFE_EXPECTANCY_IN_YEARS);

		return estimatedDeathDatetime.toDate();
	}

	private double calculateStandardDeviation(List<CustomerResponse> customerDtos, double ageAverage) {
		double standardDeviation = 0.0;

		for (CustomerResponse customerDto : customerDtos) {
			standardDeviation += Math.pow(customerDto.getAge() - ageAverage, 2);
		}
		return Math.sqrt(standardDeviation / (customerDtos.size() - 1));
	}

	private double calculateAgeAverage(List<CustomerResponse> customerDtos) {
		double ageSum = customerDtos.stream().mapToDouble(a -> a.getAge()).sum();
		double ageAverage = ageSum / customerDtos.size();

		return ageAverage;
	}
}
