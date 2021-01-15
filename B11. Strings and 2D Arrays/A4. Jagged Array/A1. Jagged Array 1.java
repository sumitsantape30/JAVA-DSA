package JaggedArray;

import java.util.Scanner;

public class jaggedArray1 {

	public static void main(String[] args) {

		int arr[][]= new int[3][5];
		
		System.out.println(arr); //yeh master array ka address print karega
		//Output: [[I@15db9742

		System.out.println(arr[0]); //jo master array mai 0th index pe jis 1D array ka address hai woh print karega.
		//Output: [I@6d06d69c

		System.out.println(arr[1]); //jo master array mai 1th index pe jis 1D array ka address hai woh print karega.
	    //Output: [I@7852e922

		System.out.println(arr[0][0]); //By default Zero print karega
		//Output: 0
	
		int arr2[][]= new int[4][];
		System.out.println(arr2);// master array ka address dega
		//Output: [[I@4e25154f
		
		System.out.println(arr2[0]);// master array mai koi 1D array banahi nhi coz humne column ki size di hi nhi so woh null dega.
		// Output: null
		
		//System.out.println(arr2[0][0]); //Null pointer Exception dega coz jab woh master array ke 0th entry pe jayega then waha jo address hai uske 0th index pe jayega but koi index exist hi nhi krta.
	
		for( int i=0; i< arr2.length; i++) {
			System.out.print(arr2[i]);
		}
    
 output: null null null null 
    
 //=========================================================================================================================================================================
 
    int arr2[][]= new int[3][];
		System.out.println(arr2); 
		System.out.println(arr2[2]);
		
		for( int i=0; i< arr2.length; i++) {
			arr2[i]= new int[2];
			System.out.println(arr2[i]);
		}
		
		System.out.println(arr2[0][0]); //ab muje zero milega and not null pointer exception coz mere pas array ready hai
Output:
[[I@15db9742
null
[I@6d06d69c
[I@7852e922
[I@4e25154f
0

	}
}
