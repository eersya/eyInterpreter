package org.chairux.algebra.equation;

import java.util.ArrayList;

import org.chairux.algebra.Algebra;

/**
 *@author eersya
 */

public class Expression extends Object{
	
    private ArrayList<Term> terms;
    
    public Expression(String expresion) {
        terms = new ArrayList<>();
        this.loadTerms(expresion);
        if(Expression.isThereConcurrenceInVars(this))
            this.simplifyExpression();
    }
	
    /**
     * @return the terms of the expression
     */
    public ArrayList<Term> getTerms() {
        return terms;
    }
        
    private void loadTerms(String expression) {
		
        int beginIndex = 0, endIndex = 0;
        for(int cur = 0; cur < expression.length(); cur++) {
            
            if(Algebra.isOperator(expression.charAt(cur))) {
                
                if(Algebra.isOperator(expression.charAt(cur)) && cur == 0) {
                    continue;
                }
                
                endIndex = cur;
                terms.add(new Term(expression.substring(beginIndex, endIndex)));
                beginIndex = endIndex;
            }
            if(cur == expression.length() - 1) {
                endIndex = expression.length();
                terms.add(new Term(expression.substring(beginIndex, endIndex)));
            }
            
        }
        
    }

	private void simplifyExpression() {
		doMultliplications();
		
		if(Expression.isThereConcurrenceInVars(this))
			reduceTerms();		
	}

    // It should be more complex
    public void doMultliplications() {
        for(int cur = 0; cur < terms.size(); cur++) {
            if(terms.get(cur).getOperator() == Algebra.MULTPLICATION) {
                Term curTerm = Algebra.multiplicationOf(terms.get(cur - 1), terms.get(cur));
                if(curTerm.getCoefficient() != 0) {
                    terms.set(cur, curTerm); // We need to overwrite, because the curTerm is in cur
                    terms.remove(cur -1);
                    cur = 0;
                } else {
                    terms.remove(cur - 1);
                    terms.remove(cur - 1);
                }
            }
        }
    }
	
    // It should be more complex
    public void reduceTerms() {
        for(int cur = 0; cur < terms.size(); cur++) {
            for(int curTerm = 0; curTerm < terms.size(); curTerm++) {
                
                if(!Expression.isThereConcurrenceInVars(this))
                    break;
				
                if(cur != curTerm && terms.get(cur).getVariable().equals(terms.get(curTerm).getVariable())) {
                    Term reducedTerm = Algebra.additionOf(terms.get(cur), terms.get(curTerm));
                    if(reducedTerm.getCoefficient() != 0)
                        terms.set(cur, reducedTerm);
                    terms.remove(curTerm);
                    cur = 0;
                    curTerm = 0;
                }
            }
        }
    }
	
	
    /**
     * Returns true id there is concurrence in variables.
     * @param expression
     * @return 
     */
    public static boolean isThereConcurrenceInVars(Expression expression) {
        for(Term term : expression.getTerms()) {
            for(Term curTerm : expression.getTerms()) {
                if(!term.equals(curTerm) && term.getVariable().equals(curTerm.getVariable()))
                    return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        String expression;
        for(Term term : this.getTerms()) {
            expression = term.toString();
        }
        return "";
    }
	
}

