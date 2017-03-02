/**
 * ValidatorTest.java
 */
package com.example.email_validator;

/**
 * This class uses junit to test the Validator class.
 */


import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {	
	@Test
	public void testEmptyEmail() {
		assertTrue(Validator.validate("") == 0);
	}
	
	@Test
	public void testEmailWithoutAtOrDot() {
		assertTrue(Validator.validate("ian-dawson") == 0);
	}
	
	@Test
	public void testEmailWithoutDot() {
		assertTrue(Validator.validate("ian-dawson@example") == 1);
	}
	
	@Test
	public void testEmailWithoutAt() {
		assertTrue(Validator.validate("ian-dawsonexample.com") == 1);
	}
	
	@Test
	public void testEmailWithSingleAtAndDot() {
		assertTrue(Validator.validate("ian-dawson@example.com") == 2);
	}
	
	@Test
	public void testEmailWithMultipleAtAndDot() {
		assertTrue(Validator.validate("ian@dawson@example.com") == 1);
	}
	
	@Test
	public void testEmailWithSingleAtAndMultipleDot() {
		assertTrue(Validator.validate("ian-dawson@mail.example.com") == 2);
	}
}
