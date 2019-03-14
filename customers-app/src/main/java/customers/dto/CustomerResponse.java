package customers.dto;

import java.util.Date;

public class CustomerResponse  {

	private int customerId;
	private String name;
	private String lastName;	
	private Date birthDate;
	private int age;
	private Date estimatedDeathDate;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getEstimatedDeathDate() {
		return estimatedDeathDate;
	}
	public void setEstimatedDeathDate(Date estimatedDeathDate) {
		this.estimatedDeathDate = estimatedDeathDate;
	}		
	
}
