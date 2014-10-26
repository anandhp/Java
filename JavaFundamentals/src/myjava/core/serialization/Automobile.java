package myjava.core.serialization;

public class Automobile {

	private String regNo;
	private String mileage;
	
	public Automobile() {}
	
	public Automobile(String regNo, String mileage) {
		this.regNo = regNo;
		this.mileage = mileage;
	}
	
	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}
	
	public String getRegNo() {
		return regNo;
	}
	
	public String getMileage() {
		return mileage;
	}
	
	public void setMileage(String mileage) {
		this.mileage = mileage;
	}
	
	public String toString() {
		return this.regNo + " " + this.mileage;
	}
}
