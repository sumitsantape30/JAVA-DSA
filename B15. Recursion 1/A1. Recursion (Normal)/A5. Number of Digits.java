package Restart;

import java.util.Scanner;

public class Recursion {

	public static int countNum(int n) {

		if (n == 1) {
			return 1;
		}

		int smallans = countNum(n / 10);
		int ans = smallans + 1;
		return ans;
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int result = countNum(n);
		System.out.println(result);
	}

}
