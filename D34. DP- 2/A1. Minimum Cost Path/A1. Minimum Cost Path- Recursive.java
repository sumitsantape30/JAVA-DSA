Code : Minimum Cost Path

An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).

From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.

Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.
The second line onwards, the next 'M' lines or rows represent the ith row values.
Each of the ith row constitutes 'N' column values separated by a single space.

Output format :
Print the minimum cost to reach the destination.

Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13

Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76

Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18

Code:


public class MinimumCostPathRecursive {
	
	public static int minCostPath( int arr[][]) { //input will be 2D array.
		
		// path nikalne keliye muje i and j bhi chahiye honge isliye ek aur function banate
		
		return minCostPath(arr, 0, 0); //initially i and j (0,0) pe rahega, muje (0,0) se end tak ka path chahiye. and mera i and j change hote rahega
			
	}
	
	//The work of this function is to get Min Cost Path from cell (i,j) to cell (m-1, n-1) and yeh kam hum recusrsively karenge
	// arr[i][j] se aage hum teen option hai usme travel karenge unke minimum path hume recursion laake dega and hum usme se jo minimum hoga usme a[i][j] add karke return karenge
	private static int minCostPath(int[][] arr, int i, int j) {
		int m= arr.length; //Number of rows
		int n= arr[0].length; //Number of Columns
		
		if( i== m-1 && j== n-1) { //simplest problem will be jaha tumhara destination hai, tum wahi ho means hum last wale cell pe hai, yahi basecase hogi
		   return arr[i][j];  //last cell se last cell tak reach karneki cost will be usi cell ki value
			
		}
		
		if( i >=m || j>= n) { //agar dono mese koi ek range ke bahar gya matlab grid se bahar chale gye hai aur wahase end tak ki path nikal rhe but koi path nhi hai, so path nhi hai to uski cost +infinity kardete.
			return Integer.MAX_VALUE;
		}
		
		// agar basecase true nhi hai to hume travel karna padega so hume teeno options nikalke usmese best wala rakhna hoga.
		int op1= minCostPath(arr, i, j+1); //Right
		int op2= minCostPath(arr, i+1, j+1); // Daigonally
		int op3= minCostPath(arr, i+1, j); // Downside
		
		// in teeno options mese muje jo minimum wala path lake dega woh hume rakhna chahiye and usme arr[i][j] ki value add karenge kyuki yeh cell root ka part hai and return kar dena chahiye
		return arr[i][j]+ Math.min( op1, Math.min(op2, op3));
					
	}

	public static void main(String[] args) {
		
		int arr[][]= {{1,1,1},{4,5,2},{7,8,9}};
		System.out.println(minCostPath(arr));
		
	}

}

