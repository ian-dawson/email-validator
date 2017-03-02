/**
 * Validator.java
 */
package com.example.email_validator;

/**
 * This class is for validating email addresses.
 * 
 * @author ian-dawson
 */

import java.util.regex.*;


public class Validator {
	
	/**
	 * Validates email according to a set of rules. 
	 * 
	 * @param email Email address to be validated.
	 * 
	 * @return the number of checks that passed.
	 */
    public static Integer validate(String email) {
    	Integer checksPassed = 0;
    	String[] rules = {"[^@]*@[^@]*", ".*\\.+.*"};
    	for (Integer i = 0; i < rules.length; i++) {
    		System.out.println("Checking " + rules[i]);
    		if (Pattern.matches(rules[i], email)) {
    			checksPassed++;
    		}
    	}
    	return checksPassed;
    }
    
    public static void main(String[] args) {
    	System.out.println(validate("ian.dawsondal.ca"));
    }
}
