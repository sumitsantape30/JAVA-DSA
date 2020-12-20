package Restart;

import java.util.Scanner;

public class Recursion {

	public static int fibo(int n) {

		if (n == 0 || n == 1) {
			return n;
		}

		return fibo(n - 1) + fibo(n - 2); // hum assume karenge ki n-1 and n-2 keliye yeh function sahi se work karega
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int num = fibo(n);
		System.out.println(num);
	}

}
