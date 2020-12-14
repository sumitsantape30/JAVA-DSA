package HowAreArraysStored;

import java.util.Scanner;

public class HowAreArrayStored {

	public static void incrementArr(int arr[]) {

		for (int i = 0; i < arr.length; i++) {
			arr[i]++; //incrementArr and main wala arr ek hi array ko refer kar rha hai so changes hoga hi array and wahi incremented array print hoga 
		}
	}

	public static void print(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		incrementArr(arr);
		print(arr);
Output: 2 3 4 5 6 

//=======================================================================================================================
	
package HowAreArraysStored;

import java.util.Scanner;

public class HowAreArrayStored {

	public static void incrementArr( int arr[]) {
		 arr = new int[5];
		for( int i=0; i< arr.length; i++) {
			arr[i]++;    			
		}
		
	}
	
	public static void print( int arr[]) {
		for( int i=0; i<  arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		incrementArr(arr);
		print(arr);

	}
}
		
Output: 1 2 3 4 5 
	
//=========================================================================================================================================
		
		public static int[] incrementArr( int arr[]) {
		 arr = new int[5];
		for( int i=0; i< arr.length; i++) {
			arr[i]++;    			
		}
		return arr;
	}
	
	public static void print( int arr[]) {
		for( int i=0; i<  arr.length ; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };
		int incremented[]= 	incrementArr(arr);
		print(incremented);

Output: 1 1 1 1 1 
		
//==============================================================================================================================
		
		
	}

}


