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
   
}




