package customers.domain;

import java.util.Date;

public class Customer {

	private int customerId;
	private String name;
	private String lastName;	
	private Date birthDate;	
	
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
	public Date getEstimatedDeathDate() {
		return estimatedDeathDate;
	}
	public void setEstimatedDeathDate(Date estimatedDeathDate) {
		this.estimatedDeathDate = estimatedDeathDate;
	}	
			
}
