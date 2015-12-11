package org.chairux.algebra.equation;

/**
 *@author eersya
 */

public class Demo {
	
	public static void main(String args[]) {
		String expr = "5x²*y²+4x²*2y²+6xy²*5y⁵+5+6";
		System.out.println("Expression: " + expr);
		Expression xpr = new Expression(expr);
		for(Term term : xpr.getTerms()) {
			System.out.println(term.toString());
		}
		System.out.println(Expression.isThereConcurrenceInVars(xpr) ? "si" : "no");
		String equations = "55x+5=4x*6xy*4xy";
		System.out.printf("Equation: %s\n", equations);
		System.out.println((Equation.isEquation(equations) ? "It's a equation." : "It isn't a equation."));
		Equation equation = new Equation(equations);
		System.out.printf("Left expression: %s Right expression: %s\n", equation.getLeftExpression().toString(), equation.getRightExpression().toString());
		for(Term term : equation.getRightExpression().getTerms()) {
			System.out.println(term.toString());
		}
	}

}
