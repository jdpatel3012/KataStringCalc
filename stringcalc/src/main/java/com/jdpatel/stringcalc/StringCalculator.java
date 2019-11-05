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
    	
    	String customDelimiter = getCustomDelimiter(text.split("\n")[0]);
    	
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
    
    private String getCustomDelimiter(String line) {
        if (line == null || line.isEmpty()) {
            return ",";
        }
        if (isNumeric(line)) {
            return ",";
        }
        if (line.length() == 1) {
            return line.substring(0, 1);
        }       
        return ",";
    }
    
    private boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
