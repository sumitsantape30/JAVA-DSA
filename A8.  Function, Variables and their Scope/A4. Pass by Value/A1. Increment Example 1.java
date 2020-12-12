package Practice;

import java.util.Scanner;

public class increment {

//==========================================================================================================================================================

	public static void increment(int n) {
		n = n + 1;
	}

	public static void main(String[] args) {
		int a = 10;
		increment(10);
		System.out.println(a); //Output: 10
    
// I am not giving access to my variable(a), I am passing/copying the value to the storage of n

//===========================================================================================================================================================

// But agar tum change karna chahte ho, one option was returning new value from increment function aur mai niche 'a' ko update kar denge.

public static int increment(int n) {
		n = n + 1;
		return n;
	}

	public static void main(String[] args) {
		int a = 10;
		a= increment(10);
		System.out.println(a); //Output: 11
    
	}
}
