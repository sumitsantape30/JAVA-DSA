Fibonacci Number

Given a number N, figure out if it is a member of fibonacci series or not. 
Return true if the number is member of fibonacci series else false.

Fibonacci Series is defined by the recurrence
    F(n) = F(n-1) + F(n-2)
where F(0) = 0 and F(1) = 1

Input Format :
Integer N
Output Format :
true or false

Constraints :
0 <= n <= 10^4

Sample Input 1 :
5
Sample Output 1 :
true

Sample Input 2 :
14
Sample Output 2 :
false    

Code: 

package Practice;

import java.util.Scanner;

public class primeNumbers {

	public static boolean isFibo(int n) {

		int a = 0;
		int b = 1;
		int c = 0;

		while (a <= n) {
			c = a + b;
			a = b;
			b = c;

			if (a == n) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean result = isFibo(n);
		System.out.println(result);
	}

}

Input:5
Output:
true
