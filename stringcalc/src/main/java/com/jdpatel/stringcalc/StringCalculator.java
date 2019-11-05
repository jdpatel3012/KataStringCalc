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
    	
    	String customDelimiter = text.split("\n")[0];
    	
    	 if (customDelimiter == null || customDelimiter.isEmpty()) {
    		 customDelimiter =  ",";
         }
    	 else {
    		 boolean isNumeric = true ;
    		 try {
    	            Double.parseDouble(customDelimiter);
    	        } catch (NumberFormatException nfe) {
    	        	isNumeric = false;
    	        }
    		 
    		 if (isNumeric) {
    			 customDelimiter =  ",";	 
    		 	}
        	 
         
    	 else if (customDelimiter.length() == 1) {
    		 
        	 customDelimiter =  customDelimiter.substring(0, 1);;
         }
    	 else 
    	 {
    		 customDelimiter =  ",";	 
    	 }
    		 
    }
    	
    	
    	int total = 0;
    	int skipFirstLines =  (customDelimiter == ",") ? 0 : 2 ;
    	String[] numbers =  (customDelimiter == ",") ? text.split(",|\n") : text.split("\n|" + customDelimiter);   
    	for (String item : numbers) {
    		 if (skipFirstLines > 0) {
                 --skipFirstLines;
             } else {
                total += Integer.parseInt(item);
             }
        }
    	
    	
    	
        return total;
         
    }
}
