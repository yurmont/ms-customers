package customers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "customers")
@EnableSwagger2
public class CustomerMicroService {	
	public static void main(String[] args) {
		SpringApplication.run(CustomerMicroService.class, args);
	}
}
 