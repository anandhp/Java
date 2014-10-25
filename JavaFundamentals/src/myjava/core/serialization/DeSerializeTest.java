package myjava.core.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializeTest {

	public static void main(String[] args) {
		Employee employee = null;
		try {
			FileInputStream f = new FileInputStream("test.ser");
			ObjectInputStream o = new ObjectInputStream(f);
			employee  = (Employee)o.readObject();
			o.close();
			f.close();
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}

		if (employee != null) {
			System.out.println(employee.toString());
		}
	}

}
