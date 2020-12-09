package patterns;

import java.util.Scanner;

public class Charpattern2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while (i <= n) {
			int j = 1;
			char startingChar = (char) ('A' + i - 1);
			while (j <= n) {
				System.out.print(startingChar);
				startingChar = (char) (startingChar + 1);
				j++;
			}
			System.out.println();
			i++;
		}

	}

}

Input: 4
Output:
ABCD
BCDE
CDEF
DEFG
