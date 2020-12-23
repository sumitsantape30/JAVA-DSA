Return all codes - String

Assume that the value of a = 1, b = 2, c = 3, ... , z = 26. You are given a numeric string S. Write a program to return the list of all possible codes that can be generated from the given string.
Note : The order of codes are not important. And input string does not contain 0s.

Input format :
A numeric string

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

	// Return a string array that contains all possible codes
	public static  String[] getCode(String input){
		// Write your code here
		if(input.length() == 0) {
			String[]s = new String[1];
			s[0] = " ";
			return s;
		}
		//char ch1 = input.charAt(0);
		//int index1 = ch1 - '0';
		//System.out.println(index);
		//char word = (char) ('a' + index1 - 1);
		//System.out.println(word);
		
		String smallresult [] = getCode(input.substring(1));
		
		char c1 = (char) (input.charAt(0) - '0'); // Convert '1' --->(char) 1 ----> '1' 
		
		String s = String.valueOf((char)('a' + c1 - 1)); // Get the ascii value of char and get the char corresponding that ascii value
		
		String result1[] = new String[smallresult.length];
		
		for(int i = 0; i < smallresult.length; i++) {
		
			result1[i] = s + smallresult[i];
		}
		
		if(input.length() >= 2) {
			String  nextSmall[] = getCode(input.substring(2));
			
			int c2 = 96 + (Integer.parseInt(input.substring(0,2)));
			
			if(c2 >= 97 && c2 <= 122) {
				char cc = (char)(c2);
				
				String ss = String.valueOf(cc);
				
				String[] result2 = new String[smallresult.length + nextSmall.length];
				
				int i, k = 0;
				
				for( i = 0; i < smallresult.length; i++ ) {
					
					result2[i] = s + smallresult[i];
					k++;
				}
				
				for( i = 0 ; i < nextSmall.length; i++) {
					
					result2[k] = ss + nextSmall[i];
					k++;
				}
				
				return result2;
			}
			
		}
		
		return result1;
	}

}
