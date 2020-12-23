Return Permutations - String

Given a string S, find and return all the possible permutations of the input string.

Note 1 : The order of permutations is not important.
Note 2 : If original string contains duplicate characters, permutations will also be duplicates.

Input Format :
String S
Output Format :
All permutations (in different lines)

Sample Input :
abc
Sample Output :
abc
acb
bac
bca
cab
cba

Code:

public class solution {

	public static void printAllPossibleCodes(String input) {
		// Write your code here
                     printAllPossibleCodes(input, "");

	}
    public static void printAllPossibleCodes(String input, String output) {
		 if(input == null || input.length() <= 0)
 	    {
 	    	System.out.println(output);
 	    	return;
 	    }
		 
		//SmallCalculation
		 
		String ch1 = input.substring(0, 1);
		String restStr = input.substring(1);
		
		if(Integer.parseInt(ch1) > 0) {
			char code = (char) (Integer.parseInt(ch1) + 'a' - 1);
            
			printAllPossibleCodes(restStr, output + code);
		}
		if(input.length() >= 2) {
			String ch2 = input.substring(0,2);
			String restStr2 = input.substring(2);
			
		  if(Integer.parseInt(ch2) >= 10 && Integer.parseInt(ch2) <= 26) {
			char code = (char) (Integer.parseInt(ch2) + 'a' - 1);
			printAllPossibleCodes(restStr2, output + code);
		  }
        }
		
	}
}
