Check Armstrong

Write a Program to determine if the given number is Armstrong number or not. Print true if number is armstrong, otherwise print false.
An Armstrong number is a number (with digits n) such that the sum of its digits raised to nth power is equal to the number itself.

For example,
371, as 3^3 + 7^3 + 1^3 = 371
1634, as 1^4 + 6^4 + 3^4 + 4^4 = 1634

Input Format :
Integer n
Output Format :
true or false

Sample Input 1 :
1
Sample Output 1 :
true

Sample Input 2 :
103
Sample Output 2 :
false

Code:

import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		 
    Scanner s = new Scanner(System.in); 
        int number = s.nextInt();
    int  originalNumber, remainder, result = 0, n = 0;

     originalNumber = number;

     for (;originalNumber != 0; originalNumber /= 10, ++n);

     originalNumber = number;

     for (;originalNumber != 0; originalNumber /= 10)
     {
         remainder = originalNumber % 10;
         result += Math.pow(remainder, n);
     }

     if(result == number)
     {
    	 System.out.println("true");
     } else {
    	 System.out.println("false");
     }
	}
}
