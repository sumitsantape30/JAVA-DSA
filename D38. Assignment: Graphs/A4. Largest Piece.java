Largest Piece

It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake. Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?

Input Format :
The first line of input contains an integer, that denotes the value of N. 
Each of the following N lines contain N space separated integers.
Output Format :
Print the count of '1's in the biggest piece of '1's, according to the description in the task.

Constraints :
1 <= N <= 1000
Time Limit: 1 sec

Sample Input 1:
2
1 1
0 1
Sample Output 1:
3

Code:

public class Solution {

    static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static int dfs(String[] edge, int n) {
		boolean[][] visited = new boolean[n][n];
		 int max = 0;
		   for( int i = 0; i < n; i++ ) {
			   for( int j = 0; j < n; j++ ) {
				   if( !visited[i][j] && edge[i].charAt(j) == '1' ) {
					   int ans = maxPiece( edge, i, j, visited, n );
					   if( ans > max ) {
						   max = ans;
					   }
				   }
			   }
		   }
		   return max;
	}

     private static int maxPiece(String[] edge, int i, int j, boolean[][] visited, int n) {
    	int xdir[] = {1, 0, 0, -1};
		int ydir[] = {0, 1, -1, 0};
		visited[i][j] = true;
		int count = 0;
		for( int l = 0; l < xdir.length; l++ ) {
			int x = xdir[l] + i;
			int y = ydir[l] + j;
			
			if( x >= 0 && y >= 0 && x < edge.length && y < edge[0].length() && edge[x].charAt(y) == '1' && !visited[x][y] ) {
				
				count += maxPiece( edge, x, y, visited, n );
				
			}
		}
		return count + 1;
    	
	}
}
