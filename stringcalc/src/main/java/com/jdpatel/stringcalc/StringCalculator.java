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
    	int total = 0;
    	String[] numbers = text.split(",|\\n");  
    	for (String item : numbers) {
                total += Integer.parseInt(item);
        }
    	
        return total;
         
    }
}
