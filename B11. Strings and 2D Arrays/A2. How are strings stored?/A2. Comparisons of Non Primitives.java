package String;

import java.util.Scanner;

public class Comparisons {

	
	public static void main(String[] args) {

		int arr1[]= {1,2,3};
		int arr2[]= {1,2,3};
		
		if( arr1 == arr2) { // iss line mai hum dono arrays ke addresses ko compare karre ( arr1 ke pas address hoga jaha woh array stored hai same with arr2) so, addresses are not going to be the same.
			System.out.println("True");
		}else {
			System.out.println("False");
		}
    
//Output: False
//===========================================================================================================

    int arr1[]= {1,2,3};
		int arr2[]= arr1;
		
		if( arr1 == arr2) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}

//Output: True
		
	}
}
