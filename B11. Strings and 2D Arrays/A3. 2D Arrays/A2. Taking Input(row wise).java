package Restart;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the nuber of rows");
		int rows = s.nextInt();
		System.out.println("Enter the number of columns");
		int columns = s.nextInt();

		int arr[][] = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println("The element at " + i + "the row and " + j + "th column");
				arr[i][j] = s.nextInt();
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println(); // ek row ek row mai print honi chahiye so har row ke bad new line mai ana chahiye.
		}

	}
}

Output:

Enter the nuber of rows
3
Enter the number of columns
4
The element at 0the row and 0th column
5
The element at 0the row and 1th column
6
The element at 0the row and 2th column
8
The element at 0the row and 3th column
9
The element at 1the row and 0th column
1
The element at 1the row and 1th column
4
The element at 1the row and 2th column
5
The element at 1the row and 3th column
6
The element at 2the row and 0th column
7
The element at 2the row and 1th column
8
The element at 2the row and 2th column
9
The element at 2the row and 3th column
8
5 6 8 
1 4 5 
7 8 9 
