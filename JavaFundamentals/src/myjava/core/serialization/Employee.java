package myjava.core.serialization;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	private String name;
	private String address;
	private transient int SSN;
	private int number;
	
	public Employee(String name, String address, int SSN, int number) {
		this.name = name;
		this.address = address;
		this.SSN = SSN;
		this.number = number;
	}
	
	public String toString() {
		return name + " " + address + " " + SSN + " " + number;
	}
}
