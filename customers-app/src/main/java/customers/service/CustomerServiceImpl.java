package customers.service;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import customers.domain.Customer;
import customers.dto.CustomerDto;
import customers.dto.CustomerKpiDto;
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
	public void insert(CustomerDto customerDto) {
		Customer customer = new Customer();
		customer.setName(customerDto.getName());
		customer.setName(customerDto.getLastName());
		customer.setBirthDate(customerDto.getBirthDate());

		customerRepository.insert(customer);
	}

	@Override
	public CustomerKpiDto getCustomerKpi() {

		List<CustomerDto> customerDtos = findAll();
		CustomerKpiDto customerKpi = new CustomerKpiDto();

		double ageAverage = calculateAgeAverage(customerDtos);
		double standardDeviation = calculateStandardDeviation(customerDtos, ageAverage);

		customerKpi.setAgeAverage(ageAverage);
		customerKpi.setStandardDeviation(standardDeviation);

		return customerKpi;
	}

	@Override
	public List<CustomerDto> findAll() {

		List<Customer> customers = customerRepository.findAll();
		List<CustomerDto> customerDtos = new ArrayList<CustomerDto>();

		for (Customer customer : customers) {
			CustomerDto customerDto = new CustomerDto();
			customerDto.setCustomerId(customer.getCustomerId());
			customerDto.setName(customer.getName());
			customerDto.setLastName(customer.getLastName());
			customerDto.setBirthDate(customer.getBirthDate());
			customerDto.setAge(calculateCustomerAge(customer.getBirthDate()));
			customerDto.setEstimatedDeathDate(calculateEstimatedDeathDate(customer.getBirthDate()));

			customerDtos.add(customerDto);
		}

		return customerDtos;
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

	private double calculateStandardDeviation(List<CustomerDto> customerDtos, double ageAverage) {
		double standardDeviation = 0.0;

		for (CustomerDto customerDto : customerDtos) {
			standardDeviation += Math.pow(customerDto.getAge() - ageAverage, 2);
		}
		return standardDeviation;
	}

	private double calculateAgeAverage(List<CustomerDto> customerDtos) {
		double ageSum = customerDtos.stream().mapToDouble(a -> a.getAge()).sum();
		double ageAverage = ageSum / customerDtos.size();
		
		return ageAverage;
	}
}
