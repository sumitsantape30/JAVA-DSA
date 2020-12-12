package Restart;

import java.util.Scanner;

public class Practice {

	public static int[] takeInput() {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int arr[] = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = s.nextInt();
		}

		return arr;
	}

	public static void print(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {

		int arr[] = takeInput();
		print(arr);

	}
}

Input: 
5
4
3
4
5
6

Output:
4 3 4 5 6 
