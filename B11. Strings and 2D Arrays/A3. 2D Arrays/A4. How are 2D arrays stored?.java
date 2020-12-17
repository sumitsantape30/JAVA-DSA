package Restart;

import java.util.Scanner;

public class Practice {

	
	public static void main(String[] args) {
         
		
		// 2D array is the collection of 1D arrays, and master array has the addresses of all the 1D array in 2D array.
		// input ki har entry mai address of 1D array hota hai
		// arr is the reference of the master array
		// arr[0] means master array ka 0th ki bat karre
		
		int arr[][]= {{1,2,3}, {4,5,6}};
		System.out.println(arr); //yeh master array ka address print karega
		//Output: [[I@15db9742 (This is the address of 2D array as there are two brackets)
		
		System.out.println(arr[0]); // master array ke 0th pe jis 1D array ka address hai woh print karega.
		//Output: [I@6d06d69c  (This is the address of 1D array as there is one bracket)
		
		for( int i=0; i<2 ; i++) {
			System.out.println(arr[i]); // yeh master array mai jitne bhi 1D array ke address hai sabko print karega.
		}
		//Output: [I@6d06d69c
		//        [I@7852e922

		
		//length of ith row (master array ka size will give me row length)
		System.out.println(arr.length); //master array ki length print karega which means row ki length print karega
        //Output: 2
		
		// length of column
		for( int i=0; i<2; i++) {
			System.out.println(arr[i].length); //mastar array mai jo ith position pe 1D array hai uski length dega wahi number of columns dega.
		}
		//Output: 3
		//        3
		
	}
}
