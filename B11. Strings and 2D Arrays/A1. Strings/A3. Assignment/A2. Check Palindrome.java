Check Palindrome

Given a string, determine if it is a palindrome, considering only alphanumeric characters.

Palindrome
A palindrome is a word, number, phrase, or other sequences of characters which read the same backwards and forwards.

Example:
If the input string happens to be, "malayalam" then as we see that this word can be read the same as forward and backwards, it is said to be a valid palindrome.
The expected output for this example will print, 'true'.
From that being said, you are required to return a boolean value from the function that has been asked to implement.

Input Format:
The first and only line of input contains a string without any leading and trailing spaces. All the characters in the string would be in lower case.

Output Format:
The only line of output prints either 'true' or 'false'.

Note:
You are not required to print anything. It has already been taken care of.

Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1 :
abcdcba
Sample Output 1 :
true 
Sample Input 2:
coding
Sample Output 2:
false

Code:

package Restart;

import java.util.Scanner;

public class Practice {

	public static String input() {
		
		Scanner s= new Scanner(System.in);
		String str= s.nextLine();
		return str;
	}
	
	public static boolean checkPalidrome( String str) {
		// hum loop str.length-1 se start greater than equal to 0 tak coz string ki indexing 0 se length-1 tak hoti hai  aur har character pe jake usko empty string("") mai dalegne then end mai reversed string ko original string ke sath compare karenge.
		
		String rev= "";
		
		for( int i= str.length() -1 ; i>=0 ;i--) {
			rev= rev + str.charAt(i);
		}
		
		if( str.equals(rev)) {
			return true;
		}else {
			return false;
		}
		
	}

	public static void main(String[] args) {

		String str= input();
		boolean result= checkPalidrome(str);
		System.out.println(result);
	}
}
