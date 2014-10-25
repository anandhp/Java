package myjava.core.collections;
import java.util.*;

public class MapTest {

	public static void main(String[] args) {
		Map<String, String> staff = new HashMap<String, String>();
		staff.put("111", "ABC");
		staff.put("112", "DEF");
		staff.put("113", "GHI");
		
		System.out.println(staff);
		
		staff.remove("111");
		staff.put("112", "ABC");
		
		System.out.println(staff);
		
		for(Map.Entry<String, String> e : staff.entrySet()) {
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}	

}
