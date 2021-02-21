Code Bubble Sort

Provided with a random integer array/list(ARR) of size N, you have been required to sort this array using 'Bubble Sort'.

Note:
Change in the input array/list itself. You don't need to return or print the elements.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output format :
For each test case, print the elements of the array/list in sorted order separated by a single space.
Output for every test case will be printed in a separate line.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^3

Time Limit: 1 sec

Sample Input 1:
1
7
2 13 4 1 3 6 28
Sample Output 1:
1 2 3 4 6 13 28

Sample Input 2:
2
5
9 3 6 2 0
4
4 3 2 1
Sample Output 2:
0 2 3 6 9
1 2 3 4

Code:

package array;

public class bubble_sort {

	public static void bubbleSort(int input[]) { //input to the function will be array
		
		// n size keliye n- 1 rounds karna padega but i zero se start hora so length-1 lena padega
		for (int i = 0; i < input.length - 1; i++) { // largest value of 'i' jiske liye yeh loop run krra hoga will be length-2
			
			//har round mai hum adjacent elements compare karre jarurat hai to swap karre ya fir aage move karre
			for (int j = 0; j < input.length - i - 1; j++) { //for n element, n-2 is the last index jiska comparison hua 
				 
				//Bada wala element sabse piche leke jana hota hai
				if (input[j] > input[j + 1]) { // har round mai j and j+1 wale element ko compare karre honge agar yeh condition false hue to j ki value ek se increase hojayegi aur hum next two elements ko compare karre honge
					
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int input[] = { 8, 2, 6, 1, 5 };
		bubbleSort(input);
		for (int i = 0; i < input.length; i++) {
			System.out.print(input[i]+" ");
		}
	}
}

