package com.doordie.problems;

public class BalancedParentheses {

	public static boolean isBalanced(String expression) {
		//number of open parentheses
		int openParanthesesCount = 0;
		
		for (int i = 0; i < expression.length(); i++) {
			//count the number of open parentheses
			if (expression.charAt(i) == '(')
				openParanthesesCount++;
			//remove the balanced closing parentheses
			else
				openParanthesesCount--;
			
			//if there was mis-matched closing parentheses
			//the this would be invalid expression
			if (openParanthesesCount < 0)
				return false;
		}
		
		//also if number of open paretheses have no matching
		//closing. that would also be a invalid expression
		
		return openParanthesesCount == 0;
	}
	
	public static void main(String[] args) {
		String[] tests = {"()()()", "(()", "((((((","))))))", "(())()(()())"};
		
		for (String test : tests)
			System.out.println(test +" is balanced ? " + BalancedParentheses.isBalanced(test));
	}

}
