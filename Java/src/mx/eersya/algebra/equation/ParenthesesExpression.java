package mx.eersya.algebra.equation;

/**
 *@author eersya
 */

public class ParenthesesExpression extends mx.eersya.algebra.equation.Expression {
    
    /**
     * 
     * @param expresion 
     */
    public ParenthesesExpression(String expresion) {
	super(expresion, true);
        readTerms(expresion);
    }
    
    

}
