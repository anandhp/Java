package myjava.core.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Car extends Automobile implements Externalizable {

	private String name;
	private int manufactureYear;
	
	public Car() {}
	
	public Car(String name, int year, String regNo, String mileage) {
		super(regNo, mileage);
		this.name = name;
		this.manufactureYear = year;
	}
	
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(super.getMileage());
		out.writeObject(super.getRegNo());
		out.writeObject(name);
		out.writeInt(manufactureYear);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {
		super.setMileage((String)in.readObject());
		super.setRegNo((String)in.readObject());
		this.name = (String)in.readObject();
		this.manufactureYear = in.readInt();
	}
	
	public String toString() {
		return  name + " " + manufactureYear + " " + super.toString();
	}

}
