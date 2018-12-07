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
    	
    	
    	if(firstOperand[2] == 0 || secondOperand[2] == 0 )
    		throw new IllegalArgumentException("E-Error! You can't divide by zero baka ^_^!");
    	
    	int[] firstImproperFrac = convertToImproperFraction(firstOperand);
    	int[] secondImproperFrac = convertToImproperFraction(secondOperand);
    	
    	int[] finalImproper = new int[2];
    	switch(splitBySpace[1]) {
    		case "+":
    			finalImproper = add(firstImproperFrac, secondImproperFrac);
    			return finalImproper[0] + "/" + finalImproper[1];
    		case "-":
    			finalImproper = subtract(firstImproperFrac, secondImproperFrac);
    			return finalImproper[0] + "/" + finalImproper[1];
    		case "*":
    			finalImproper = multiply(firstImproperFrac, secondImproperFrac);
    			return finalImproper[0] + "/" + finalImproper[1];
    		case "/":
    			finalImproper = divide(firstImproperFrac, secondImproperFrac);
    			return finalImproper[0] + "/" + finalImproper[1];
    		default:
    			return "B-Baka! Improper formatting detected. Try again.";
    	}
    	
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
    	improperReturn[0] =  operand[2] * Math.abs(operand[0]) + operand[1];
    	
    	if(operand[0] < 0) 	improperReturn[0] *= -1;
    	return improperReturn;  	
    }
    public static int[] add(int[] oprnd1, int[] oprnd2) {
    	int[] addReturn = new int[2];
    	int gcd = returnGCD(oprnd1[1], oprnd2[1]);
    	oprnd1[0] = oprnd1[0] * (gcd/oprnd1[1]);//calculates new numerator
    	oprnd2[0] = oprnd2[0] * (gcd/oprnd2[1]);
    	addReturn[0] = oprnd1[0] + oprnd2[0];
    	addReturn[1] = gcd;
    	return addReturn;
    }
    public static int[] subtract(int[] oprnd1, int[] oprnd2) {
    	int[] subtractReturn = new int[2];
    	int gcd = returnGCD(oprnd1[1], oprnd2[1]);
    	oprnd1[0] = oprnd1[0] * (gcd/oprnd1[1]);//calculates new numerator
    	oprnd2[0] = oprnd2[0] * (gcd/oprnd2[1]);
    	subtractReturn[0] = oprnd1[0] - oprnd2[0];
    	subtractReturn[1] = gcd;
    	return subtractReturn;
    }
    public static int[] multiply(int[] oprnd1, int[] oprnd2) {
    	int[] productReturn = new int[2];
    	productReturn[0] = oprnd1[0] * oprnd2[0];
    	productReturn[1] = oprnd1[1] * oprnd2[1];
    	return productReturn;			
    }	
    public static int[] divide(int[] oprnd1, int[] oprnd2) {
    	int[] divisionReturn = new int[2];
    	divisionReturn[0] = oprnd1[0] * oprnd2[1];
    	divisionReturn[1] = oprnd1[1] * oprnd2[0];
    	return divisionReturn;	
    }
    public static int returnGCD(int input1, int input2) { //from CalculateLibrary
    	return input1 * input2;
    }
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    
}
