Pairs with difference K

You are given with an array of integers and an integer K. You have to find and print the count of all such pairs which have difference K.
Note: Take absolute difference between the elements of the array.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol n.
The following line contains n space separated integers, that denote the value of the elements of the array.
The following line contains an integer, that denotes the value of K.
Output format :
The first and only line of output contains count of all such pairs which have an absolute difference of K. 

Constraints :
0 <= n <= 10^4
Time Limit: 1 sec

Sample Input 1 :
4 
5 1 2 4
3
Sample Output 1 :
2

Sample Input 2 :
4
4 4 4 4 
0
Sample Output 2 :
6

Code:

import java.util.ArrayList;
import java.util.HashMap;
public class Solution {
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		
          HashMap<Integer, Boolean> map = new HashMap<>();			
          ArrayList<Integer> result = new ArrayList<>();
          for( int val : arr ) {
        	  map.put( val, true );
          }
          
          for( int val : arr ) {
        	  if( map.containsKey( val - 1 )) {
        		  
        		  map.put( val, false );
        	  }
          }
          
        int start = 0, maxLen = Integer.MIN_VALUE;  
		for (int val : arr) {

			if (map.get(val) == true) {

				
				int len = 1;

				while (map.containsKey(val + len)) {

					len++;
				}
				
				if( maxLen < len ) {
					maxLen = len;
					start = val;
				}
			}
		}
         
		for( int i = 0; i < maxLen; i++ ) {
			
			result.add( start + i);
		}
         
		return result;
	}
}
