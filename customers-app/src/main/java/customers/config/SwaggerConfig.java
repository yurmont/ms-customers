package customers.config;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {

		ResponseMessage okResponseMessage = new ResponseMessageBuilder().code(200).message("OK").build();
		ResponseMessage createdResponseMessage = new ResponseMessageBuilder().code(201).message("Created").build();
		ResponseMessage noContentResponseMessage = new ResponseMessageBuilder().code(204).message("No Content").build();
		ResponseMessage badRequestResponseMessage = new ResponseMessageBuilder().code(400).message("Bad Request")
				.build();
		ResponseMessage unauthorizedRequestResponseMessage = new ResponseMessageBuilder().code(401)
				.message("Unauthorized").build();
		ResponseMessage forbiddenResponseMessage = new ResponseMessageBuilder().code(403).message("Forbidden").build();
		ResponseMessage notFoundResponseMessage = new ResponseMessageBuilder().code(404).message("Not Found").build();
		ResponseMessage internalErrorResponseMessage = new ResponseMessageBuilder().code(500).message("Internal Error")
				.build();

		List<ResponseMessage> getGlobalResponses = Arrays.asList(okResponseMessage, badRequestResponseMessage,
				unauthorizedRequestResponseMessage, forbiddenResponseMessage, notFoundResponseMessage,
				internalErrorResponseMessage);

		List<ResponseMessage> postGlobalResponses = Arrays.asList(createdResponseMessage, badRequestResponseMessage,
				unauthorizedRequestResponseMessage, forbiddenResponseMessage, internalErrorResponseMessage);

		List<ResponseMessage> putGlobalResponses = Arrays.asList(okResponseMessage, badRequestResponseMessage,
				unauthorizedRequestResponseMessage, forbiddenResponseMessage, notFoundResponseMessage,
				internalErrorResponseMessage);

		List<ResponseMessage> deleteGlobalResponses = Arrays.asList(noContentResponseMessage, badRequestResponseMessage,
				unauthorizedRequestResponseMessage, forbiddenResponseMessage, notFoundResponseMessage,
				internalErrorResponseMessage);

		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.any()).build()
				.directModelSubstitute(LocalDate.class, String.class).genericModelSubstitutes(ResponseEntity.class)
				.apiInfo(apiInfo())				
				.globalResponseMessage(RequestMethod.GET, getGlobalResponses)
				.globalResponseMessage(RequestMethod.POST, postGlobalResponses)
				.globalResponseMessage(RequestMethod.PUT, putGlobalResponses)
				.globalResponseMessage(RequestMethod.DELETE, deleteGlobalResponses);
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Customers Api Documentation")
				.description("Customers endpoints.")
				.license("Test Version 0.0.1").version("0.0.1").build();
	}	
		
}