package InbuildPriorityQueue;

import java.util.PriorityQueue;

public class SortKSorted {

public static void sortKSorted(int arr[], int k) { //input will be an array and K
		
	   //hume humara kam karnekeliye ek priority queue chhiye
		PriorityQueue<Integer> pq= new PriorityQueue<>();
		
		//pehle K elements mese hi koi minimum 0th position pe aane wala hai
		int i=0;
		for( ; i< k; i++) { // First K elements ko uthake priority Queue mai dalenge
			pq.add(arr[i]); 
		}
		
		//K elements dal diye to un mese ek remove karenge woh i-k th position pe jana chahiye aur ek element add krdenge kyuki next time isko bhi consider karke firse minimum nikal rhe honge hum
		// yahatk mera i 3 ban chuka hoga as i loop ke bahar hai
	        for( ; i< arr.length ;i++) {
		    arr[i - k]= pq.remove(); // Jo element remove(minimum wale) hora woh array ke oth pe jayega
		//priority queue mese ek remove karne ke bad muje K+1 pe jo pda usko add krna padega means arr[i] pe add karna padega coz i update hoke aya h
		   pq.add(arr[i]);
		}
		
		//end mai jo k elements reh gye hai heap mai, jo remove nhi huye hai unko ek ek karke bas hum remove krte ja rhe hai
		for(int j= arr.length-k ; j< arr.length  ; j++) { //jitne pehle 'k' elements add hogye hai, mai uss 'k' ke just next se remove karunga means arr.length mese minus 'k' karenge.
			arr[j]= pq.remove();
			
		}
	}

	public static void main(String[] args) {

		int arr[]= {2,4,1,9,6,8};
		int k=3;
		sortKSorted(arr, k);
		
		for(int i=0; i< arr.length; i++) {
			System.out.println(arr[i]+" "); 
		}
		
	}

}

//hum har point pe k elements ko heap mai rakh rhe aur unka minimum nikal rhe hai. Suppose k=3 hai, 0th position keliye element fir 3(k) elements mai se hi ho skta hai. To inn teeno ke heap mai daldo, jo minimum hai woh nikal lo. Fir nikla heap se to ek aur add karo. Fir next 3 mese dhundo 

Output:
1 
2 
4 
6 
8 
9 
