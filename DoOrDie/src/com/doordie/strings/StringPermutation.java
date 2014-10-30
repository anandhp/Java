package com.doordie.strings;

public class StringPermutation {
	
	public static void permuatations(String prefix, String str) {
		if (str.length() == 0) {
			System.out.println(prefix);
			return;
		}
		
		for (int i = 0; i < str.length(); i++)
			permuatations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()));
	}
	
	public static void permuatations(String str) {
		permuatations("", str);
	}

	public static void main(String[] args) {
		permuatations("ad");
	}

}
