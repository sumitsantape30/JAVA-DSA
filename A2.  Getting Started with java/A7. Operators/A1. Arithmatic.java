import java.util.Scanner;

public class FahToCel {

	public static void main(String[] args) {
//		Scanner s = new Scanner(System.in);
//		int f = s.nextInt();
//		//int cel = (5/9)*(f - 32); // Output: 0  ( coz int/int == int )
//		//int cel = (5 * (f - 32))/9;
//		
//		int cel = (int)((5.0/9)*(f - 32));
//		System.out.println(cel);
		
		System.out.println(9/5); // output: 1
		System.out.println(9.0/5); // output: 1.8
		
		System.out.println(9  + 5);
		System.out.println(9  - 5);
		System.out.println(9  / 5);
		System.out.println(9  * 5);
		
		System.out.println(9 % 5); // Output: 4 (gives remainder)
		
   // Using Arithmatic operator on Characters
		
		System.out.println('a'/3); // Output: 32  (66/3 == 32)
		
		
		char c = 'a';  
	      // int i= c+3; // output: 100 (c+3 is an integer)
		char i = (char)(c + 3);  
		System.out.println(i); // output: d (we explicitly type casted into characters so 'd', d corresponds to 100
		
		System.out.println('a' + 'b'); // output: 195
		
		System.out.println('a'/3); //Output: 32
		
		
	}

}
