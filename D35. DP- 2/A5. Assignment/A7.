Maximum Square Matrix With All Zeros

Given an NxM matrix that contains only 0s and 1s, find out the size of the maximum square sub-matrix with all 0s. You need to return the size of the square matrix with all 0s.

Input format :
The first line of the test case contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively.
Second-line onwards, the next 'N' lines or rows represent the ith row values.
Each of the ith rows constitutes column values separated by a single space (Either 0 or 1).
Output Format:
Print the size of maximum square sub-matrix.
 
 Constraints :
0 <= N <= 10^4
0 <= M <= 10^4

Time Limit: 1 sec

Sample Input 1:
3 3
1 1 0
1 1 1
1 1 1
Sample Output 1:
1

Sample Input 2:
4 4
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
Sample Output 2:
4

Code:


public class Solution {
	

	public static int findMaxSquareWithAllZeros(int[][] input){
        
          if( input.length == 0  ) {
			  return 0;
		  }
        
	      int n = input.length;
		  int m = input[0].length;
		  
         
		  int [][]storage = new int[n][m];
		  int max = Integer.MIN_VALUE;
		  
		  for( int i = 0; i < n; i++ ) {
			 
			  if( input[i][0] == 0 ) {
				  
				  storage[i][0] = 1;
			  
			  } else {
				  
				  storage[i][0] = 0;
			  }
			  if( max < storage[i][0] ) {
				  
				  max = storage[i][0];
			  }
		  }
		
		  for( int i = 0; i < m; i++ ) {
				 
			  if( input[0][i] == 0 ) {
				  
				  storage[0][i] = 1;
			  
			  } else {
				  
				  storage[0][i] = 0;
			  }
			  if( max < storage[0][i] ) {
				  
				  max = storage[0][i];
			  }
		  }
		
		  for( int i = 1; i < n; i++ ) {
			  for( int j = 1; j < m; j++ ) {
				  if( input[i][j] == 0 ) {
					  storage[i][j] = Math.min( storage[i - 1][j - 1], Math.min( storage[i][j - 1], storage[i - 1][j])) + 1;
				  }else {
					  storage[i][j] = 0;
				  }
				  if( max < storage[i][j] ) {
					  max = storage[i][j];
				  }
			  }
		  }
		  
		  return max;
	
	}

	
}
