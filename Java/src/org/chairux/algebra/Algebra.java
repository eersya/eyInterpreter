package org.chairux.algebra;

import org.chairux.algebra.equation.Term;
import org.chairux.algebra.equation.Variable;

/**
 *@author eersya
 */

public class Algebra {
	
	public static final char ADDITION = '+';
	public static final char SUBTRACTION = '-';
	public static final char MULTPLICATION = '*';
	public static final char DIVISION = '/';

	public static final char PARENTHESIS_L = '(';
	public static final char PARENTHESIS_R = ')';
	
	public static final String CONSTANT = "";
	public static final String VARIABLE = "VAR";
	
	public static final int POSITIVE = 1;
	public static final char POSITIVE_S = '+';
	public static final int NEGATIVE = -1;
	public static final char NEGATIVE_S = '-';
	
	public static final int NEGATIVE_POSITIVE = 0;
	
	public static boolean isNumber(String number) {
		try {
			Double.valueOf(number);
			return true;
		} catch(Exception ex) {
			return false;
		}
	}
	
	public static boolean isOperator(char c) {
		if(c == ADDITION)
			return true;
		else if(c == SUBTRACTION)
			return true;
		else if(c == MULTPLICATION)
			return true;
		else if(c == DIVISION)
			return true;
		else
			return false;
	}
	
	public static Term additionOf(Term augend, Term addend) {
		Double coefficient = augend.getCoefficient() + addend.getCoefficient();
		return new Term(((coefficient > NEGATIVE_POSITIVE) ? POSITIVE_S + coefficient.toString() : NEGATIVE_S + coefficient.toString())
				+ augend.getVariable().trim());
	}
	
	public static Term differenceOf(Term subtrahend, Term minuend) {
		Double coefficient = subtrahend.getCoefficient() - minuend.getCoefficient();
		return new Term(((coefficient > NEGATIVE_POSITIVE) ? POSITIVE_S + coefficient.toString() : NEGATIVE_S + coefficient.toString())
				+ subtrahend.getVariable());
	}
	
	public static Term multiplicationOf(Term multiplicand, Term multiplier) {
		int xExponent = (int) (Variable.getExponentOfX(multiplicand) + Variable.getExponentOfX(multiplier));
		int yExponent = (int) (Variable.getExponentOfY(multiplicand) + Variable.getExponentOfY(multiplier));
		String term = Term.makeTerm(multiplicand.getCoefficient() * multiplier.getCoefficient(), xExponent, yExponent);
		return new Term((term == null) ? "0" : term);
	}
	
}

