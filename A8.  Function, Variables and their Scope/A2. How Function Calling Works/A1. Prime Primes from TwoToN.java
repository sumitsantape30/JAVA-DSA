package Practice;

import java.util.Scanner;

public class primeNumbers {

	public static boolean isPrime(int n) {

		int d = 2;
		while (d <= n - 1) {
			if (n % d == 0) {
				return false;
			}
			d++;
		}
		return true;
	}

	public static void printPrime(int n) {

		for (int i = 2; i <= n; i++) {
			boolean isIPrime = isPrime(i);

			if (isIPrime) {
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {

		printPrime(100); 
		System.out.println("Back in main");// this Back in main is printed only after printprime() is completely run. main printprime() run hone ka wait karega.
	}

}

Output:
2
3
5
7
11
13
17
19
23
29
31
37
41
43
47
53
59
61
67
71
73
79
83
89
97
