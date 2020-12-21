Sum of digits (recursive)

Write a recursive function that returns the sum of the digits of a given integer.

Input format :
Integer N
Output format :
Sum of digits of N

Constraints :
0 <= N <= 10^9

Sample Input 1 :
12345
Sample Output 1 :
15

Sample Input 2 :
9
Sample Output 2 :
9

Code:


public class solution {

	public static int sumOfDigits(int input){
		// Write your code here
         if(input == 0){
			return 0;
		}
		int smallAns = input % 10 + sumOfDigits(input / 10);
		return smallAns  ;
	}
}
