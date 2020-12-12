package Restart;

import java.util.Scanner;

public class Practice {

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];

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

	public static int largest(int arr[]) {
		int largest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= largest) {
				largest = arr[i];
			}
		}
		return largest;
	}

	public static void main(String[] args) {
		int arr[] = takeInput();
		print(arr);
		int max = largest(arr);
		System.out.println(max);

	}
}

Input:
5
7
8
9
7
4

Output:
7 8 9 7 4 
9
