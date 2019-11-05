package com.jdpatel.stringcalc;

import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class StringCalculatorTest {

    // Step 1 Smple calc
    @Test
    public void returnZeroForEmptyString() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(0, strCalc.add(""));
    }
    
    @Test
    public void returnItseftForSingleNumber() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(3, strCalc.add("3"));
    }
    
    @Test
    public void returnSumForTwoNumbers() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(7, strCalc.add("2,5"));
    }
    
    @Test
    public void returnSumForMultipleNumers() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(45, strCalc.add("1,2,3,4,5,6,7,8,9"));
    }
   
    @Test
    public void supportNewLineAsSeparator() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(6, strCalc.add("1\n2,3"));
    }
    
    @Test
    public void supportForCustomDelimiter() {
        StringCalculator strCalc = new StringCalculator();
        assertEquals(10, strCalc.add(";\n1;2;3;4"));
    }
    
    @Test
    public void negativeNotSupported() {
        StringCalculator strCalc = new StringCalculator();
        try {
            strCalc.add("-1,2");
            fail("exception should have been thrown");
        }
        catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed -1", e.getMessage());
        }
    }
    
    @Test
    public void ignoreNumberMoreThan1000() {
    	StringCalculator strCalc = new StringCalculator();
        assertEquals(5, strCalc.add("1001\n2,3"));
    }
    @Test
    public void supportForCustomDelimiterWithSqure() {
    	StringCalculator strCalc = new StringCalculator();
        assertEquals(6, strCalc.add("[@@@]\n1@@@2@@@3"));
    }
    
}




