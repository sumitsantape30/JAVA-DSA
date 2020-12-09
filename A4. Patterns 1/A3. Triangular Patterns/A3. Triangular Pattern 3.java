package patterns;

import java.util.Scanner;

public class p7_triangular {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		int val = 1;
		while (i <= n) {
			int j = 1;
			while (j <= i) {
				System.out.print(val);
				val++;
				j++;
			}
			System.out.println();
			i++;
		}

	}

}

Input: 4
Output:
1
23
456
78910
