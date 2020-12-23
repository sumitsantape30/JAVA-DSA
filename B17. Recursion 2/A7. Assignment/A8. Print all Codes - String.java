Print all Codes - String
Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to print the list of all possible codes that can be generated from the given string.
Note : The order of codes are not important. Just print them in different lines.

Input format :
A numeric string S
Output Format :
All possible codes in different lines

Constraints :
1 <= Length of String S <= 10

Sample Input:
1123
Sample Output:
aabc
kbc
alc
aaw
kw

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
