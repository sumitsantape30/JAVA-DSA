Matrix Chain Multiplication

Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices. In other words, determine where to place parentheses to minimize the number of multiplications.
You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.

Input Format:
The first line of input contains an integer, that denotes the value of n. The following line contains n+1 integers, that denote the value of elements of array p[].
Output Format:
The first and only line of output prints the minimum number of multiplication needed.

Constraints :
1 <= n <= 100
Time limit: 1 second

Sample Input 1:
3
10 15 20 25
Sample Output 1:
8000
Sample Output Explanation:
There are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.
If we multiply in order- A1*(A2*A3), then number of multiplications required are 15000.
If we multiply in order- (A1*A2)*A3, then number of multiplications required are 8000.
Thus minimum number of multiplications required are 8000. 

Code:


public class Solution {

	
	public static int mcm(int[] p){
		int n = p.length;
		int storage[][] = new int[n][n];
		
		for( int i = 0; i < n; i++ ) {
			storage[i][i] = 0;
		}
		
		for( int l = 2; l < n; l++ ) {
			for( int i = 1; i < n-l+1 ; i++ ) {
				int j = i + l - 1;
			    if( j == n) {
			    	continue;
			    }
			    storage[i][j] = Integer.MAX_VALUE;
			    
			    for( int k = i; k <= j-1; k++ ) {
			    	int q = storage[i][k] + storage[k+1][j] + p[i-1] * p[k] * p[j];
			    	if( q < storage[i][j] ) {
			    		storage[i][j] = q;
			    	}
			    }
			}
		}
       return storage[1][n-1];
	}
}
