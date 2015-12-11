package org.chairux.algebra.equation;

/**
 *@author eersya
 */

public class Equation {
	
	public static final char EQUALS_SIGN = '=';
	public static final int TOO_MUCH_EQUALS = 2;

	private String equation;
	
	private Expression leftExpression;
	private Expression rightExpression;
	  
	public Equation(String equation) {
		//validate equation
	    this.setEquation(equation);
	    this.loadMainExpressions();
	}

	/**
	 * @return the equation
	 */
	public String getEquation() {
		return equation;
	}

	/**
	 * @param equation the equation to set
	 */
	public void setEquation(String equation) {
		this.equation = equation;
	}
	
	/**
	 * @return the leftExpression
	 */
	public Expression getLeftExpression() {
		return leftExpression;
	}
	
	/**
	 * @return the rightExpression
	 */
	public Expression getRightExpression() {
		return rightExpression;
	}
	
	/**
	 * 
	 * @param any string
	 * @return 
	 */
	public static boolean isEquation(String str) {
		//
		if(str.charAt(str.length() - 1) == EQUALS_SIGN)
			return false;
		
		int numEquals = 0;
		for(char c : str.toCharArray()) {
			if(c == EQUALS_SIGN)
				numEquals++;
			if(numEquals >= TOO_MUCH_EQUALS)
				return false;
		}
		
		return true;
	}
	
	private void loadMainExpressions() {
		int beginIndex = 0, endIndex = 0;
		int positionEqualsS = equation.indexOf(EQUALS_SIGN);
		endIndex = positionEqualsS;
		leftExpression = new Expression(equation.substring(beginIndex, endIndex));
		beginIndex = positionEqualsS + 1;
		endIndex = equation.length();
		rightExpression = new Expression(equation.substring(beginIndex, endIndex));
	}
	
	public void equalsToZero() {
		
	}
	
}
