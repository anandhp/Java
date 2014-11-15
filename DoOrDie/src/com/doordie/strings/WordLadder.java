package com.doordie.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * For example,
 * 
 * Given:
 * 	start = "hit"
 * 	end = "cog"
 * 	dict = ["hot","dot","dog","lot","log"]
 * 	As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 	return its length 5.
 * 
 * Note:
 * 	Return 0 if there is no such transformation sequence.
 * 	All words have the same length.
 * 	All words contain only lowercase alphabetic characters.
 *
 */

public class WordLadder {
    public static int ladderLength(String start, String end, Set<String> dict) {
    	if (dict.size() == 0)
    		return 0;
    	
    	Queue<String> wordsQueue = new LinkedList<String>();
    	Queue<Integer> distanceQueue = new LinkedList<Integer>();
    	
    	wordsQueue.add(start);
    	distanceQueue.add(1);
    	dict.add(end);
    	
    	while (!wordsQueue.isEmpty()) {
    		String currentWord = wordsQueue.poll();
    		Integer currentDistance = distanceQueue.poll();

    		if (currentWord.equals(end))
    			return currentDistance;
    		
    		for (char c = 'a'; c <= 'z'; c++) {
    			for (int i = 0; i < currentWord.length(); i++) {
    				char[] word = currentWord.toCharArray();
    				word[i] = c;
    				String newWord = new String(word);
    				if (dict.contains(newWord)) {
    					wordsQueue.add(newWord);
    					distanceQueue.add(currentDistance + 1);
    					dict.remove(newWord);
    				}
    			}
    		}
    	}
    	
    	return 0;
    }
    
    public static List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> result = new ArrayList<List<String>>();
    	Queue<String> wordsQueue = new LinkedList<String>();
    	
    	List<String> current = new ArrayList<String>();

    	dict.add(end);
    	wordsQueue.add(start);
    	
    	while (!wordsQueue.isEmpty()) {
    		String currentWord = wordsQueue.poll();
        	current.add(start);
    		
    		if (currentWord.equals(end)) {
    			result.add(new ArrayList<String>(current));
    		}
    		
    		for (int i = 0; i < currentWord.length(); i++) {
    			for (char c = 'a'; c <= 'z'; c++) {
    				char[] chars = currentWord.toCharArray();
    				chars[i] = c; 
    				String newWord = new String(chars);
    				if (dict.contains(newWord)) {
    					wordsQueue.add(newWord);
    					dict.remove(newWord);
    				}
    			}
    		}
    	}
    	
    	return result;
    }
    
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("hot");
		dict.add("dot");
		dict.add("dog");
		dict.add("lot");
		dict.add("log");
		
		String[][] tests = {
								{"hit", "cog"},
								{"lit", "pot"}
						   };
		
		for (String[] test : tests) {
			int length = WordLadder.ladderLength(test[0], test[1], new HashSet<String>(dict));
			System.out.println(test[0] + " => " + test[1] + " is " + length);
		}
		
		for (String[] test : tests) {
			List<List<String>> result = WordLadder.findLadders(test[0], test[1], dict);
			System.out.println(result);
		}
	}

}
