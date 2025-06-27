package com.junit.JUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calc;
	
	@Before
	public void setUp() {
		calc = new Calculator();
	}
	
	@After
	public void tearDown() {
		calc = null;
	}
	
	@Test
    public void testAdd() {
        // Arrange
		int a = 10;
        int b = 20;
        
        // Act
        int result = calc.add(a, b);
        
        //Assert
        assertEquals(30, result); 
    }
	
	@Test
    public void testSubtract() {
        // Arrange
		int a = 15;
        int b = 6;
        
        // Act
        int result = calc.subtract(a, b);
        
        //Assert
        assertEquals(9, result); 
    }
	
	@Test
    public void testMultiply() {
        // Arrange
		int a = 420;
        int b = 69;
        
        // Act
        int result = calc.multiply(a, b);
        
        //Assert
        assertEquals(28980, result); 
    }
	
	@Test
    public void testDivide() {
        // Arrange
		int a = 49;
        int b = 7;
        
        // Act
        int result = calc.divide(a, b);
        
        //Assert
        assertEquals(7, result); 
    }
	
	@Test
    public void testModulo() {
        // Arrange
		int a = 69;
        int b = 5;
        
        // Act
        int result = calc.modulo(a, b);
        
        //Assert
        assertEquals(4, result); 
    }
	
}