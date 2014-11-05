package com.doordie.strings;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty 
 * space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space 
 * characters only.
 * 
 * For example,
 * 		Given s = "Hello World", return 5.
 *
 */

public class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		int length = 0, index = s.length();

		while (--index >= 0) {
			if (s.charAt(index) != ' ')
				length++;
			else if (length > 0) 
                break;
		}
		return length;  
	}

	public static void main(String[] args) {
		String[] tests = {"abcd", "a   ", "a  a", "abcd, ab ebc"};
		
		for (String test : tests)
			System.out.println("Length of last word in '" 
								+ test + "' is "	
								+ LengthOfLastWord.lengthOfLastWord(test));
	}

}
