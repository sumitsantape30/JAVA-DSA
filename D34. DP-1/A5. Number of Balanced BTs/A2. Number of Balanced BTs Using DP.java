Code: Number of Balanced BTs Using DP

Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so, return output modulus 10^9 + 7.
Time complexity should be O(h).

Input Format :
The first and only line of input contains an integer, that denotes the value of h. Here, h is the height of the tree.
Output Format :
The first and only line of output contains the count of balanced binary trees modulus 10^9 + 7.

Constraints :
1 <= h <= 10^6
Time Limit: 1 sec

Sample Input 1:
3
Sample Output 1:
15

Sample Input 2:
4
Sample Output 2:
315

Code:


public class Solution {

	public static int balancedBTs(int height){

		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
        */
         int mod = (int) Math.pow(10, 9) +7;
	       
	       int storage[] = new int[ height + 1];
	       
	       storage[0] = 1;
	       storage[1] = 1;
	       
	       for( int i = 2; i <= height; i++ ) {
	    	  
	    	  long leftSubHeight = storage[ i - 1 ];
	 		  long rightSubHeight = storage[ i - 2 ];
	 		 
	 		  long res1 = (leftSubHeight * leftSubHeight) % mod;
	 		  long res2 = (2 * leftSubHeight * rightSubHeight) % mod;
	 		  
	 		  storage[i] = (int)( res1 + res2 ) % mod;
	       }
	       
	       return storage[height];
	}
    
    
}
