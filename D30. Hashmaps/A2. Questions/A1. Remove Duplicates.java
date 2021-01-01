import java.util.ArrayList;
import java.util.HashMap;

public class RemoveDuplicates {

	            //Integers ki array list return karna hai so wahi return type
	public static ArrayList<Integer> removeDuplicates(int a[]){ //hume input mai ek array milega
		
		//hume output mai arraylist of integers dena hai so ek array list banayenge
		ArrayList<Integer> output= new ArrayList<>();
		
		HashMap<Integer, Boolean> seen= new HashMap<>(); //this map is going to store what all we have seen.

		//ab hum ek ek karke apne array pe iterate karenge
		for(int i=0; i< a.length; i++) {
			
			if( seen.containsKey(a[i])) { //yeh jo a[i] hai yeh meri key hai. we're checking if my seen map already contains this key. If it does I'm going to skip this coz yeh aa chuka hai already map mai
				continue;
			}
	       //agar map mai already nhi hai to use map mai dalkar, I'll mark it True ki I have seen it now next time muje isko dubara nhi dekhna hai and sath mai hi arraylist mai bhi dalenge		
			output.add(a[i]);
			seen.put(a[i], true);	
		}
		
	    //now all my data will be in my arraylist and we'll return it
		return output;
	}
	
	public static void main(String[] args) {

		int a[]= {1,3,2,4,1,2,2,2,1000,3,2}; //yeh size pe nhi bas total number of numbers/elements kitne hai
		ArrayList<Integer> output= removeDuplicates(a);
		for(int i=0; i< output.size(); i++) {
			System.out.println(output.get(i));
		}
	}
}

Output:
1
3
2
4
1000
