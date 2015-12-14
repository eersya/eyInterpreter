package mx.eersya.algebra.equation;

import java.util.ArrayList;

import mx.eersya.algebra.Algebra;

/**
 *@author eersya
 */

public final class Expression extends Object{
    
    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';
	
    protected ArrayList<Term> terms;
    private ArrayList<ParenthesesExpression> parenthesesExpressions;
    
    public Expression(String expression, boolean son) {
        if (son) {
           terms = new ArrayList<>();
            readTerms(expression);
        } else {
            terms = new ArrayList<>();
        
            if (expression.contains(String.valueOf(LEFT_PARENTHESES))) {
                parenthesesExpressions = new ArrayList<>();
                readParethesesExpressions(expression);
            }

            readTerms(expression);
        }
    }
    
    public Expression(String expression) {
        terms = new ArrayList<>();
        
        if (expression.contains(String.valueOf(LEFT_PARENTHESES))) {
            parenthesesExpressions = new ArrayList<>();
            readParethesesExpressions(expression);
        }
       
        readTerms(expression);
    }
	
    /**
     * @return the terms of the expression
     */
    public ArrayList<Term> getTerms() {
        return terms;
    }
   
    /**
     * @return the parenthesisExpressions of the expression
     */
    public ArrayList<ParenthesesExpression> getParenthesisExpressions() {
        return parenthesesExpressions;
    }
    
    private void readParethesesExpressions(String expression) {
        
        ArrayList<Integer> leftPositions = new ArrayList<>();
        int parenthesisCounter = 0;
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case LEFT_PARENTHESES:
                    leftPositions.add(i);
                    parenthesisCounter++;
                    break;
                case RIGHT_PARENTHESES:
                    parenthesesExpressions.add(new ParenthesesExpression(expression.substring(leftPositions.get(leftPositions.size()), i)));
                    leftPositions.remove(leftPositions.size());
                    break;
            }
        }
        
    }
    
    /**
     * Reads the string and search terms.
     * @param expression 
     */
    protected void readTerms(String expression) {
		
        boolean withinParentheses = false;
        int beginIndex = 0, endIndex = 0;
        for (int cur = 0; cur < expression.length(); cur++) {
            
            if (withinParentheses)
                continue;
            if (expression.charAt(cur) == RIGHT_PARENTHESES)
                withinParentheses = false;
            if (expression.charAt(cur) == LEFT_PARENTHESES)
                withinParentheses = true;
            
            if (Algebra.isOperator(expression.charAt(cur))) {
                
                if (Algebra.isOperator(expression.charAt(cur)) && cur == 0) {
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

    /**
     * Makes the multiplication between terms.
     */
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
	
    /**
     * Puts together terms with the same variable.
     */
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
     * Returns true if there is any concurrence in variables.
     * @param expression
     * @return 
     */
    public static boolean isThereConcurrenceInVars(Expression expression) {
        for (Term term : expression.getTerms()) {
            for (Term curTerm : expression.getTerms()) {
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

