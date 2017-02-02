package test;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import calc.CalcEngine;



/**
 * @author Judy OBrien
 * @version 1.0
 * Test for CalcEngine Class
 * Method to set up data for testing.
 */

public class testCalcEngine {

	
	CalcEngine testEngine = new CalcEngine();
	
	String test1 = "8 3 5 . 1 2 + * +";    // testing decimal points and brackets
	String test2 = "11 2 3 * + 4 +";   //testing double digits
	String test3 = "4 2 ^";               // testing power of
	
	
	String test4 = "8+3.5*(1+2)";
	String test5 = "1*2";
	String test6 = "(2*2)+3";            //testing brackets
	String test7 = "1.2*2";               //testing decimal points
	String test8 = "!33*!33";             //testing minus numbers
	


/**
 * @author Judy
 * test method set up to test conversion of string from infix to postfix
 * @param string name
 * @return string in postfix expression
 */
	
	@Test
	public void convertpostfix()
	{ 
		String infix = testEngine.convertPostfix(test4);
		assertEquals("8 3 5 . 1 2 + * + ", infix);
		
		String infix2 = testEngine.convertPostfix(test5);
		assertEquals ("1 2 * ", infix2);
		
		String infix3 = testEngine.convertPostfix(test6);
		assertEquals("2 2 * 3 + ", infix3);
		
		String infix4 = testEngine.convertPostfix(test7);
		assertEquals("1 2 . 2 * ", infix4);
		
		String infix5 = testEngine.convertPostfix(test8);
		assertEquals ("-33 -33 * ", infix5);
		
	}
	
	
	
	/**
	 * @author Judy
	 * test method set up to test evualation of a string in a postfix expression form
	 * @param string name
	 * @return double 
	 */
	
	
	
	@Test
	public void testpostfixEvaluate()
	{ 
		double evaluate = testEngine.postfixEvaluate(test1);
		assertEquals (18.5, evaluate ,0);
		
		double evaluate2 = testEngine.postfixEvaluate(test2);
		assertEquals (21, evaluate2 ,0);
		
		double evaluate3 = testEngine.postfixEvaluate(test3);
		assertEquals (16, evaluate3 ,0);
		
		
		
	}
	
	


	
	/**
	 *13. to shut down all tests
	 * @throws Exception
	 */
	
	@After
	public void tearDown() throws Exception {
	}


	}
