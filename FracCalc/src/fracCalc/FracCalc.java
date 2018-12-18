package fracCalc;
import java.util.*;
/*
 * @author Aidan Lee
 * @version 11/18/2018
 * This class calculates the addition, subtraction, multiplication, and division of two operands between an operator
 */
public class FracCalc {
	//The Main method takes in input from a Scanner, and runs it through produce answer, and printing the final result to the console
    public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); //New Scanner declared
		String input = userInput.nextLine(); //Get input
		
		while(!input.toLowerCase().equals("quit")) { //while quit is not typed, loop gives input to produce Answer
			System.out.println(produceAnswer(input)); //produce Answer + prints out result 
			input = userInput.nextLine();
    	}
    	userInput.close(); //closes Scanner to conserve memory when user is finished
    }
    //Produce answer calculates the needed answer by calling the needed methods, and returns the value
    public static String produceAnswer(String input) 
    { 
    	String[] splitBySpace = input.split(" "); //Splits the input by spaces, then stores it in an array named splitBySpace
    	
    	//Converts String inputs into an Mixed-Num integer array, stores by respective operand
    	int[] firstOperand = convertToRealFraction(splitBySpace[0]);
    	int[] secondOperand = convertToRealFraction(splitBySpace[2]);
    	String operator = splitBySpace[1]; //Stores operator between operands for convenience 
    	
    	if(firstOperand[2] == 0 || secondOperand[2] == 0 )//ERROR Checking: Dividing by Zero!
    		return ("E-Error! You can't divide by zero baka ^_^!");
    	
    	//Converts Mixed-Num Array to integer improper fractions and stores in respective arrays
    	int[] firstImproperFrac = convertToImproperFraction(firstOperand);
    	int[] secondImproperFrac = convertToImproperFraction(secondOperand);
    	
    	int[] finalImproper = new int[2]; //declared integer array to store calculated Improper array for reduction
    	switch(operator) {//Switch Case statement to determine which operation to use
    		case "+":
    			finalImproper = addAndSubtract(firstImproperFrac, secondImproperFrac, operator); //Addition: Calls addAndSubtract method w/parameters of both improper frac arrays and operator
    			break;
    		case "-":
    			finalImproper = addAndSubtract(firstImproperFrac, secondImproperFrac, operator);//Subtraction: Calls addAndSubtract method w/parameters of both improper frac arrays and operator
    			break;
    		case "*":
    			finalImproper = multiplyAndDivide(firstImproperFrac, secondImproperFrac, operator);//Multiplication: Calls multiplyAndDivide method w/parameters of both improper frac arrays and operator
    			break;
    		case "/":
    			finalImproper = multiplyAndDivide(firstImproperFrac, secondImproperFrac, operator);//Division: Calls multiplyAndDivide method w/parameters of both improper frac arrays and operator
    			break;
    		default:
    			return "B-Baka! Improper operator detected. Try again."; //ERROR Checking: If operator is not of the four, print an Error!
    	}
    	String finalAnswer = reduceAndConvertToMixed(finalImproper); //Call method to reduce and convert to mixed number with the final improper array as parameters, store as String
    	return finalAnswer;//return the final answer
    }
    //Converts String mixed num array to operand integer arrays
    public static int[] convertToRealFraction(String operand){
    	int[] returnIntFrac = {0,0,1};//Set base values
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
    public static int[] convertToImproperFraction(int[] operand){//Converts mixed number array to improper fraction
    	int[] improperReturn = new int[2];
    	improperReturn[0] =  operand[2] * absoluteValue(operand[0]) + operand[1];//uses Absolute value to avoid errors with negatives
    	improperReturn[1] = operand[2];
    	
    	if(operand[0] < 0) 	improperReturn[0] *= -1; //Multiples improper numerator to apply negative values that were removed earlier
    	return improperReturn;  	
    }
    public static int[] addAndSubtract(int[] oprnd1, int[] oprnd2, String operator) {//This method calculates operators for addition and subtraction
    	int[] addSubtractReturn = new int[2];
    	int denomFactor = factorOfFraction(oprnd1[1], oprnd2[1]);//multiples denominator together to find factors
    	oprnd1[0] = oprnd1[0] * (denomFactor/oprnd1[1]);//calculates new numerator
    	oprnd2[0] = oprnd2[0] * (denomFactor/oprnd2[1]);
    	if(operator.equals("+")) addSubtractReturn[0] = oprnd1[0] + oprnd2[0];//Adds fractions for "+"
    	if(operator.equals("-")) addSubtractReturn[0] = oprnd1[0] - oprnd2[0];//Subtracts fractions for "-"
    	addSubtractReturn[1] = denomFactor;//final denominator is the two denominators multiplied together
    	return addSubtractReturn;
    }
    
    public static int[] multiplyAndDivide(int[] oprnd1, int[] oprnd2, String operator) {//This method calculates operators for multiplication and division
    	int[] productQuotientReturn = new int[2];
    	if(operator.equals("*")) {
    		productQuotientReturn[0] = oprnd1[0] * oprnd2[0];//Multiples numerator1 by numerator2
    		productQuotientReturn[1] = oprnd1[1] * oprnd2[1];//Multiples denom1 by denom2
    		}
    	if(operator.equals("/")) {
    		productQuotientReturn[0] = oprnd1[0] * oprnd2[1];
    		productQuotientReturn[1] = oprnd1[1] * oprnd2[0];//Reciprocal for dividing fractions
    	}
    	return productQuotientReturn;			
    }	  
    public static int factorOfFraction(int input1, int input2) { //Multiplies denominators together
    	return input1 * input2;
    }
    public static String reduceAndConvertToMixed(int[] finalImproper) {//This method reduces the improper fraction and converts it to a mixed number
    	if(finalImproper[0] == 0) { //returns 0 if the numerator is zero
    		return "" + 0;
    	}
    	
    	int gcf = findGCF(finalImproper[0], finalImproper[1]);//calculates the gcf between the numerator and denominator
    	finalImproper[0] /= gcf; //divides by gcf
    	finalImproper[1] /= gcf;
    	if ( finalImproper[1] < 0) {//Reassigns negative sign to the numerator if they are in the denominator
    		finalImproper[1] *= -1;
    		finalImproper[0] *=-1;
    	}
    	if(absoluteValue(finalImproper[0]) > finalImproper[1] && finalImproper[1] != 1) {//returns String in the form of whole_num/denom if numerator is greater than denominator and the denominator is not 1
    		int whole = finalImproper[0] / finalImproper[1];//calculates whole number
    		int num = absoluteValue(finalImproper[0] % finalImproper[1]); //calculates the numerator of the mixed number
    		return whole + "_" + num + "/" + finalImproper[1];	//returns in the form of whole_num/denom
    	} else if(finalImproper[1] == 1) { //if it divides by one, just return the numerator
    		return "" + finalImproper[0];
    	} else {
    		return finalImproper[0] +  "/" + finalImproper[1]; //If its not an improper fraction, just return the normal fraction
    	}
    }
    public static int absoluteValue(int input) {//Calculate absolute value
    	if(input < 0) {
    		return input * -1;
    	} else {
    		return input;
    	}
    }
    public static int findGCF(int input1, int input2) {//Calculates GCF for inputted values - from calculate library
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
    public static boolean isDivisibleBy(int dividend, int divisor) {//checks if two values are divisible, required by method findGCF
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
