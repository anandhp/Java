package com.doordie.strings;

/**
 * Given a string S and a string T, find the minimum window 
 * in S which will contain all the characters in T in complexity O(n).
 * 
 * For example,
 * 	S = "ADOBECODEBANC"
 * 	T = "ABC"
 * 	Minimum window is "BANC".
 * 	
 * 	Note:
 * 	If there is no such window in S that covers all characters in T,
 *  return the emtpy string "".
 *  
 *  If there are multiple such windows, you are guaranteed that there 
 *  will always be only one unique minimum window in S.
 *  
 */

public class MinimumWindowSubstring {

	public static String minWindow(String S, String T) {
        int sLen = S.length();
        int tLen = T.length();
        
        if (sLen == 0 || tLen == 0 || tLen > sLen)
        	return "";
        
        int[] toFind = new int[256];
        int[] found = new int[256];
        
        for (int i = 0; i < tLen; i++)
        	toFind[T.charAt(i)]++;
        
        int count = 0;
        
        String result = null;
        
        for (int begin = 0, end = 0; end < sLen; end++) {
        	char current = S.charAt(end);
        	//if current character is not part of search string
        	//move forward for next string
        	if (toFind[current] == 0)
        		continue;
        	
        	//found the character that is part of search string
        	found[current]++;
        	
        	//check if found all the characters of the search string
        	if (found[current] <= toFind[current])
        		count++;
        	
        	if (count == tLen) {
        		int beginChar = S.charAt(begin);
        		
        		while (toFind[beginChar] == 0 
        				|| found[beginChar] > toFind[beginChar]) {
        			if (found[beginChar] > toFind[beginChar]) {
        				found[beginChar]--; 
        			}
    				beginChar = S.charAt(++begin);
        		}
        		
        		int newLen = end - begin + 1;
        		if (result == null || result.length() > newLen)
        			result = S.substring(begin, end + 1);
        	}
        }
        
        return result.toString();
    }

	public static void main(String[] args) {
		String[][] tests = {
								{"ADOBECODEBANC", "ABC"},
								{"a", "aa"}
								
							 };
		for (String[] test : tests)
			System.out.println(MinimumWindowSubstring.minWindow(test[0], test[1]));
	}

}
