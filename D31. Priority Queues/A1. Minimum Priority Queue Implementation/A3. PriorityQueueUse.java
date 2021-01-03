
public class PriorityQueueUse {

	public static void main(String[] args) throws PriorityQueueException {


		Priority_Queue pq= new Priority_Queue(); // Priority_Queue class ka object bana rhe hai
		
		//ek array banate hai and usko Queue mai insert krte hai
		int arr[] = {5,1,9,2,0};
		
		//ek ek krke iss array ke sare elements ko priority queue mai insert krte hai
		for(int i=0; i< arr.length; i++) {
			pq.insert(arr[i]); // array ke ith element insert karre Priority_Queue mai
		}
		
		//iske bad sabko pop krte hai, jabtak puri Queue(pq) khali nhi hojati tabtak pop karne ka kam karenge
		while(! pq.isEmpty()) {
			System.out.println( pq.removeMin()+" ");
		}
		System.out.println();
	}

}

Output:
	0  //array mese sabse pehle less priority wala element delete hoga
	1 
	2 
	5 
	9 

