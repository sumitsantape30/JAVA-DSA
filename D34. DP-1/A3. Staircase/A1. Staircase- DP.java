Code: Staircase

A child runs up a staircase with 'n' steps and can hop either 1 step, 2 steps or 3 steps at a time. Implement a method to count and return all possible ways in which the child can run-up to the stairs.

Input format :
The first and the only line of input contains an integer value, 'n', denoting the total number of steps.
Output format :
Print the total possible number of ways.

Constraints :
0 <= n <= 10 ^ 4

Time Limit: 1 sec
Sample Input 1:
4
Sample Output 1:
7

Sample Input 2:
10
Sample Output 2:
274

Code:

public class Solution {

	public static long staircase(int n) {
        if( n == 1 ){
            return 1;
        }
		long storage[] = new long[n+1];
		storage[0] = 1;
		storage[1] = 1;
		storage[2] = 2;
		
		for( int i = 3; i <= n; i++ ) {
			storage[i] = storage[i-1] + storage[i-2] + storage[i-3];
		}
		
		return storage[n];
	}

}
