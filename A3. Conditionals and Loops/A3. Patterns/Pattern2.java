package patterns;

import java.util.Scanner;

public class Pattern2 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		int val = 1;
		while (i <= n) {
			int j = 1;
			while (j <= i) {
				System.out.print(val);
				val = val + 1;
				j = j + 1;
			}
			System.out.println();
			i = i + 1;
		}
	}
}

Input: 5
Output:
1 
2 3 
4 5 6 
7 8 9 10 
11 12 13 14 15 
