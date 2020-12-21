package Restart;

import java.util.Scanner;

public class Recursion {

	public static boolean checkSortedBetter(int input[]) {
		return checkSortedBetter(input, 0);
	}

	private static boolean checkSortedBetter(int input[], int startIndex) {

		if (startIndex >= input.length - 1) {
			return true;
		}

		if (input[startIndex] > input[startIndex + 1]) {
			return true;
		}

		boolean smallAns = checkSortedBetter(input, startIndex + 1);
		return smallAns;

	}

	public static void main(String[] args) {

		int input[] = { 1, 2, 3 };
		System.out.println(checkSortedBetter(input));

	}

}
