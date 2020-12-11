package lec6;

public class BitwiseOperator {

	public static void main(String[] args) {

		System.out.println(2 & 3); //Bitwiae And
		System.out.println(2 | 3); // Bitwise or
		System.out.println(~2);    // not of 2 (negation)
		System.out.println(2 ^ 3); // Exclusive XOR
		
		System.out.println(34 << 1); //Left Shift Operator (34*2=68) (It multiplies by 2 for each shift)
		System.out.println(34 >> 1); //Right Shift Operator (34/2=17) (It divides by 2 for each shift)

	}
}

Output:
2
3
-3
1
68
17

