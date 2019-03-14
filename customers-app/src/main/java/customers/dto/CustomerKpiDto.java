package customers.dto;

public class CustomerKpiDto  {

	private double ageAverage;
	private double standardDeviation;
	
	public double getAgeAverage() {
		return ageAverage;
	}
	public void setAgeAverage(double ageAverage) {
		this.ageAverage = ageAverage;
	}
	public double getStandardDeviation() {
		return standardDeviation;
	}
	public void setStandardDeviation(double standardDeviation) {
		this.standardDeviation = standardDeviation;
	}
	
}
