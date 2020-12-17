import java.util.Scanner;

public class how2DArayysAreStored {

	public static int[][] input() {

		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of rows");
		int rows = s.nextInt();
		System.out.println("Enter the number of columns");
		int columns = s.nextInt();

		int arr[][] = new int[rows][columns];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println("The element at " + i + "th row and " + j + "th column");
				arr[i][j] = s.nextInt();
			}
		}
		return arr;
	}

	public static void print(int arr[][]) {

		int rows = arr.length;
		int columns = arr[0].length;
		int largest = Integer.MIN_VALUE;
		
		//column number fix karke row pe iterate karna hai
		for (int j = 0; j < columns; j++) {
			int sum = 0;
			for (int i = 0; i < rows; i++) {
				sum = sum + arr[i][j]; //arr[j][i] == yeh nhi kr skte coz first [] row hota hai and second [] colummn hota hai so they cannot be changed.
			}

			if (sum > largest) {
				largest = sum;
			}
		}
		System.out.println(largest);
	}

	public static void main(String[] args) {

		int arr[][] = input();
		print(arr);
	}
}
