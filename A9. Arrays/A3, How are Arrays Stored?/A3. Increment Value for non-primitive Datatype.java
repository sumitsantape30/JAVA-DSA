package HowAreArraysStored;

import java.util.Scanner;

public class HowAreArrayStored {

	public static void incrementArr(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			arr[i]++;
		}
	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		incrementArr(arr);
		print(arr);

	}

}

Output: 
2
3
4
5
6
