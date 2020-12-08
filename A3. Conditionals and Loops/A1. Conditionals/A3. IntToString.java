package if_else;

import java.util.Scanner;

public class IntToString {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		
//Approach 1 ---------------------------------------------
                if( n == 1) {
			System.out.println("One");
		}else if( n == 2) {
			System.out.println("Two");
		}else if( n == 3) {
			System.out.println("Three");
		}else {
			System.out.println("Invalid Input");
		}
// Input : 3
// Output : Three
		
//Approach 2 --------------------------------------------
		if (a == 1) {
			System.out.println("One");
		}
		
		if (a == 2) {
			System.out.println("Two");
		}
		
		if (a == 3) {
			System.out.println("Three");
		}
// Input :  1
// Output : One
	}

}
