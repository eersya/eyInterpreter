/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.eersya.util;

/**
 *
 * @author eersya
 */
public class EyString {
    
    public static final char LEFT_PARENTHESES = '(';
    public static final char RIGHT_PARENTHESES = ')';
    
    public static int indexOf(String str, char ch, int time) {
        
        if (time >= str.length())
            return -1;
        
        for (int i = time; i < str.length(); i++) {
            if (str.charAt(i) == ch)
                return i;
        }
        
        return -1;
    }
    
}
