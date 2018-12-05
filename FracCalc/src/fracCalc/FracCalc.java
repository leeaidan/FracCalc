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
    	}
    
    	int[] firstImproperFrac = convertToImproperFraction(firstOperand);
    	int[] secondImproperFrac = convertToImproperFraction(secondOperand);
    	
    	
    
    	
   
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
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
