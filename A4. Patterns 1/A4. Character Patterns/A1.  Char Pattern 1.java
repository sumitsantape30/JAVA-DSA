package patterns;

import java.util.Scanner;

public class char_pattern {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print((char) ('A' + j - 1));
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
ABCD
ABCD
ABCD
