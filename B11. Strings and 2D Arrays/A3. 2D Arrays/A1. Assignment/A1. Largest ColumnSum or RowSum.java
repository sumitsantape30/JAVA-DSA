Largest Row or Column

For a given two-dimensional integer array/list of size (N x M), you need to find out which row or column has the largest
sum(sum of all the elements in a row/column) amongst all the rows and columns.

Note :
If there are more than one rows/columns with maximum sum, consider the row/column that comes first. 
And if ith row and jth column has the same largest sum, consider the ith row as answer.

Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains two integer values, 'N' and 'M', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.
Second line onwards, the next 'N' lines or rows represent the ith row values.
Each of the ith row constitutes 'M' column values separated by a single space.

Output Format :
For each test case, If row sum is maximum, then print: "row" <row_index> <row_sum>
OR
If column sum is maximum, then print: "column" <col_index> <col_sum>
It will be printed in a single line separated by a single space between each piece of information.

Output for every test case will be printed in a seperate line.

 Consider :
If there doesn't exist a sum at all then print "row 0 -2147483648", where -2147483648 or -2^31 is the smallest value for the range of Integer.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
0 <= M <= 10^3
Time Limit: 1sec

Sample Input 1 :
1
2 2 
1 1 
1 1
Sample Output 1 :
row 0 2

Sample Input 2 :
2
3 3
3 6 9 
1 4 7 
2 8 9
4 2
1 2
90 100
3 40
-10 200
Sample Output 2 :
column 2 25
column 1 342

Code:

package Restart;

import java.util.Scanner;

public class Practice {

	public static int[][] input() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = s.nextInt();

		System.out.println("Enter the number of columns");
		int columns = s.nextInt();

		int arr[][] = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println("The element " + i + "th row and " + j + " column is");
				arr[i][j] = s.nextInt();
			}
		}
		return arr;
	}

	public static void print(int arr[][]) {

		int rows = arr.length;
		int columns = arr[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void finfLargest(int arr[][]) {

		int m = arr.length;
		int n = arr[0].length;

		if (m == 0) {
			System.out.println("row " + m + " " + Integer.MIN_VALUE);
		}

		if (n == 0) {
			System.out.println("column" + n + " " + Integer.MIN_VALUE);
		}

		int largeR = Integer.MIN_VALUE;
		int rowIndex = 0;

		for (int i = 0; i < m; i++) {
			int rowSum = 0;
			for (int j = 0; j < n; j++) {
				rowSum = rowSum + arr[i][j];
			}
			if (rowSum > largeR) {
				largeR = rowSum;
				rowIndex = i;
			}
		}

		int largeC = Integer.MIN_VALUE;
		int columnIndex = 0;

		for (int j = 0; j < n; j++) {
			int columnSum = 0;
			for (int i = 0; i < m; i++) {
				columnSum = columnSum + arr[i][j];
			}

			if (columnSum > largeC) {
				largeC = columnSum;
				columnIndex = j;
			}
		}

		if (largeR > largeC) {
			System.out.println("row " + rowIndex + " " + largeR);
		} else if (largeR < largeC) {
			System.out.println("column " + columnIndex + " " + largeC);
		} else if (largeC == largeR) {
			System.out.println("row " + rowIndex + " " + largeR);
		}
	}

	public static void main(String[] args) {

		int input[][] = input();
		print(input);
		finfLargest(input);
	}
}

Output:

Enter the number of rows
3
Enter the number of columns
2
The element 0th row and 0 column is
2
The element 0th row and 1 column is
2
The element 1th row and 0 column is
1
The element 1th row and 1 column is
1
The element 2th row and 0 column is
1
The element 2th row and 1 column is
1
2 2 
1 1 
1 1 
row 0 4
