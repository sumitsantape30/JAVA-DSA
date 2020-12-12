package Functions;

import java.util.Scanner;

public class PrimeNum {
	public static boolean isPrime(int n) {
		int d = 2;
		for (d = 2; d <= n - 1; d++) {
			if (n % d == 0) {
				return false;

			}
			d++;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		boolean ansPrime = isPrime(n);
		System.out.println(ansPrime);

	}

}

Input:
2

Output:
true
