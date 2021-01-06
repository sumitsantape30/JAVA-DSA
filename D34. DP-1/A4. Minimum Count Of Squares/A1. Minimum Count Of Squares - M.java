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
public static int minCountM(int n) {
		int storage[]= new int[n+1];
		
		for( int i=0; i< storage.length; i++) {
			storage[i]= -1;
		}
		
		return minCountM(n, storage);
	}
	
	private static int minCountM(int n, int[] storage) {

		if (n == 0 || n == 1) {
			storage[n] = n;
			return storage[n];
		}

		if (storage[n] != -1) {
			return storage[n];
		}

		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= Math.sqrt(n); i++) {

			int minIntReq = minCountM(n - (i * i), storage);
			if (min > minIntReq) {
				min = minIntReq;
			}
		}

		storage[n] = min + 1;
		return storage[n];
	}

	public static void main(String[] args) {

		int n = 12;
		int num= minCountM(n);
    System.out.println(num);
	}

}
