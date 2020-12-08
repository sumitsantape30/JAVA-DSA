package while_loop;

import java.util.Scanner;

public class Print1ToN {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int i = 1;
		
		while (i <= n) {
			System.out.println(i);
			i = i + 1;
		}
	}
}

Input : 6
Output:
1
2
3
4
5
6

