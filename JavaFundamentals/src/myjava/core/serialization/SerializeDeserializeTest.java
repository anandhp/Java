package myjava.core.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserializeTest {
	public static void main(String[] args) {
		//Create object
		Employee e = new Employee("XYZ", "ABC, WUXYZ", 1122, 1100);
		
		//Serialize object
		try {
			FileOutputStream f = new FileOutputStream("test.ser");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(e);
			o.close();
			f.close();
			
		}catch (IOException i) {
			System.out.println(i.getMessage());
		}
		
		//De-serialize object
		Employee employee = null;
		try {
			FileInputStream f = new FileInputStream("test.ser");
			ObjectInputStream o = new ObjectInputStream(f);
			employee  = (Employee)o.readObject();
			o.close();
			f.close();
		}catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}catch (ClassNotFoundException ioe) {
			System.out.println(ioe.getMessage());
		}

		if (employee != null) {
			System.out.println(employee.toString());
		}		
	}

}
