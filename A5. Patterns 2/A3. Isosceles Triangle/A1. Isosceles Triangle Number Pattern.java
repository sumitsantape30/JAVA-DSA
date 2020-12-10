package patterns;

import java.util.Scanner;

public class IsoscelesTrianglePattern {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		int i = 1;
		while (i <= n) {
			int space = 1;
			while (space <= n - i) {
				System.out.print(" ");
				space++;
			}

			int j = 1;
			while (j <= i) {
				System.out.print(j);
				j++;
			}

			j = 1;
			int p = i - 1;
			while (j <= i - 1) {
				System.out.print(p);
				p--;
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
  121
 12321
1234321
