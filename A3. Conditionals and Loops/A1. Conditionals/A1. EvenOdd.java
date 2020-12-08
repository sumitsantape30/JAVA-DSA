package if_else;

import java.util.Scanner;

public class EvenOdd {

	public static void main(String[] args) {
		
// Approach 1-------------------------------------------------
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int rem = n % 2 ;
		
		if( rem == 0 ){
			System.out.println("Even");
		}else{
			System.out.println("Odd");
		}
		//Input: 5
               // Output: Odd
			
		
//Approach 2--------------------------------------------------
		Scanner s = new Scanner(System.in);
		
		int n = s.nextInt();
		int rem = n%2;
		
		if( rem == 0) {
			System.out.println( "True" );
		}
		System.out.println( "Odd" );
		//Input 1    :5
                // Output 1  : Odd
		// Input 2   : 8
                // Output 2  : True
                //            Odd
		
//Approach 3-------------------------------------------------
		Scanner s= new Scanner(System.in);
		
		int n = s.nextInt();
		int rem = n % 2 ;
		
		if( rem == 0) {
			System.out.println( "Even" );
			return;
		}
		System.out.println( "Odd" );
		//Input 1    : 7
                // Output 1  : Odd
		// Input 2   : 8
                // Output 2  :Even	
	}
}

