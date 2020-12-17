package Restart;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		int arr2[][] = new int[4][];

		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = new int[i + 2]; // hum master array ke har index pe i+2 size ka 1D array bana rhe
		}

		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) { //muje ith row ka length chahiye, so arr[i] will make me to reach ith row.
               System.out.print(arr2[i][j]+" ");
			}
			System.out.println();
		}
	}
}

//So, we can have an array jisme har row ki size different ho.

Output:

0 0 
0 0 0 
0 0 0 0 
0 0 0 0 0 
