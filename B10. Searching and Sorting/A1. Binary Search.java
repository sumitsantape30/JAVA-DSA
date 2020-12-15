Code Binary Search

You have been given a sorted(in ascending order) integer array/list(ARR) of size N and an element X. 
Write a function to search this element in the given input array/list using 'Binary Search'.
Return the index of the element in the input array/list. In case the element is not present in the array/list, then return -1.

Input format :
The first line contains an Integer 'N' which denotes the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.
Third line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow..
All the 't' lines henceforth, will take the value of X to be searched for in the array/list.

Output Format :
For each test case, print the index at which X is present, -1 otherwise.
Output for every test case will be printed in a separate line.

Constraints :
1 <= t <= 10^4
0 <= N <= 10^6
0 <= X <= 10^9

Time Limit: 1 sec

Sample Input 1:
7
1 3 7 9 11 12 45
1
3
Sample Output 1:
1

Sample Input 2:
7
1 2 3 4 5 6 7
2
9
7
Sample Output 2:
-1
6

Code:

package array;

import java.util.Scanner;

public class BinarySearch {

	public static int binarySearch(int arr[], int element) { //function will return the index of the element if it is found otherwise -1
		 
		int start= 0; //start index
		int end= arr.length-1; //last index
		
		// start ka element humesha end se chota hi rahega coz sorted array hai
		while( start <= end) { // hum yeh kam kabtak karre? jab hume humara element mil jaye ya fir element hai hi nhi array mai tab start aur end overlap ho jayenge
			
			// start and end har bar change hora matlab mid bhi change hoga.
			int mid= (start+end)/2;
			
			if( element == arr[mid]) { // jo element search karna hai usko mid index value ke sath compare karre agar dono same rhe to mid index return karenge
				return mid;	
			
			}if( element > arr[mid]) {  //if element that we have to is greater than the element at the mid, then we should move towards right of the mid
					start= mid+1; //right mai jare matlab hume start index update krna padega and end wahi rahega.	
				
			}else if( element < arr[mid]) { // agar element chota hai than element at mid to left ke side jana padega and humara end mid se ek se kam hoga.
					end= mid-1;
				}
			}
		return -1; //agar yeh while loop pura execute hojata hai matlab start aue end ek duse ko cross kar jate hai
	}

	public static void main(String[] args) {

		int arr[]= {1,3,7,9,11,12,15};
		int searchResult= binarySearch(arr, 11);
		System.out.println(searchResult);
	}
}
