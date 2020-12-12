package Practice;

import java.util.Scanner;

public class increment {

	public static void increment(int n) {
		n = n + 1;
	}

	public static void main(String[] args) {
		int a = 10;
		increment(10);
		System.out.println(a);

//Increment wale 'n' ka and main wale 'n' ka koi relation nhi hai
// Both n's have their own scopes inside brackets.

	}
}
