package com.jdpatel.stringcalc;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int add(String text) {
    	if (text == null || text.isEmpty()) {
            return 0;
        }  
         return (int) Double.parseDouble(text);
         
    }
}
