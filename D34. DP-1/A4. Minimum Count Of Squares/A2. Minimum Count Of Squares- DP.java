Code: Minimum Count of Squares

Given an integer N, find and return the count of minimum numbers required to represent N as a sum of squares.
That is, if N is 4, then we can represent it as : {1^2 + 1^2 + 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the minimum count of numbers required to represent N as sum of squares.

Input format :
The first and the only line of input contains an integer value, 'N'.
 Output format :
Print the minimum count of numbers required.

Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec

Sample Input 1 :
12
Sample Output 1 :
3
Explanation of Sample Output 1 :
12 can be represented as : 
A) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)

B) (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1) + (1^1)  + (2 ^ 2)

C) (1^1) + (1^1) + (1^1) + (1^1) + (2 ^ 2) + (2 ^ 2)

D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)

As we can see, the output should be 3.

Sample Input 2 :
9
Sample Output 2 :
1

Code:

public class MinimumCountOfSquares {

	public static int minCount(int n) {

		int storage[] = new int[n + 1];
		storage[0] = 0;
		storage[1] = 1;

		for (int i = 2; i <= n; i++) {

			int min = Integer.MAX_VALUE;

			for (int j = 1; j <= Math.sqrt(i); j++) {
				
				int count = storage[i - (j * j)];
				if (min > count) {
					min = count;
				} 
			}
			storage[i] = min + 1;
		}

		return storage[n];
	}
  
public static void main(String[] args) {

		int n = 12;
		System.out.println(minCount(n));
	}

}
