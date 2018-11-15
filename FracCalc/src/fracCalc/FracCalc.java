package fracCalc;
import java.util.*;
public class FracCalc {

    public static void main(String[] args) {
    	Scanner userInput = new Scanner(System.in);
    	boolean forLoopTracker = false;
    	
    	do {
    		System.out.println("Enter a expression to be caclculated below.");
    		String expressionInput = userInput.nextLine();
    		
    		System.out.println(expressionInput);
    		
    		System.out.println("Enter \"quit\" if you want to end the calculation loop.\n Enter \"continue\" to enter another value");
    		String next = userInput.next();
    		
    		if(next.toLowerCase().equals(next)) forLoopTracker = false;
    	}while(forLoopTracker);
    	
    	userInput.close();
    }
    public static String produceAnswer(String input)
    { 
        String[] inputTerms = input.split(" ");
        
        String firstOperand = inputTerms[0];
        String operator = inputTerms[1];
        String secondOperand = inputTerms[2];
        
        return secondOperand;
        
        
        
        
        
        
        
        
        
        
        
        
  
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
