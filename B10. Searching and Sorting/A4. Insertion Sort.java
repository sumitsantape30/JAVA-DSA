Code Insertion Sort

Provided with a random integer array/list(ARR) of size N, you have been required to sort this array using 'Insertion Sort'.

 Note:
Change in the input array/list itself. You don't need to return or print the elements.

 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the array/list.
Second line contains 'N' single space separated integers representing the elements in the array/list.

Output Format :
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

public class insertionSort {
	public static void insertionSort(int arr[]) { //input will be array
		
		//I have to divide my array into two parts one is sorted part and other is unsortes part. I'll pick one element from unsorted and insert it in sorted part before that we'll compare.
		// Jo 0th index pe element hai usko sorted consider krte hai and i+1 se saare unsorted.
		for (int i = 1; i < arr.length; i++) { //first element in the usorted part will be at index 1 aur jabtak last element pe nhi pohoch jate tabtak karna hai

			int j = i - 1; //yeh woh sorted part ka element hai, sabse pehle usise comparison hoga i-1 pe hai with element from unsorted part.
			int temp = arr[i]; // yeh woh element hai jisko insert karna hai
			
			while (j >= 0 && arr[j] > temp) { //shifting ka kam karenge jabtak j>= 0 hai and jabtak array ke j pe element pda hai woh bada hai temp(jo element insert karna hai) se tabhi shift karenge
				arr[j + 1] = arr[j]; //shift karne keliye j pe jo element hai usko j+1 pe dal dena chahiye
				j--; // ab j kam ho jayega
			}
			arr[j + 1] = temp; // j kam ho chuka hai to ek position piche agya aye waha insert kar denge
		}

	}

	public static void main(String[] args) {
		int arr[] = { 6, 4, 3, 5, 2 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}

//Working: lets say array is {6,4,3,5,2}
// 6 is in unsorted part and rest of the element are in sorted array.
// so, 4 ko insert karenge hum sorted part mai, is tarah se insert karenge ki finaly jo hume array milra sorted ho.
// so, 4 ko insert karne keliye 4 and 6 ko compare karenge, 4 and 6 ko compare kara to 6 bada hai 4 se, so 4 6 ke pehle ayega. so we will shift 6 by 1 index( pehle 6 oth index pe tha ab 1th index pe dal denge) and 4 ko insert kar denge.
// now sorted part is {4,6} and unsorted part is {3,5,2}
// then again baki element ko pick krenge unsorted mese compare karenge shift karenge and then jo finally array ayega woh sorted ho.
