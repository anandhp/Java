package com.doordie.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given array of strings, return all strings
 * which are anagrams of each other
 * 
 * For example:
 *		Input  = ["and", "dan", "xyz"]
 *		Output = ["and", "dan"]
 */

public class Anagrams {
	public static List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        Map<String, Integer> strMap = new HashMap<String, Integer>();
        
        int index = 0;
        for(String str : strs) {
        	//sort the chars in current string
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String sstr = new String(chars);
        	
        	if (strMap.get(sstr) == null) {
        		strMap.put(sstr, index);
        	} else {
        		if (strMap.get(sstr) >= 0) {
        			result.add(strs[strMap.get(sstr)]);
        			strMap.put(sstr, -1);
        		}
        		result.add(strs[index]);
        	}
        	index++;
        }
        
        return result;
    }

	public static void main(String[] args) {
		String[] tests = {"and","dan", "xyz"};
		List<String> result = Anagrams.anagrams(tests);
		System.out.println(result);
	}

}
