Code Merge Two Sorted Arrays

You have been given two sorted arrays/lists(ARR1 and ARR2) of size N and M respectively, merge them into a third array/list such that the third array is also sorted.

Input Format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First line of each test case or query contains an integer 'N' representing the size of the first array/list.
Second line contains 'N' single space separated integers representing the elements of the first array/list.
Third line contains an integer 'M' representing the size of the second array/list.
Fourth line contains 'M' single space separated integers representing the elements of the second array/list.

Output Format :
For each test case, print the sorted array/list(of size N + M) in a single row, separated by a single space.
Output for every test case will be printed in a separate line.

Constraints :
1 <= t <= 10^2
0 <= N <= 10^5
0 <= M <= 10^5
Time Limit: 1 sec 

Sample Input 1 :
1
5
1 3 4 7 11
4
2 4 6 13
Sample Output 1 :
1 2 3 4 4 6 7 11 13 

Sample Input 2 :
2
3
10 100 500
7
4 7 9 25 30 300 450
4
7 45 89 90
0

Sample Output 2 :
4 7 9 10 25 30 100 300 450 500
7 45 89 90

Code:

package array;

public class mergingSorted_Array {
	public static int[] merge(int arr1[], int arr2[]) { //input should be the arrays that we plan to merge. And return type should be the in which we are merging them.
		
		int i=0;//index of first array
		int j=0; // index of second array
		int k=0; //to keep the track ki muje third array mai kis index pe insrt karna hai
		
		int ans[]= new int[arr1.length+arr2.length];// third array, it's size will be sum of size of both the arrays.
		
		while( i< arr1.length && j< arr2.length) { //i and j valid hai tabtak compare karna hai
			
			if(arr1[i]<arr2[j]) { // arr1 ke ith index pe jo element rakha hai if that is smaller than arr2 ke jth index pe jo element rakha hai.
				ans[k]= arr1[i];// jo small hoga usko third array mai dal dena chahiye
				k++; //third array kabhi index aage badhana chahiye
				i++; // element insert karne ke bad first array ka index badhana chahiye.
			}else {
				// else mai kab ayenge? ya to arr1 wala element bada hai ya fir dono equal hai, dono cases mai yaha ayenge
				ans[k]=arr2[j];// so arr2 ka element insert kardenge
				k++; //third array kabhi index aage badhana chahiye
				j++; // insert karne ke bad arr2 ka index badhana chahiye.
			}
		} 
		
		//is loop ke bahar aye matlab dono mese ek array pura scan ho chuka hai aur dusre array ke element bache hai
		
		while(i< arr1.length) { // agar second array pura scan ho chuka hai to first array ke saare elements put kar denge as it is coz woh sorted hai
			ans[k]= arr1[i];
			k++;
			i++;
		}
		
		while(j< arr2.length) {
			ans[k]=arr2[j];
			k++;
			j++;
		}
		return ans;// finally returning third ans array
	}

	public static void main(String[] args) {
		int arr1[]= {1,3,5,7};
		int arr2[]= {2,4,6};
		int ans[]= merge(arr1,arr2);
		for(int i=0;i<ans.length;i++) { //printing third array
			System.out.print(ans[i]+" ");
		}
		System.out.println();

	}

}

//Working: Supoose two arrays that are to be merged are {1,3,5,7} and {2,4,6} and we have final merged array of size 4+3= 7
// the 0th element in the third array will be the smallest element out of the two element so i'll compare 0th element of both first and second array.so we'll compare 1 and 2 after comparing 1 and 2
// we realised that 1 is small so put it at 0th index of the third array(k is to keep the track ki muje third array mai kis index pe insrt karna hai) now increse i of first array by one which is 3 and compare 2 and 3

