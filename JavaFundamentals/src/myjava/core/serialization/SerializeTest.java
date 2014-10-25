package myjava.core.serialization;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeTest {
	public static void main(String[] args) {
		Employee e = new Employee("XYZ", "ABC, WUXYZ", 1122, 1100);
		try {
			FileOutputStream f = new FileOutputStream("test.ser");
			ObjectOutputStream o = new ObjectOutputStream(f);
			o.writeObject(e);
			o.close();
			f.close();
			
		}catch (IOException i) {
			System.out.println(i.getMessage());
		}
	}

}
