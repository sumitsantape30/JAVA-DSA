Sum of Array

Given an array of length N, you need to find and return the sum of all elements of the array.
Do this recursively.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Output Format :
Sum

Constraints :
1 <= N <= 10^3

Sample Input 1 :
3
9 8 9
Sample Output 1 :
26

Sample Input 2 :
3
4 2 1
Sample Output 2 :
7  

Code:

package Recursion1;

import java.util.Scanner;

public class Recursion {

	public static int arraySum( int arr[], int n) {
		
		if( n == 1) {
			return arr[0]; //yaha array nhi return karre arr[0] pe jo integer value hai woh return karre.
		}
		
		return arr[n-1] + arraySum(arr, n-1);
	}

	public static void main(String[] args) {

		int input[]= {1,2,3,4,5,6};
		int sum= arraySum(input, input.length);
		System.out.println(sum);
	}

}
