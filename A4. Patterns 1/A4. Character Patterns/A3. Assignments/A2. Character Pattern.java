Code : Character Pattern

Print the following pattern for the given N number of rows.
	
Pattern for N = 4
A
BC
CDE
DEFG

Input format :
Integer N (Total no. of rows)
Output format :
Pattern in N lines

Constraints
0 <= N <= 13
	
Sample Input 1:
5
Sample Output 1:
A
BC
CDE
DEFG
EFGHI

Sample Input 2:
6
Sample Output 2:
A
BC
CDE
DEFG
EFGHI
FGHIJK

Code:
package patterns;

import java.util.Scanner;

public class CharTriangular {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = 1;
		while (i <= n) {
			char startingchar = (char) ('A' + i - 1);
			int j = 1;
			while (j <= i) {
				System.out.print(startingchar);
				startingchar = (char) (startingchar + 1);
				j++;

			}
			System.out.println();
			i++;

		}

	}

}

Input:5
Output:
A
BC
CDE
DEFG
EFGHI

