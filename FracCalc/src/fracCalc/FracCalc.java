package fracCalc;
import java.util.*;
/*
 * @author Aidan Lee
 * @version 11/18/2018
 * This class calculates the addition, subtraction, multiplcation, and division of two operands between an operator
 */
public class FracCalc {
    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in); //Scanner
    	boolean forLoopTracker = false; //tracks the current state of the loop
    	System.out.println("Enter a expression to be caclculated below.");
		String expressionInput = userInput.nextLine(); //gets input from console
		
		//for loop that keeps on calling produce answer until the person types quit
    	do {
    		System.out.println(produceAnswer(expressionInput));
    		
    		System.out.println("Enter \"quit\" if you want to end the calculation loop.\n Enter \"continue\" to enter another value");
    		String next = userInput.next();
    		
    		if(next.toLowerCase().equals("quit")) forLoopTracker = false;
    	}while(forLoopTracker);
    	
    	//closes scanner
    	userInput.close();
    }
    public static String produceAnswer(String input)
    { 
    	String[] splitBySpace = input.split(" ");
    	
    	int[] firstOperand = convertToRealFraction(splitBySpace[0]);
    	int[] secondOperand = convertToRealFraction(splitBySpace[2]);
    	String operator = splitBySpace[1];
    	
    	if(firstOperand[2] == 0 || secondOperand[2] == 0 )
    		throw new IllegalArgumentException("E-Error! You can't divide by zero baka ^_^!");
    	
    	int[] firstImproperFrac = convertToImproperFraction(firstOperand);
    	int[] secondImproperFrac = convertToImproperFraction(secondOperand);
    	
    	int[] finalImproper = new int[2];
    	switch(operator) {
    		case "+":
    			finalImproper = addAndSubtract(firstImproperFrac, secondImproperFrac, operator);
    			break;
    		case "-":
    			finalImproper = addAndSubtract(firstImproperFrac, secondImproperFrac, operator);
    			break;
    		case "*":
    			finalImproper = multiplyAndDivide(firstImproperFrac, secondImproperFrac, operator);
    			break;
    		case "/":
    			finalImproper = multiplyAndDivide(firstImproperFrac, secondImproperFrac, operator);
    			break;
    		default:
    			return "B-Baka! Improper formatting detected. Try again.";
    	}
    	String finalAnswer = reduceAndConvertToMixed(finalImproper);
    	return finalAnswer;
    	
    	
    }
    public static int[] convertToRealFraction(String operand){
    	int[] returnIntFrac = {0,0,1};
    	if(operand.indexOf("_") != -1){
    		String[] splitByUnderscore = operand.split("_");
    		returnIntFrac[0] = Integer.parseInt(splitByUnderscore[0]);
    		operand = splitByUnderscore[1];
    	}
    	if(operand.indexOf("/") != -1){
    		String[] splitBySlash = operand.split("/");
    		returnIntFrac[1] = Integer.parseInt(splitBySlash[0]);
    		returnIntFrac[2] = Integer.parseInt(splitBySlash[1]);
    		
    	} else {
    		returnIntFrac[0] = Integer.parseInt(operand);		
    	}
    	return returnIntFrac;
    } 
    public static int[] convertToImproperFraction(int[] operand){
    	int[] improperReturn = new int[2];
    	improperReturn[0] =  operand[2] * absoluteValue(operand[0]) + operand[1];
    	improperReturn[1] = operand[2];
    	
    	if(operand[0] < 0) 	improperReturn[0] *= -1;
    	return improperReturn;  	
    }
    public static int[] addAndSubtract(int[] oprnd1, int[] oprnd2, String operator) {
    	int[] addSubtractReturn = new int[2];
    	int denomFactor = factorOfFraction(oprnd1[1], oprnd2[1]);
    	oprnd1[0] = oprnd1[0] * (denomFactor/oprnd1[1]);//calculates new numerator
    	oprnd2[0] = oprnd2[0] * (denomFactor/oprnd2[1]);
    	if(operator.equals("+")) addSubtractReturn[0] = oprnd1[0] + oprnd2[0];
    	if(operator.equals("-")) addSubtractReturn[0] = oprnd1[0] - oprnd2[0];
    	addSubtractReturn[1] = denomFactor;
    	return addSubtractReturn;
    }
    
    public static int[] multiplyAndDivide(int[] oprnd1, int[] oprnd2, String operator) {
    	int[] productQuotientReturn = new int[2];
    	if(operator.equals("*")) {
    		productQuotientReturn[0] = oprnd1[0] * oprnd2[0];
    		productQuotientReturn[1] = oprnd1[1] * oprnd2[1];
    		}
    	if(operator.equals("/")) {
    		productQuotientReturn[0] = oprnd1[0] * oprnd2[1];
    		productQuotientReturn[1] = oprnd1[1] * oprnd2[0];
    	}
    	return productQuotientReturn;			
    }	  
    public static int factorOfFraction(int input1, int input2) { //from CalculateLibrary
    	return input1 * input2;
    }
    public static String reduceAndConvertToMixed(int[] finalImproper) {
    	if(finalImproper[0] == 0) {
    		return "" + 0;
    	}
    	
    	int gcf = findGCF(finalImproper[0], finalImproper[1]);
    	finalImproper[0] /= gcf;
    	finalImproper[1] /= gcf;
    	if ( finalImproper[1] < 0) {
    		finalImproper[1] *= -1;
    		finalImproper[0] *=-1;
    	}
    	System.out.println(finalImproper[1]);
    	
    	if(absoluteValue(finalImproper[0]) > finalImproper[1] && finalImproper[1] != 1) {
    		int whole = finalImproper[0] / finalImproper[1];
    		int num = absoluteValue(finalImproper[0] % finalImproper[1]);  
    		return whole + "_" + num + "/" + finalImproper[1];	
    	} else if(finalImproper[1] == 1) {
    		return "" + finalImproper[0];
    	} else {
    		return finalImproper[0] +  "/" + finalImproper[1];
    	}
    }
    public static int absoluteValue(int input) {
    	if(input < 0) {
    		return input * -1;
    	} else {
    		return input;
    	}
    }
    public static int findGCF(int input1, int input2) {
    		input1 = absoluteValue(input1);
    		input2 = absoluteValue(input2);
    		int answer = 1;	//declares inital value for  as 1 b/c 1 is always a gcf
    		for(int i =1; i<=input1; i++) {//test for gcf for integers up to value of input1
    			if(isDivisibleBy(input2, i) && isDivisibleBy(input1, i)) {//returns i into answer the highest value both inputs are divisible by
    					answer = i;
    			}
    		}
    		return answer;
    	}
    public static boolean isDivisibleBy(int dividend, int divisor) {
		if(divisor == 0) {
			throw new IllegalArgumentException("Cannot divide by zero!");
		}
		if(dividend % divisor == 0) { //is Divisible
			return true;
		} else {
			return false; //is not Divisible
		}
	}
  
    
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
}
