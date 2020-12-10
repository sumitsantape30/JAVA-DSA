Code : Interesting Alphabets

Print the following pattern for the given number of rows.

Pattern for N = 5
E
DE
CDE
BCDE
ABCDE

Input format :
N (Total no. of rows)
Output format :
Pattern in N lines

Constraints
0 <= N <= 26

Sample Input 1:
8
Sample Output 1:
H
GH
FGH
EFGH
DEFGH
CDEFGH
BCDEFGH
ABCDEFGH

Sample Input 2:
7
Sample Output 2:
G
FG
EFG
DEFG
CDEFG
BCDEFG
ABCDEFG

Code:
package patterns;

import java.util.Scanner;

public class InterestingAlphabets {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int i = n;
		int k = 0;
		while (i >= 1) {
			int j = 1;
			k = i;
			while (j <= n - i) {
				System.out.print((char) (k + 64));
				k++;
				j++;
			}
			System.out.println();
			i--;
		}
	}
}
