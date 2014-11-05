package com.doordie.strings;

/**
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * 		Given s = "the sky is blue",
 * 		return "blue is sky the".
 *
 */

public class ReverseWordsInString {

	public static String reverseWords(String s) {
		StringBuilder result = new StringBuilder();

		for (int i = s.length() - 1, end = 0; i >=0 ; i--) {
			char c = s.charAt(i);
			if (c != ' ')
				result.insert(end, c);
			else if (result.length() > 0 
						&& result.charAt(result.length() - 1) != ' ') {
				result.append(c);
				end = result.length();
			}
		}

		if (result.length() > 0 
				&& result.charAt(result.length() - 1) == ' ')
			result.deleteCharAt(result.length() - 1);
		
		return result.toString();
	}
	
	public static void main(String[] args) {
		String[] tests = {
							"the sky is blue",
							"This is a string",
							"   Test this String  ",
							"   ",
							"   a b ",
							"a"
							
						 };
		
		for (String test : tests) {
			System.out.println(test);
			System.out.println(ReverseWordsInString.reverseWords(test));
			System.out.println();
		}
	}

}
