Replace Character Recursively

Given an input string S and two characters c1 and c2, you need to replace every occurrence of character c1 with character c2 in the given string.
Do this recursively.

Input Format :
Line 1 : Input String S
Line 2 : Character c1 and c2 (separated by space)

Output Format :
Updated string

Constraints :
1 <= Length of String S <= 10^6

Sample Input :
abacd
a x
Sample Output :
xbxcd

Code:

package Restart;

import java.util.Scanner;

public class Recursion {

	public static String replaceChar(String str, char c1, char c2 ) {
		
		if( str.length() == 0) {
			return str;
		}
		
		String ans= "";
		if( str.charAt(0)== c1) {
			ans=  ans + c2;
		}else {
			ans= ans + str.charAt(0);
		}
		
		String smallAns= replaceChar(str.substring(1), c1, c2);
		return ans + smallAns;
			
	}
	
	public static void main(String[] args) {

		String str= "abacd";
		char c1= 'a';
		char c2= 'x';
		System.out.println(replaceChar(str, c1, c2));
		
	}

}
