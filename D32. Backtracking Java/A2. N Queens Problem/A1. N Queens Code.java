Code: N Queens

You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.

Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space

Note : Don't print anything if there isn't any valid configuration.

Constraints :
1<=N<=10

Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0 

Code:


public class Solution {
	
		
public static void placeNQueens(int n){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */

	int board[][] = new int[n][n];
		int leftDia[] = new int[30];
		int rightDia[] = new int[30];
		int colms[] = new int[30];
		placeQueensOptimized(n, 0, board, leftDia, rightDia, colms );
		//placeQueens(n, 0, board);
	}
	
	
	private static void placeQueensOptimized(int n, int col, int[][] board,int[] leftDia, int rightDia[], int colms[] ) {
		if( col == n ) {
			//valid board configuration
			for( int i = 0; i < n; i++ ) {
				for( int j = 0; j < n; j++ ) {
					System.out.print(board[i][j] + " ");
				}
				//System.out.println();
			}
			System.out.println();
			return;
		}
		
		for( int i = 0; i < n; i++ ) {
			if(( leftDia[i - col + n - 1] != 1 && rightDia[i + col] != 1) && colms[i] != 1) {
				
				board[i][col] = 1;
				leftDia[i - col + n - 1] = rightDia[i + col] = colms[i] = 1;
				
				placeQueensOptimized(n, col + 1, board, leftDia, rightDia, colms);
				
				board[i][col] = 0;
				leftDia[i - col + n - 1] = rightDia[i + col] = colms[i] = 0;
			}
		}
	}
}
