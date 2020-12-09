package patterns;

import java.util.Scanner;

public class p6_triangular {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while (i <= n) {
			int j = 1;
			int startingNum = i;
			while (j <= i) {
				System.out.print(startingNum);
				startingNum++;
				j++;

			}
			System.out.println();
			i++;

		}

	}

}

Input: 5
Output: 
1
23
345
4567
56789
