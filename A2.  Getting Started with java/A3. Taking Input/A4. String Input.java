package Restart;

import java.util.Scanner;

public class Practice{
	
	public static void main(String [] args) {
		
		Scanner s= new Scanner(System.in);
		
		String str= s.nextLine();
		System.out.println(str);
		
		
		String a= s.next(); // next breaks the string around the spaces
		System.out.println(a);
		
		//To print the single character
		String text= s.next();
		char c= a.charAt(0);
		System.out.println(c);
	}
}

Input and Output:
abc def // Input
abc def //Output
abc def //Input
abc     // Output
abc def //Input
a       // Output
