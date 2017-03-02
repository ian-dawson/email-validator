/**
 * ValidatorTest.java
 */
package com.example.email_validator;

/**
 * This class uses junit to test the Validator class.
 * 
 * @author ian-dawson
 */


import static org.junit.Assert.*;

import org.junit.Test;

public class ValidatorTest {
	private String[] ruleList = {
						"[^@]*@[^@]*",	//Exactly 1 "@"
						".*\\.+.*",		//At least one "."
						".+@.*",		//Local-part is present
						".*@.+\\..+"	//Domain is present
					};
	
	@Test
	public void testEmptyEmail() {
		String[] rules = {ruleList[0], ruleList[1]};
		assertTrue(Validator.validate("", rules) == 0);
	}
	
	@Test
	public void testEmailWithoutDot() {
		String[] rules = {ruleList[1]};
		assertTrue(Validator.validate("ian-dawson@example", rules) == 0);
	}
	
	@Test
	public void testEmailWithDot() {
		String[] rules = {ruleList[1]};
		assertTrue(Validator.validate("example.com", rules) == 1);
	}
	
	@Test
	public void testEmailWithMultipleDot() {
		String[] rules = {ruleList[1]};
		assertTrue(Validator.validate("mail.example.com", rules) == 1);
	}
	
	@Test
	public void testEmailWithoutAt() {
		String[] rules = {ruleList[0]};
		assertTrue(Validator.validate("mail.example.com", rules) == 0);
	}
	
	@Test
	public void testEmailWithSingleAt() {
		String[] rules = {ruleList[0]};
		assertTrue(Validator.validate("ian-dawson@example", rules) == 1);
	}
	
	@Test
	public void testEmailWithMultipleAt() {
		String[] rules = {ruleList[0]};
		assertTrue(Validator.validate("ian@dawson@example", rules) == 0);
	}
	
	@Test
	public void testEmailHasNoUser() {
		String[] rules = {ruleList[2]};
		assertTrue(Validator.validate("@example.com", rules) == 0);
	}
	
	@Test
	public void testEmailHasUser() {
		String[] rules = {ruleList[2]};
		assertTrue(Validator.validate("ian-dawson@", rules) == 1);
	}
	
	@Test
	public void testEmailHasNoDomain() {
		String[] rules = {ruleList[3]};
		assertTrue(Validator.validate("ian-dawson@example", rules) == 0);
	}
	
	@Test
	public void testEmailHasDomain() {
		String[] rules = {ruleList[3]};
		assertTrue(Validator.validate("@example.com", rules) == 1);
	}
	
	@Test
	public void testAllRules() {
		assertTrue(Validator.validate("ian-dawson@example.com", ruleList) == ruleList.length);
	}
}
