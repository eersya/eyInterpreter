package org.chairux.algebra.equation;

import org.chairux.algebra.Algebra;

/**
 *@author eersya
 */

public class Coefficient {
	
	/**
	 * 
	 * @param term
	 * @return the coefficient of term
	 */
	public static Double coefficientOf(String term) {
            
		if(term.charAt(Term.FIRST_CHAR) == Algebra.NEGATIVE_S && !Variable.anyVariable(term))
			return Double.valueOf(term.substring(1, term.length())) * Algebra.NEGATIVE;
		else if(!Variable.anyVariable(term))
			return Double.valueOf(term.substring(1, term.length()));
		
		int sign = (term.charAt(Term.FIRST_CHAR) == Algebra.NEGATIVE_S) ? Algebra.NEGATIVE: Algebra.POSITIVE;
		String termU = (Algebra.isOperator(term.charAt(Term.FIRST_CHAR))) ? term.substring(1): term;
		
		int beginIndex = 0;
		int endIndex = 0;
		for(int cur = 0; cur < termU.length(); cur++) {
			if(Character.isAlphabetic(termU.charAt(cur))) {
				endIndex = cur;
				break;
			}
		}
		
		if(endIndex == 0)
			return Double.valueOf(1 * sign);
		
		
		return Double.valueOf(termU.substring(beginIndex, endIndex)) * sign;
	}

}
