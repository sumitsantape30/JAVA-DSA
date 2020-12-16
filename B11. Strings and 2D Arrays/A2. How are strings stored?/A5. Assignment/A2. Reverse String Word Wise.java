Reverse String Word Wise

Reverse the given string word wise. That is, the last word in given string should come 
at 1st place, last second word at 2nd place and so on. Individual words should remain as it is.

Input format :
String in a single line

Output format :
Word wise reversed string in a single line

Constraints :
0 <= |S| <= 10^7
where |S| represents the length of string, S.

Sample Input 1:
Welcome to Coding Ninjas
Sample Output 1:
Ninjas Coding to Welcome

Sample Input 2:
Always indent your code
Sample Output 2:
code your indent Always

Code:

import java.util.Scanner;

public class ReverseStringWordWise {

	public static String input() {
		
		Scanner s= new Scanner(System.in);
		String str= s.nextLine();
		return str;
	}
	
	public static void reverse( String str) {

	       String s[] = str.split(" ");
		   String ans = "";
		   for( int i = s.length - 1; i >= 0; i--)
		   {
		       ans += s[i] + " "; 
		       
		   } 
		   System.out.println(ans);
		  // ans = ans.substring(0, ans.length() - 1);
		 //  return ans;
	}
	
	public static void main(String[] args) {

		String str= input();
		 reverse(str);
		//System.out.println(result);
	}

}
