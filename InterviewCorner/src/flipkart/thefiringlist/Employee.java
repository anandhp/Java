package flipkart.thefiringlist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Employee {
	
	public enum Rating {BelowAverage, Average, Ontarget, Outstanding, Exceptional}
	
	private long employeeId;
	private String name;
	private Rating rating;	//Holds value of 1-5
	private int salary; //Stored multiple of Ks
	
	public Employee(long employeeId, String name, Rating rating, int salary) {
		this.employeeId = employeeId;
		this.name = name;
		this.rating = rating;
		this.salary = salary;
	}
	
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public long getEmployeeId () { return this.employeeId; }
	public String getName() { return this.name; }
	public Rating getRating() { return this.rating; }
	public int getSalary() { return this.salary; }
	
	
	public class EmployeeComparator implements Comparator<Employee> {
		@Override
		public int compare(Employee employee, Employee otherEmployee) {
			int comparedValue = employee.getRating().ordinal() - otherEmployee.getRating().ordinal();
			if (comparedValue  == 0) {
				comparedValue = otherEmployee.getSalary() - employee.getSalary();
			}
			return comparedValue;
		}
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	public List<Employee> getFireableEmployees(double fp) {
		return new ArrayList<Employee>();
	}
}
