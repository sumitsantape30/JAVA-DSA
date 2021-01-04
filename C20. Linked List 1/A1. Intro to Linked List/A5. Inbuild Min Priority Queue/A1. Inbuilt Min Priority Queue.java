package InbuildPriorityQueue;

import java.util.PriorityQueue;

public class Inbuilt_Priority_Queue {

	public static void main(String[] args) {
		
       PriorityQueue<Integer> pq= new PriorityQueue<>();
		
		//ek array lete hai and uske elements ko priority queue mai insert krte hai
		int arr[]= {9,1,0,4,7,3};
		
		//pq. (dot) karenge to priority queue ke basic function use kar payenge
		for(int i=0; i< arr.length ; i++) {
			pq.add(arr[i]); //inserting ith element of the array inside the queues 
			
		}
		
		//System.out.println(pq.element()); //or pq.peak() bhi use kr skte hai to get minimum element, Output: 0
		
		while(! pq.isEmpty()) { //kabtak queue khali nhi hota tabtak elements nikalnge
			System.out.print( pq.remove()+" ");
		}
		
	}

}
