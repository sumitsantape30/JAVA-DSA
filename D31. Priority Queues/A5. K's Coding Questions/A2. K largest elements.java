Code : K largest elements

You are given with an integer k and an array of integers that contain numbers in random order. Write a program to find k largest numbers from given array. You need to save them in an array and return it.
Time complexity should be O(nlogk) and space complexity should be not more than O(k).
Order of elements in the output is not important.

Input Format :
Line 1 : Size of array (n)
Line 2 : Array elements (separated by space)
Line 3 : Integer k
Output Format :
k largest elements

Sample Input :
13
2 12 9 16 10 5 3 20 25 11 1 8 6 
4
Sample Output :
12
16
20
25

Code:

package InbuildPriorityQueue;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class KLargestElement {
	
	public static void KLargest(int arr[], int k){
		
		//Out of all theavailable options minimum element konsa hai aur fir use muje remove karna hai so yeh kam karne keliye hum queue ka ser krenge
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		//First 'k' elements ko uthake qeue mai insert kar denge
		int i = 0;
		for (; i < k; i++) {
			pq.add(arr[i]);
		}
		
		// humne'K' elements apne pas rakh liye ki yeh K largest elements hai 
		for (; i < arr.length; i++) {
			int min= pq.element(); //yeh hume queueu mese minimum element lake de dega
			
			if (min < arr[i]) { //I'll check if this minimum element is small than current element is the array
				//agar aisa hua to queue mese minimum element ko delelte kar dena chahiye
				pq.remove(); 
				pq.add(arr[i]); //aur currentl element ko qeueu mai dal dena chahiye
			}
		}
		
		//jab yeh hojayega ab finally mere queue mai K largest elements hi pde honge bas

		//jabtak queue khali nhi hoti tabtak elements nikalte jayenge priotiy queue se aur unhe ek line mai print kara dete hai
		while (!pq.isEmpty()) {
			System.out.println( pq.remove());
		}

	}

	public static void main(String[] args) {

		int arr[]= {2, 15, 8, 9, 12, 13, 20};
		KLargest(arr, 3);
		
	}

}
