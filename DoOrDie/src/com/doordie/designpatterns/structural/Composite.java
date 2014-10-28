package com.doordie.designpatterns.structural;

import java.util.ArrayList;
import java.util.List;

public class Composite {

	public abstract class Employee {
		private String name;
		private String phoneNumber;
		
		public Employee(String name, String phoneNumber) {
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
		
		public String name() {
			return this.name;
		}
		
		public String phone() {
			return this.phoneNumber;
		}
		
		public abstract void display();
	}
	
	public class Engineer extends Employee {
		public Engineer(String name, String phoneNumber) {
			super(name, phoneNumber);
		}
		
		@Override
		public void display() {
			System.out.println("Name: " + super.name() + ", Phone: " + super.phone());
		}
	}
	
	//Composite class
	public class Manager extends Employee {
		private List<Employee> reportees;
		
		public Manager(String name, String phoneNumber) {
			super(name, phoneNumber);
			reportees= new ArrayList<Employee>();
		}
		
		public void addReportee(Employee employee) {
			reportees.add(employee);
		}
		
		@Override
		public void display() {
			System.out.println("\nName: " + super.name() + ", Phone: " + super.phone());
			System.out.println("Manages :");
			for (Employee e : reportees) {
				e.display();
			}
		}
	}

	//Composite pattern tester
	public static void main(String[] args) {
		
		Employee srEngineer = new Composite().new Engineer("ABC", "888-202-344");
		Employee fresher = new Composite().new Engineer("DEF", "888-302-444");

		Manager manager = new Composite().new Manager("XYZ", "888-204-203");
		manager.addReportee(srEngineer);
		manager.addReportee(fresher);
		
		srEngineer.display();
		fresher.display();
		manager.display();
	}

}
