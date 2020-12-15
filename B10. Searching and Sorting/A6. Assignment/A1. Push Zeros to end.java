Push Zeros to end

You have been given a random integer array/list(ARR) of size N. You have been required to push all 
the zeros that are present in the array/list to the end of it. Also, make sure to maintain the relative order of the non-zero elements.

Note:
Change in the input array/list itself. You don't need to return or print the elements.
You need to do this in one scan of array only. Don't use extra space.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output Format :
For each test case, print the elements of the array/list in the desired order separated by a single space.
Output for every test case will be printed in a separate line.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^5

Time Limit: 1 sec

Sample Input 1:
1
7
2 0 0 1 3 0 0
Sample Output 1:
2 1 3 0 0 0 0

 Explanation for the Sample Input 1 :
All the zeros have been pushed towards the end of the array/list. Another important fact is that the order 
of the non-zero elements have been maintained as they appear in the input array/list.

Sample Input 2:
2
5
0 3 0 2 0
4
9 0 0 8 2
Sample Output 2:
3 2 0 0 0
9 8 2 0 0 

Code:

import java.util.*;
public class Solution {  

    public static int[] merge(int arr1[], int arr2[]) {
    	int arr3[] = new int[arr1.length + arr2.length];
		int k = 0;
		int i = 0;
		int j = 0;
		while(i < arr1.length && j < arr2.length)
		{
			if(arr1[i] < arr2[j])
			{
				arr3[k] = arr1[i];
				i++;
				k++;
			} else {
				arr3[k] = arr2[j];
				j++;
				k++;
			}
		}
		while(i < arr1.length)
		{
			arr3[k] = arr1[i];
			i++;
			k++;
		}
		while(j < arr2.length)
		{
			arr3[k] = arr2[j];
			j++;
			k++;
		}
		return arr3;
		
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
	      int t = s.nextInt();
	      while(t != 0)
	      {
	    	  int n = s.nextInt();
	    	  int arr1[] = new int[n];
	    	  for(int i = 0; i < n; i++)
	    	  {
	    		  arr1[i] = s.nextInt();
	    	  }
	    	  int m = s.nextInt();
	    	  int arr2[] = new int[n];
	    	  for(int i = 0; i < m; i++)
	    	  {
	    		  arr2[i] = s.nextInt();
	    	  }
	    	  int ans[] = merge(arr1, arr2);
	    	  for(int i = 0; i < ans.length; i++)
	    	  {
	    		  System.out.print(ans[i]+" ");
	    	  }
	    	  t--;
	      }
			s.close();
    }

}
