package myjava.core.basics;

public class StringExamples {

	public class Solution {
		public String reverseWords(String s) {
			if (s == null || s.isEmpty())
				return s;
			
			String []words = s.split("\\s+");
			StringBuilder result = new StringBuilder();
			
			for (String word : words) {
				if (word.isEmpty())
					continue;
				result.insert(0, word);
				result.insert(0, ' ');
			}
			
			return result.length() > 0 ? result.substring(1, result.length()) : "";
		}
	}
	
	public static void main(String[] args) {
		String before = "The Sky is blue";
		Solution soln = new StringExamples().new Solution();
		String after = soln.reverseWords(before);
		System.out.println(before + " >> " + after);
	}
}
