package com.doordie.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Find number of occurrences of a sub-string in a given string.
 */

public class NumberOfOccurrencesSubStr {
	
	public static int numberOfOccurrencesStr(String str, String subStr) {
		int sLen = str.length();
		int subLen = subStr.length();
	
		if (str.length() == 0)
			return 0;
		
		Map<String, Integer> occurences = new HashMap<String, Integer>();
		
		for (int i = 0; i <= sLen - subLen; i++) {
			String sub = str.substring(i, i + subLen);
			Integer count = occurences.get(sub);
			if (count == null)
				occurences.put(sub, 1);
			else
				occurences.put(sub, count + 1);
		}
		
		Integer subCount =  occurences.get(subStr);
		return subCount == null ? 0 : subCount;
	}
	
	public static void main(String[] args) {
		Map<String, String[]> tests = new HashMap<String, String[]>();

		tests.put("abcdeaeac", new String[]{"a", "b", "c", "z", "e", "x"});
		tests.put("Test string and substring in a string", new String[]{"string", "sub", "a", "and", "Es", "test"});
		tests.put("", new String[]{});
		
		for (Map.Entry<String, String[]> test : tests.entrySet()) {
		
			System.out.println(test.getKey() + " " + Arrays.toString(test.getValue()));
			
			for (String testCase : test.getValue()) {
				System.out.print(testCase + " ");
				System.out.println(NumberOfOccurrencesSubStr.numberOfOccurrencesStr(test.getKey(), testCase));
			}
			
			System.out.println();
		}
	}

}
