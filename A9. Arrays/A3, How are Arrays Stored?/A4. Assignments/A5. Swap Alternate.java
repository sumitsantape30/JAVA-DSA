Swap Alternate

You have been given an array/list(ARR) of size N. You need to swap every pair of alternate elements in the array/list.
You don't need to print or return anything, just change in the input array itself.

Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output Format :
For each test case, print the elements of the resulting array in a single row separated by a single space.
Output for every test case will be printed in a separate line.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^5

Time Limit: 1sec

Sample Input 1:
1
6
9 3 6 12 4 32
Sample Output 1 :
3 9 12 6 32 4

Sample Input 2:
2
9
9 3 6 12 4 32 5 11 19
4
1 2 3 4
Sample Output 2 :
3 9 12 6 32 4 11 5 19 
2 1 4 3 

Code:

package HowAreArraysStored;

import java.util.Scanner;

public class HowAreArrayStored {

	public static int[] input() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void print(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}

	public static void swapAlternate(int arr[]) {

		for (int i = 0; i < arr.length - 1; i += 2) { // Jab last wala element pe operation hoga to mera i= n honga and
														// i+2= n+1 hoga jo exceed karra so pehlehi n-1 tak run karwao
			swap(arr, i, i + 1);
		}
	}

	public static void swap(int arr[], int i, int j) {

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		int arr[] = input();
		swapAlternate(arr); // main wala arr and swapAlternate function wale arr ke pas ek hi array ka
							// address hai isliye swap function mai jobhi changes honge woh real array mai
							// honge
		print(arr);
	}

}
