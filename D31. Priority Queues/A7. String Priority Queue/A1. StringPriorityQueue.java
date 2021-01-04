package InbuildMaxPriorityQueue;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;


//ek comparator class banayenge jo string ko unke length ki basis pe compare karega, it implements comparator for strings
class StringLengthComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {

		//agar pehle wale String ki length dusri wali string ke length se choti hai then i'll return -1
		if( o1.length() < o2.length() ) {
			return -1;
		} else if( o1.length() > o2.length()) {
			return 1;
		}else {
			return 0;
		}
	}
	
}

public class StringPriorityQeueu {

	public static void main(String[] args) {

		//we'll create a string array jisme strings hai
		String arr[]= { "this", "at", "a", "their", "qeueu"};
		
		StringLengthComparator stringComparator= new StringLengthComparator();
		
		//Now i'll create a priority Queue for String
		PriorityQueue<String> pq= new PriorityQueue<>(stringComparator); //yeh priority Queue String pe work karegi
		
		for(int i=0; i< arr.length; i++) {
			pq.add(arr[i]); // array ke ith element insert karre Priority_Queue mai
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.remove() + " ");
		}
		
		//String ko compare karne keliye muje string ke length ki basis pe compare karna hoga. Agar muje length ki basis pe comparison karna hai to muje ek comparator banana hoga jo strings ko unke length ki basis pe solve kare 
	}

}
