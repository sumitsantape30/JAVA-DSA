First Index of Number

Given an array of length N and an integer x, you need to find and return the first index of integer x present in the array. Return -1 if it is not present in the array.
First index means, the index of first occurrence of x in the input array.
Do this recursively. Indexing in the array starts from 0.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
first index or -1

Constraints :
1 <= N <= 10^3

Sample Input :
4
9 8 10 8
8
Sample Output :
1

Code:

package Restart;

import java.util.Scanner;

public class Recursion {

	public static int findIndex(int arr[], int n) {
		return findIndex(arr, n, 0);
	}

	public static int findIndex(int arr[], int n, int startIndex) {

		if (startIndex >= arr.length - 1) {
			return -1;
		}

		if (arr[startIndex] == n) {
			return startIndex;
		}

		int smallAns = findIndex(arr, n, startIndex + 1);
		return smallAns;

	}

	public static void main(String[] args) {

		int arr[] = { 9, 8, 10, 8 };
		int result = findIndex(arr, 8);
		System.out.println(result);
	}

}
