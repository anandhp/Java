package com.doordie.designpatterns.behavioral;

/**
 * 
 * CHAIN-OF-RESPONSIBILITY avoids coupling the sender of a request 
 * to its receiver by giving more than one object a chance to handle
 * the request. Chain the receiving objects and pass the request along
 * the chain until an object handles it.
 * 
 * Consider an evaluation of mathematical basic expression. Here different
 * mathematical operations can be handled by chaining them together.
 * Each expression evaluation class handles if it is responsible else
 * passes on to next evaluator on the chain
 * 
 */


public class ChainOfResponsibility {

	//Abstract Operation
	public interface Calculation {
		public void addNextCalculation(Calculation calc);
		public void calculate(Equation equation);
	}
	
	//Concrete operations in the chain
	public static class Add implements Calculation {
		private Calculation nextCalcuation;

		@Override
		public void addNextCalculation(Calculation calc) {
			nextCalcuation = calc;
		}

		@Override
		public void calculate(Equation equation) {
			int op1 = equation.getLeft();
			int op2 = equation.getRight();
			
			if (equation.getOperation().equals("Add")) {
				System.out.println(op1 + " + " + op2 + " = " + (op1 + op2));
			} else {
				nextCalcuation.calculate(equation);
			}
		}
	}
	
	public static class Subtract implements Calculation {
		private Calculation nextCalcuation;

		@Override
		public void addNextCalculation(Calculation calc) {
			nextCalcuation = calc;
		}

		@Override
		public void calculate(Equation equation) {
			int op1 = equation.getLeft();
			int op2 = equation.getRight();
			
			if (equation.getOperation().equals("Sub")) {
				System.out.println(op1 + " - " + op2 + " = " + (op1 - op2));
			} else {
				nextCalcuation.calculate(equation);
			}
			
		}
	}
	
	public static class Multiply implements Calculation {
		private Calculation nextCalcuation;

		@Override
		public void addNextCalculation(Calculation calc) {
			nextCalcuation = calc;
		}

		@Override
		public void calculate(Equation equation) {
			int op1 = equation.getLeft();
			int op2 = equation.getRight();
			
			if (equation.getOperation().equals("Mul")) {
				System.out.println(op1 + " * " + op2 + " = " + (op1 * op2));
			} else {
				nextCalcuation.calculate(equation);
			}
		}
	}
	

	public static class Division implements Calculation {

		@Override
		public void addNextCalculation(Calculation calc) {
			//no next operation here
		}

		@Override
		public void calculate(Equation equation) {
			int op1 = equation.getLeft();
			int op2 = equation.getRight();
			
			if (equation.getOperation().equals("Div")) {
				System.out.println(op1 + " / " + op2 + " = " + (op1 / op2));
			} else {
				System.out.println("Oopps!! Looks like unsupported operation.");
			}
		}
	}
	
	//Object on which different operations are executed
	public static  class Equation  {
		private int operandLeft;
		private int operandRight;
		
		private String operation;
		
		public Equation(int left, int right, String operation) {
			operandLeft = left;
			operandRight = right;
			this.operation = operation;
		}
		
		public int getLeft() { return this.operandLeft; }
		public int getRight() { return this.operandRight; }
		
		public String getOperation () { return this.operation; }
	}
	
	//ChainOfResponsibility tester
	public static void main(String[] args) {
		
		//Different responsibilities
		Calculation add = new Add();
		Calculation sub = new Subtract();
		Calculation mul = new Multiply();
		Calculation div = new Division();
		
		//Build chain
		add.addNextCalculation(sub);
		sub.addNextCalculation(mul);
		mul.addNextCalculation(div);
		
		//Execute operation
		Equation equation = new Equation(4, 2, "Add");
		add.calculate(equation);
	}

}
