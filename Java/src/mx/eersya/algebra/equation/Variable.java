package mx.eersya.algebra.equation;

import mx.eersya.algebra.Algebra;
import mx.eersya.algebra.Exponent;

/**
 *@author eersya
 */

public class Variable {
	
    public static final char X = 'x';
    public static final char Y = 'y';
    public static final char Z = 'z';
	
    public static boolean findVariable() {
	return false;
    }
	
    public static String variableOf(String term) {
	if(Algebra.isNumber(term))
	    return Algebra.CONSTANT;
		
	int beginIndex = 0;
	int endIndex = term.length();
	for(int cur = 0; cur < term.length(); cur++) {
	    if(Character.isAlphabetic(term.charAt(cur))) {
		beginIndex = cur;
		break;
	    }
	}
		
	return term.substring(beginIndex, endIndex);
    }
	
    public static Integer getExponentOfX(Term term) {
	if(term.getVariable().indexOf(X) == -1)
	    return Exponent.ANY_EXPONENT;;
	int beginIndex = term.getVariable().indexOf(X) + 1;
	int endIndex = term.getVariable().indexOf(Y);
	if(endIndex == -1 || endIndex == 0)
	    endIndex = term.getVariable().length();
	if(beginIndex == endIndex)
	    return 1;
		
	return Exponent.valueOf(term.getVariable().substring(beginIndex, endIndex));
    }
	
    public static Integer getExponentOfY(Term term) {
	if(term.getVariable().indexOf(Y) == -1)
	    return Exponent.ANY_EXPONENT;
	int beginIndex = term.getVariable().indexOf(Y) + 1;
	int endIndex = term.getVariable().indexOf(X);
	if(endIndex == -1 || endIndex == 0)
	    endIndex = term.getVariable().length();
		
	if(beginIndex == endIndex)
	    return 1;
		
	return Exponent.valueOf(term.getVariable().substring(beginIndex, endIndex));
    }

    public static boolean sameVariables(Term term1, Term term2) {
	if(term1.getVariable().equals(term2.getVariable()))
	    return true;
	else
	    return false;
    }
	
    public static boolean anyVariable(String term) {
	for(char c : term.toCharArray()) {
	    if(c == Variable.X || c == Variable.Y)
		return true;
	}
	return false;
    }
	
}
