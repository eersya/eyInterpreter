package mx.eersya.algebra.equation;

import mx.eersya.algebra.Algebra;
import mx.eersya.algebra.Exponent;

/**
 *@author eersya
 */

public class Term extends Object {
	
    public static final int FIRST_CHAR = 0;
	
    private String variable;
    private Double coefficient;
    private char operator;
	
    public Term(String term) {
            
	variable = Variable.variableOf(term);
	coefficient = Coefficient.coefficientOf(term);
            
	if(Algebra.isOperator(term.charAt(Term.FIRST_CHAR)))
	    operator = term.charAt(Term.FIRST_CHAR);
	else 
	    operator = Algebra.ADDITION;
                
    }
        
    /**
     * @return the operator
     */
    public char getOperator() {
	return operator;
    }
	
    /**
     * @return the variable
     */
    public String getVariable() {
	return variable;
    }
	
    /**
     * @return the coefficient
     */
    public Double getCoefficient() {
	return coefficient;
    }
        
    @Override
    public String toString() {
	return operator + String.valueOf(coefficient) + variable;
    }
        
        
    /**
     * 
     * @param coefficient
     * @param xExponent
     * @param yExponent
     * @return 
     */
    public static String makeTerm(Double coefficient, int xExponent, int yExponent) {
	if(coefficient == 0)
	    return null;
	return ((coefficient > 0) ? Algebra.POSITIVE_S + coefficient.toString(): Algebra.NEGATIVE_S + coefficient.toString()) + 
	    ((xExponent == 0) ? "" : ((xExponent == 1) ? "x" : "x" + Exponent.getExponent(xExponent))) +
	    ((yExponent == 0) ? "" : ((yExponent == 1) ? "y" : "y" + Exponent.getExponent(yExponent)));
    }

}
