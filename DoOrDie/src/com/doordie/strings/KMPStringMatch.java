package com.doordie.strings;

public class KMPStringMatch {

	private static int[] buildPrefixTable(String str) {
		int[] table = new int[str.length()];
		table[0] = 0;
		
		for (int i = 1, j = 0; i < str.length();) {
			if (str.charAt(i) == str.charAt(j)) {
				table[i] = j + 1;
				i++;
				j++;
			} else if (j > 0) {
				j = table[j - 1];
			} else 
				i++;
		}
		
		return table;
	}
	
	public static int stringMatch(String str, String match) {
		if (match == null || match.length() == 0)
			return 0;
		
		int[] table = KMPStringMatch.buildPrefixTable(match);
		
		for (int i = 0, j = 0; i < str.length();) {
			if (str.charAt(i) == match.charAt(j)) {
				if (j == match.length() - 1)
					return i - j;
				i++;
				j++;
			} else if (j > 0) {
				j = table[j - 1];
			}
			else 
				i++;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String[][] tests  = {
								{"abcde", "bc"},
								{"abced", "xyz"},
								{"this is a test", "test"},
								{"mississippi", "issip"}
							};
		
		for (String[] test : tests) {
			System.out.println(test[0] + " " + test[1]);
			System.out.println(" => " + KMPStringMatch.stringMatch(test[0], test[1]));
		}

	}

}
