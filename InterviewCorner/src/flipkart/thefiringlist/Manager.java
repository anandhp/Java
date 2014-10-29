package flipkart.thefiringlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Manager extends Employee {
	private Set<Employee> reportees = new TreeSet<Employee>(new EmployeeComparator());
	
	public Manager(long employeeId, String name, Rating rating, int salary) {
		super(employeeId, name, rating, salary);
	}
	
	public void addReportee(Employee reportee) {
		this.reportees.add(reportee);
	}
	
	public List<Employee> getFireableEmployees(double fp) {
		int numberOfEmployees = (int)Math.ceil((reportees.size() * fp) / 100);
		List<Employee> fireList = new ArrayList<Employee>();
		for (Employee e : reportees) {
			if (numberOfEmployees > 0)
				fireList.add(e);
			fireList.addAll(e.getFireableEmployees(fp));
			numberOfEmployees--;
		}
		
		return fireList;
	}

}
