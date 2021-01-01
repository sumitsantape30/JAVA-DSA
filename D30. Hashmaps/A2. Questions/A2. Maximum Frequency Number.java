Maximum Frequency Number

You are given an array of integers that contain numbers in random order. Write a program to find and return the number which occurs the maximum times in the given input.
If two or more elements contend for the maximum frequency, return the element which occurs in the array first.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains most frequent element in the given array.

Constraints:
0 <= N <= 10^8
Time Limit: 1 sec

Sample Input 1 :
13
2 12 2 11 12 2 1 2 2 11 12 2 6 
Sample Output 1 :
2

Sample Input 2 :
3
1 4 5
Sample Output 2 :
1

Code:

import java.util.HashMap;

public class Solution {

	public static int maxFrequencyNumber(int[] arr){
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		
        HashMap<Integer, Integer> output = new HashMap<>();
		
		int max = 0;
		for( int i : arr ) {
			
			if( output.containsKey( i )) {
				
				output.put( i, output.get(i) + 1 );
			
			} else {
				
				output.put( i, 1);
			}
			
		}
        
		int res = Integer.MIN_VALUE;
		for( int i : arr ) {
			
			if( output.get(i) > max ) {
				max = output.get(i);
				res = i;
			}
		}
		return res;
	}
}
