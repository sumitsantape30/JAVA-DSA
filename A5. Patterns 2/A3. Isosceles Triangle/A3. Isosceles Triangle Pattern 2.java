package patterns;

import java.util.Scanner;

public class isoscelesTrianglePattern2 {

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
			int p = i;
			while (j <= i) {
				System.out.print(p);
				p++;
				j++;
			}

			j = 2 * i - 2;
			while (j >= i) {
				System.out.print(j);
				j--;
			}
			System.out.println();
			i++;
		}
	}
}

Input: 4
Output:
   1
  232
 34543
4567654

