package com.jdpatel.stringcalc;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class StringCalculator 
{   

    public int add(String text) {
    	if (text == null || text.isEmpty()) {
            return 0;
        }
    	
    	String customDelimiter = getCustomDelimiter(text.split("\n")[0]);
    	List<String> negetiveNumbers = new ArrayList<String>();
    	
    	
    	int skipFirstLines =  calculateSkipLines(customDelimiter);
    	String[] numbers =  (customDelimiter == ",") ? text.split(",|\n") : text.split("\n|" + customDelimiter);   
    	int total = addNumbers(negetiveNumbers,  skipFirstLines, numbers);
    	validateNegetiveNumbers(negetiveNumbers);
    	
        return total;
         
    }

	private void validateNegetiveNumbers(List<String> negetiveNumbers) {
		if (!negetiveNumbers.isEmpty()) {
            throw new IllegalArgumentException(
                "negatives not allowed " + String.join(",", negetiveNumbers));
        }
	}

	private int addNumbers(List<String> negetiveNumbers,  int skipFirstLines, String[] numbers) {
		int total =0 ;
		for (String item : numbers) {
    		 if (skipFirstLines > 0) {
                 --skipFirstLines;
             } else {
            	 int num = Integer.parseInt(item);
            	 if (num < 0) {
                     negetiveNumbers.add(item);
                 }
                 else if(num <= 1000) {
                total += num;
                 }
             }
        }
		return total;
	}

	private int calculateSkipLines(String customDelimiter) {
		return (customDelimiter == ",") ? 0 : customDelimiter.contains("|") ? 
        		( 2 + (int) customDelimiter.chars().filter(ch -> ch == '|').count() ) 
        		: 2;
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
        if(line.startsWith("[") && line.endsWith("]") )
        {
        	line =  line.substring(1,line.length()-1);
        	return line.replace("][" , "|");
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
