package InbuildMaxPriorityQueue;

import java.util.Collections;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

//Comparator ek interface hai so we have have to create an interface and create a class jo iss interface ko implment kr rhi hogi.

//Max priority keliye comparator bana rhe hum, and it implements comparator interface
class MinPQComparator implements Comparator<Integer>{ //humne yeh min comparator banaya
	
	//comparator ke andar niche wala ek simple sa compare to method hota hai, yeh compre to method decide krta hai ki hum do elements ko kaise compare karne wale hai
	@Override
	public int compare(Integer o1, Integer o2) { //yeh compare to method ka result generally kuch -ve number, 0 , or +ve number hota hai. If they are equal we'll return  a 0, and -ve and +ve kab return karna hai yeh hum decide karre hote hai humare usecase ke according
		
		//existing comparator jo priority queue use kr rhi hai it works something like this
		if(o1 < o2) {
			return -1;
		} else if(o1 > 02) {
			return 1;
		}
		//agar woh equal hai to return zero
		return 0;
	}
//do objects aaye, dono objects ko compare kara, agar pehle wala chota hai to -1 return kar rhe aur agar pehle wala hi bada hai to +1 return karre otherwise zero return karre
//humne simple sa interface implement kar hai humne yeh decide karne keliye ki jo do objects humare hathmne hai un dono objects ko compare kaise karna hai
}

class MaxPQComparator implements Comparator<Integer>{ //agar mai chahta hu ki mera comaprator Max Priority Queue ki tarah kam kare
	
	@Override
	public int compare(Integer o1, Integer o2) {
		
		if(o1 < o2) {
			return 1;
		} else if(o1 > 02) {
			return -1;
		}
		return 0;
	}
	
}


public class MaxPriorityQueueUse {

	public static void main(String[] args) {

		//khudka comparator banayenge means upar wale classes ka object banayenge
		
		//MinPQComparator minComparator= new MinPQComparator(); //For Asscending Order, Output: 0 1 2 5 9
		
		MaxPQComparator maxComarator= new MaxPQComparator();// for Descending Order, Output: 9 5 2 1 0 
		
		//yeh max comparator already exist bhi karta hai agar hum nhi banaye khudka, to collection ek class hai uske andar reverseOrder() function hai jo hume Max comparator jaisa ek comparator lake deta hai
		//PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder()); yeh bhi hume maxComparator jaisahi result lake deta hai
		
		PriorityQueue<Integer> pq= new PriorityQueue<>(maxComarator);// yaha hum comparator pass karenge jiske basis pe hum chahte hai ki priority queue ki ordering kaisi ho
		
		//ek array lete hai and uske elements ko priority queue mai insert krte hai
		int arr[] = {5,1,9,2,0};
		
		for(int i=0; i< arr.length; i++) {
			pq.add(arr[i]); // array ke ith element insert karre Priority_Queue mai
		}

		while (!pq.isEmpty()) {
			System.out.print(pq.remove() + " ");
		}

	}
}

