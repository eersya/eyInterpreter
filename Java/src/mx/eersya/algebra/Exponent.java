package mx.eersya.algebra;

/**
 *@author eersya
 */

public class Exponent {
	
    public static final char ONE = '¹';
    public static final char TWO = '²';
    public static final char THREE = '³';
    public static final char FOUR = '⁴';
    public static final char FIVE = '⁵';
    public static final char SIX = '⁶';
    public static final char SEVEN = '⁷';
    public static final char EIGHT = '⁸';
    public static final char NINE = '⁹';
    public static final char ZERO = '⁰';
    public static final char NO_EXPONENT = 'N';
    public static final char NEGATIVE_EXPONENT = '⁻';
	
    public static final int ANY_EXPONENT = 0;
	
    public static int valueOf(char chr) {
	switch(chr) {
	case ONE:
	    return 1;
	case TWO:
	    return 2;
	case THREE:
	    return 3;
	case FOUR:
	    return 4;
	case FIVE:
	    return 5;
	case SIX:
	    return 6;
	case SEVEN:
	    return 7;
	case EIGHT:
	    return 8;
	case NINE:
	    return 9;
	case ZERO:
	    return 0;
	default:
	    return -1;
	}
    }
	
    public static char getExponentChar(char chr) {
	switch(chr) {
	case ONE:
	    return '1';
	case TWO:
	    return '2';
	case THREE:
	    return '3';
	case FOUR:
	    return '4';
	case FIVE:
	    return '5';
	case SIX:
	    return '6';
	case SEVEN:
	    return '7';
	case EIGHT:
	    return '8';
	case NINE:
	    return '9';
	case ZERO:
	    return '0';
	case  NEGATIVE_EXPONENT:
	    return '-';
	default:
	    return ' ';
	}
    }
	
    public static char getCharExponent(char chr) {
	switch(chr) {
	case '1':
	    return ONE;
	case '2':
	    return TWO;
	case '3':
	    return THREE;
	case '4':
	    return FOUR;
	case '5':
	    return FIVE;
	case '6':
	    return SIX;
	case '7':
	    return SEVEN;
	case '8':
	    return EIGHT;
	case '9':
	    return NINE;
	case '0':
	    return ZERO;
	case  '-':
	    return NEGATIVE_EXPONENT;
	default:
	    return NO_EXPONENT;
	}
    }
	
    /**
     * 
     * @param string
     * @return
     */
    public static Integer valueOf(String string) {
	if(string == null)
	    return ANY_EXPONENT;
	StringBuilder str = new StringBuilder();
	for(char c : string.toCharArray()) {
	    str.append(Exponent.getExponentChar(c));
	}
	return Integer.valueOf(str.toString());
    }
	
    /**
     *
     * @param exponent
     * @return
     */
    public static String getExponent(Integer exponent) {
	StringBuilder str = new StringBuilder();
	for(char c : exponent.toString().toCharArray()) {
	    str.append(Exponent.getCharExponent(c));
	}
	return str.toString();
    }
	
}
