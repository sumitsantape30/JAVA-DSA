Pair Sum to 0

Given a random integer array A of size N. Find and print the count of pair of elements in the array which sum up to 0.

Note: Array A can contain duplicate elements as well.

Input format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output format :
The first and only line of output contains the count of pair of elements in the array which sum up to 0. 

Constraints :
0 <= N <= 10^4
Time Limit: 1 sec

Sample Input 1:
5
2 1 -2 2 3
Sample Output 1:
2

Code:

import java.util.*;

public class Solution {
	public static void PairSum(int[] input, int size) {
		
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Print the desired output and don't return anything.
	 	 * Taking input is handled automatically.
		 */
	      HashMap<Integer, Integer> map = new HashMap<>();
       
		for( int i : input ) {
			
			if (map.containsKey(-i)) {
				
				for (int j = 1; j <= map.get(-i); j++) {
				
					if (i >= 0) {

						System.out.println(-i + " " + i);

					} else {

						System.out.println(i + " " + -i);

					}
				}
			}
			if( map.containsKey( i )) {
				
				map.put( i , map.get( i ) + 1);
			
			} else {
				
				map.put( i, 1 );
			}
		}
    
    }
}
