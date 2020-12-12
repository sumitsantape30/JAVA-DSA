Binary to decimal

Given a binary number as an integer N, convert it into decimal and print.

Input format :
An integer N in the Binary Format
Output format :
Corresponding Decimal number (as integer)

Constraints :
0 <= N <= 10^9

Sample Input 1 :
1100
Sample Output 1 :
12

Sample Input 2 :
111
Sample Output 2 :
7

Code:

package Assignments;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int ans = 0;
		int pv = 1;
		int v = 1; // v is the first place value)

		while (n != 0) {
			fv = n % 10;
			v = v + (valueAtfirstPlace * pv);
			n = n / 10;
			pv = 2 * pv;
		}

		System.out.println(ans);
	}

}
