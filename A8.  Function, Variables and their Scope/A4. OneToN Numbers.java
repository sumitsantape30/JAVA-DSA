package Practice;

import java.util.Scanner;

public class primeNumbers {

	public static void printNum(int n) {

		if (n < 0) {
			return;
		}

		int i = 1;
		while (i <= n) {
			System.out.println(i);
			i++;
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		printNum(n);
	}

}

Input:5
Output:
1
2
3
4
5
