Longest subset zero sum

Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format
The first and only line of output contains length of the longest subarray whose sum is zero.

Constraints:
0 <= N <= 10^8
Time Limit: 1 sec

Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 

Code:

import java.util.*;

/*
	- You are given an integer array containing positive and negative numbers.
	- Your task is to find out the length of the longest continuous subset of this array whose elements add upto zero.

*/

public class solution 
{
    public static int lengthOfLongestSubsetWithZeroSum(ArrayList<Integer> arr) 
   	{
        int maxLen = 0;
		int i = 0,sum = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for( int val : arr) {
		
		    sum += val;
		    if( sum == 0 ) {
		       int len = i + 1; 
		       if( maxLen < len ) {
		    	   maxLen = len;
		       }
		    }
		    if( map.containsKey( sum )) {
		    	int len = i - map.get(sum );j
		    	if( maxLen < len ) {
		    		maxLen = len;
		    	}
		    	
		    } else {
		    	
		    	map.put( sum, i );
		    }
			i++;
		}
		return maxLen;
	}
}
