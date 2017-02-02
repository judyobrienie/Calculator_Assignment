package calc;

import java.util.Scanner;
import java.util.Stack;

/**
 * The main part of the calculator doing the calculations.
 * 
 * @author  Judy O'Brien
 * @version 1.
 * @param string a string of in infix notation
 * @return a calculated answer
 */
public class CalcEngine
{
   
	String displayUserInput = " ";
  

    /**
     * The 'C' (clear) button was pressed.
     */
    public void clear()
    {
    	displayUserInput = " ";
    	
    }

    
    
  /**  
   * Algorithm convertToPostfix (infix)
   * Converts an infix expression to an equivalent postfix expression.
   * @param take in string of infix and converts to a string of postfix
   * @return a string in postfix notation
   */
    public String convertPostfix(String string){

  		Stack<Character> operatorStack = new Stack<Character>();

  		StringBuffer postfix = new StringBuffer();

  		Character topOperator;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);

			if (Character.isDigit(c)) {
				postfix.append(c);



				// fixing bug to test next character before adding a space
				// if next character is not a digit add a space
				if (i + 1 >= string.length() || !Character.isDigit(string.charAt(i + 1)))
					postfix.append(" ");

  			}
  			else
  			{
  				
  				switch(c){
  				   /////// add a minus to stack without a space
  					case'!':
  				    boolean Debug = true;

					if (Debug)
						System.out.println("Bugs");

					postfix.append('-');
					
					
  					break;
 
  					
  				case '^':
  					operatorStack.push (c);
  					break;
  				case '.':
  					operatorStack.push (c);
  					break;
  				case '+':
  				case '-':
  				case '*':
  				case '/':
  					while (!operatorStack.isEmpty () &&
  							getPrecedence(c) <= getPrecedence(operatorStack.peek()))
  					{
  						postfix.append(operatorStack.peek() + " ");
  						operatorStack.pop();
  						
  					}
  					operatorStack.push (c);
  					break;

  				case '(':
  					operatorStack.push (c);
  					break;

  				case ')':  
					topOperator = operatorStack.pop();
					while ((topOperator != '(') &&  !operatorStack.isEmpty())
					{
						postfix.append(topOperator);
						postfix.append(" ");
						topOperator = operatorStack.pop();
					}// end while

					/* if(!operatorStack.isEmpty() && operatorStack.peek().equals('(')){
		                 operatorStack.pop(); // pop/remove left parenthesis 
		             }*/
					break;
  				default:
  					break;
  				}
  			}
  		}  
		/*
		 *  popping off any final operators
		 */
  			while (!operatorStack.isEmpty())
  			{
  				topOperator = operatorStack.pop();
  				postfix.append(topOperator + " ");
  				
  			}
  			return postfix.toString();

  		}

  	
    /**  
     * Algorithm  postfixEvaluate(String postfix) 
     * calculates a postfix expression 
     * @param take in string of postfix and 
     * @return a double calculated answer 
     */
    
    
    public  Double postfixEvaluate(String postfix) {
	 	Stack<Double> valueStack = new Stack<Double> ();
		
		@SuppressWarnings("resource")
		Scanner tokens = new Scanner(postfix);
		
		while (tokens.hasNext()) {
			if (tokens.hasNextInt()) {
				valueStack.push(tokens.nextDouble());
			} else {
				double operandTwo = valueStack.pop();
				double operandOne = valueStack.pop();
				String function = tokens.next();
				
				 switch (function)
				    {
				        
				          
				                case "+":
				                	valueStack.push(operandOne + operandTwo);
				                	break;
				                case "-":
				                	valueStack.push(operandOne - operandTwo);
				                	break;
				                case "*":
				                	valueStack.push(operandOne * operandTwo);
				                	break;
				                case "/":
				                	valueStack.push(operandOne / operandTwo);
				                	break;
				                case "^":
				                	valueStack.push( (double) Math.pow(operandOne, operandTwo));
				                	break;
				                	//working on decimal point calculations. also give it a precedence of 4
				                case ".":
				                	double temp = operandTwo/10;
				                	valueStack.push(operandOne = (temp + operandOne));
				                	break;
				                   
				                default:
				                    break;
				    }// end of switch
				
				
			
			}// end of else
		}// end of while
		return valueStack.peek();
    }
    
    
  	
  	/**
  	 * takes in an operator and order its precedence
  	 * @param operator 
  	 * @return the precedence of a certain operator
  	 */
  	
  	
  	private static int getPrecedence(char operator)
	{
		switch (operator)
		{
		case '(': case ')': return 0;
		case '+': case '-': return 1;
		case '*': case '/': return 2;
		case '^':			return 3;
		case '.':           return 4;
		} // end switch

		return -1;
		
	}// end getprecedence
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /**
     * Return the title of this calculation engine.
     */
    public String getTitle()
    {
        return("Judys' Calculator");
    }

    /**
     * Return the author of this engine. This string is displayed as it is,
     * so it should say something like "Written by H. Simpson".
     */
    public String getAuthor()
    {
        return("Judy O'Brien");
    }

    /**
     * Return the version number of this engine. This string is displayed as 
     * it is, so it should say something like "Version 1.1".
     */
    public String getVersion()
    {
        return("Ver. 1.0");
    }

}