Check Number in Array

Given an array of length N and an integer x, you need to find if x is present in the array or not. Return true or false.
Do this recursively.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x
Output Format :
'true' or 'false'

Constraints :
1 <= N <= 10^3

Sample Input 1 :
3
9 8 10
8
Sample Output 1 :
true

Sample Input 2 :
3
9 8 10
2
Sample Output 2 :
false

Code:

import java.util.Scanner;

public class Check_Number_In_Array {

	public static boolean Check(int arr[], int ele) {
		if (ele < 0) {
			return false;
		}
		if (arr[0] == ele) {
			return true;
		}

		int smallAry[] = new int[arr.length - 1];
		for (int i = 1; i < arr.length; i++) {
			smallAry[i - 1] = arr[i];
		}

		boolean smallAns = Check(smallAry, ele);
		return smallAns;

	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ele = s.nextInt();
		int arr[] = { 2, 3, 4, 1, 3 };
		boolean result = Check(arr, ele);
		System.out.println(result);
	}

}
