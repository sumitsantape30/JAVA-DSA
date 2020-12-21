All Indices of Number

Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. Save all the indexes in an array (in increasing order).
Do this recursively. Indexing in the array starts from 0.

Input Format :
Line 1 : An Integer N i.e. size of array
Line 2 : N integers which are elements of the array, separated by spaces
Line 3 : Integer x

Output Format :
indexes where x is present in the array (separated by space)

Constraints :
1 <= N <= 10^3

Sample Input :
5
9 8 10 8 8
8
Sample Output :
1 3 4

Code:

package Restart;

import java.util.Scanner;


public class Recursion {

	public static int[] allIndexes(int input[], int x) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		return allIndexes(input, 0, x);
	}
     private static int[] allIndexes(int input[],int start, int x) {
		if(start == input.length)
		{
			int emptyAry[] = new int[0];
			return emptyAry;
		}
		int[] ans = allIndexes( input, start + 1, x);
		//System.out.println(ans[0] + " "+ ans[1] + " "+ans[2]);
	//	System.out.println(start);
		if(input[start] == x)
		{
			int[] a = new int[ans.length + 1];
			//System.out.println(ans.length);
			a[0] = start;
			//System.out.println( start);
			for(int i = 0; i < ans.length; i++)
			{
				a[i + 1] = ans[i];
				//System.out.println((i + 1) + " "+ans.length);
				//System.out.println(a[i+1] + " "+ ans[i]);
			}
			
			return a;
		}
		
		else {
			 
			return ans;
		}
		
	}
	
	public static void main(String[] args) {

		int arr[] = { 9, 8, 10, 8 };
		int ans[] = allIndexes(arr, 8);
		for( int i=0;i< ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
