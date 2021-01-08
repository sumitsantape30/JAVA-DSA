Shortest Subsequence

Gary has two string S and V. Now, Gary wants to know the length shortest subsequence in S, which is not a subsequence in V.

Note: The input data will be such that there will always be a solution.

Input Format :
The first line of input contains a string, that denotes the value of S. The following line contains a string, that denotes the value of V.
Output Format :
Length of shortest subsequence in S such that it is not a subsequence in V

Constraints:
1 <= N <= 1000
1 <= M <= 1000 
Time Limit: 1 second

Sample Input 1:
babab
babba
Sample Output 1:
3
Explanation:
"aab" is the shortest subsequence which is present in S and absent in V.

Code:

public class Solution {

	public int solve(String S,String V){
       int m = S.length();
		int n = V.length();
		int [][]storage = new int[m + 1][n + 1];
		
		for( int i = 1; i <= m; i++ ) {
			storage[i][0] = 1;
		}
		
		for( int j = 1; j <= n; j++ ) {
			storage[0][j] = Integer.MAX_VALUE;
		}
		
		for( int i = 1; i <= m; i++ ) {
			char ch = S.charAt(i - 1);
			for( int j = 1; j <= n; j++ ) {
				//Searching
				int k ;
				for( k = j-1; k >= 0; k-- ) {
					if( V.charAt(k) == ch ) {
						break;
					}
				}
				//Not found
				if( k == -1 ) {
					storage[i][j] = 1;
				}
				else
				{
					int x = storage[i - 1][j];
					int y = storage[i - 1][k];
					if( y != Integer.MAX_VALUE ) {
						y++;
					}
					storage[i][j] = Math.min(x, y);
				}
			}
		}
		return storage[m][n];
		
	}
	
}
