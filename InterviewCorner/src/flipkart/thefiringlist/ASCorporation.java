package flipkart.thefiringlist;

import java.util.HashMap;
import java.util.Map;

import flipkart.thefiringlist.Employee.Rating;

public class ASCorporation {
	private Map<Long, Employee> employees = new HashMap<Long, Employee>();
	
	public void addEmployee(Employee newEmployee) {
		this.employees.put(newEmployee.getEmployeeId(), newEmployee);
	}
	
	public static void main(String[] args) {
		ASCorporation org = new ASCorporation();
		
		Manager e1 = new Manager(100001, "E1", Rating.Ontarget, 55);
		Manager e2 = new Manager(100002, "E2", Rating.Ontarget, 23);
		Employee e3 = new Employee(100003, "E3", Rating.Ontarget, 25);
		Employee e4 = new Employee(100004, "E4", Rating.Outstanding, 33);
		Manager e5 = new Manager(100005, "E5", Rating.Exceptional, 40);
		Employee e6 = new Employee(100006, "E6", Rating.Ontarget, 15);
		Employee e7 = new Employee(100007, "E7", Rating.Exceptional, 25);
		Employee e8 = new Employee(100008, "E8", Rating.Outstanding, 20);
		Employee e9 = new Employee(100009, "E9", Rating.Outstanding, 30);
		Manager e10 = new Manager(100010, "E10", Rating.Exceptional, 30);
		Employee e11 = new Employee(100011, "E11", Rating.BelowAverage, 10);
		Employee e12 = new Employee(100012, "E12", Rating.Ontarget, 10);
		Employee e13 = new Employee(100013, "E13", Rating.Ontarget, 10);
		Employee e14 = new Employee(100014, "E14", Rating.Ontarget, 13);
		
		org.addEmployee(e1); org.addEmployee(e2); org.addEmployee(e3); org.addEmployee(e4);
		org.addEmployee(e5); org.addEmployee(e6); org.addEmployee(e7); org.addEmployee(e8);
		org.addEmployee(e9); org.addEmployee(e10); org.addEmployee(e11); org.addEmployee(e12);
		org.addEmployee(e13); org.addEmployee(e14); 

		
		e1.addReportee(e2);
		e1.addReportee(e3);
		e1.addReportee(e4);
		e1.addReportee(e5);

		
		e2.addReportee(e6);
		e2.addReportee(e7);
		e2.addReportee(e8);
		e2.addReportee(e9);

		
		e5.addReportee(e10);
		e5.addReportee(e11);
		e5.addReportee(e12);
		
		e10.addReportee(e13);
		e10.addReportee(e14);
		
		
		System.out.println(e1.getFireableEmployees(50));
	}

}
