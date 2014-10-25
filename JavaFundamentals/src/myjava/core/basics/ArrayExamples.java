package myjava.core.basics;

import java.util.Arrays;

public class ArrayExamples {
	public class Solution {
		//create pascal triange for n rows
		int [][] pascalTriangle(int n) {
			int[][] result = new int[n][];
			for (int i = 0; i < n; i++) {
				result[i] = new int[i+1];
				result[i][0] = 1;
				for (int j = 1; j < i; j++)
					result[i][j] = result[i - 1][j] + result[i - 1][j - 1];
				result[i][i] = 1;
			}
			
			return result;
		}
		
		//find nth pascal row
		int[] pascalRow(int n) {
			int[] result = new int[n];
			
			for (int i = 0; i < n; i++) {
				result[i] = 1;
				for (int j  = i - 1; j > 0; j--)
					result[j] = result[j] + result[j - 1];
				result[0] = 1;
			}
			
			return result;
		}

	}
	public static void main(String[] args) {
		Solution soln = new ArrayExamples().new Solution();

		//print pascal triangle
		int[][] result = soln.pascalTriangle(6);
		for (int[] row : result)
			System.out.println(Arrays.toString(row));
		
		//nth pascal row
		int[] row = soln.pascalRow(6);
		System.out.println(Arrays.toString(row));
	}

}
