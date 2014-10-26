package myjava.core.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternalizeTest {

	public static void main(String[] args) {
		//create object
		Car car = new Car("Maruthi Swift ZDi", 2013, "KA03-MT2165", "21.40");
		
		//Serialize object
		try {
			FileOutputStream outfile = new FileOutputStream("car.ext");
			ObjectOutputStream out = new ObjectOutputStream(outfile);
			out.writeObject(car);
			out.close();
			outfile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Deserialize object
		FileInputStream infile;
		Car newCar = null;
		try {
			infile = new FileInputStream("car.ext");
			ObjectInputStream in = new ObjectInputStream(infile);
			newCar  = (Car)in.readObject();
			infile.close();
			in.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if (newCar != null) {
			System.out.println(newCar);
		}
		
	}

}
