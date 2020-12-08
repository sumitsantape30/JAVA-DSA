package if_else;

import java.util.Scanner;

public class LargestOfThree {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();

// Variation 1 ----------------------------------------------
		if( a >= b && a >= c ) {
			System.out.println(a);
		}else {
			if( b >= a && b >= c) {
				System.out.println(b);
			}else {
				System.out.println(c);
			}
			
				
//Input :  5 6 7
//Output : 7
	
// Variation 2 ----------------------------------------------
		
		if (a >= b && a >= c) {
			System.out.println("A");
			System.out.println(a);
		} else if(b >= c&& b >= a) {
			System.out.println("B");
			System.out.println(b);
		} else {
			System.out.println("C");
			System.out.println(c);
		}
// Input :  10 10 5
// Output : A
//          10

	}
}


