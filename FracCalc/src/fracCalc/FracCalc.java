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
        String oprnd1 = splitBySpace[0];
        String operator = splitBySpace[1];
        String oprnd2 = splitBySpace[2];
        
        int[] oprnd2Arr = parseFrac(oprnd2);
        int whole2 = oprnd2Arr[0];
        int numer2 = oprnd2Arr[1];
        int denom2 = oprnd2Arr[2]; 
        
      
        String returnString = "whole:" + whole2 + " numerator:" + numer2 + " denominator:" + denom2;
        return returnString;
    }



    public static int[] parseFrac(String oprnd) {
		int whole = 0;
		int numer = 0;
		int denom = 1;
		String[] firstSplit = oprnd.split("_"); 
		if (oprnd.indexOf("/") != -1) //if there is a fraction
		{ 
			String fraction = firstSplit[firstSplit.length - 1]; 
			String[] secondSplit = fraction.split("/"); 
			numer = Integer.parseInt(secondSplit[0]);
			denom = Integer.parseInt(secondSplit[1]);	
			if (oprnd.indexOf("_") != -1)
			{ //if there also is a whole
				whole = Integer.parseInt(firstSplit[0]); 
			}
		} else 
		{ 
			whole = Integer.parseInt(firstSplit[0]); 
		}

		int[] returnArray = {whole, numer, denom};
		return returnArray;
       
    
    
    
   

  
    } 
}
