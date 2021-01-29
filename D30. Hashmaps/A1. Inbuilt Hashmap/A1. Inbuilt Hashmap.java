import java.util.HashMap;
import java.util.Set;

public class MapsUse {

	//Hashmap import karna padega and 
	public static void main(String[] args) {

		//HashMap is generic on two things, key kaisi hogi and value kaisi hogi yeh hume dono chize btani hongi
	         HashMap< String, Integer > map= new HashMap<>();//maine apna Map bana liya ab mai usme chize insert kr skta hu, access kr skta hu delete kr skta hu
		
		//Maps mai sara kam key pe karna hota hai value pe nhi krna hota.
		
		//insert data into the map
        map.put("abc", 1); //kis key ke corresponding kya value dalni hai hum yeh put kr skte hai so maine "abc" ke corresponding 1 value dal di
        map.put("def", 2); //humne "def" ke corresponding 2 dal diya
        //So in this way we can insert data into our hashmap and it's taking O(1)
        
        
        // size (number of keys in the map, agar same key ke corresponding other value hai tabhi woh key ek hi bar count hogi, actually we update data inside map when we're putting diffrent value to the same key)
        System.out.println("size: "+ map.size());
        
        //To check whether our map contains that key or not (check Presence)
        if( map.containsKey("abc")) {
        	System.out.println("Has abc");
        }
        
        if( map.containsKey("abc1")) { //humare map mai "abc1" nhi hai 
        	System.out.println("Has abc1");
        }
		
        //To get value corresponding to a key, value integer rahegi humare key ki so int v mai store kr rhe hai
//        int v = map.get("abc1");  // mere map ke andar "abc1" nhi hai maine bola "abc1" le aao aur usko laake integer mai dal do
//        System.out.println(v); // agar abc1 nhi hai to Null pointer Exception
        // .get() : get ki documentation kehti hai, it says agar key nhi hai to yeh null return karta hai
        
        int v=0;
        if (map.containsKey("abc1")) { //so muje pta hai ki maps ke andar hai to null nhi ayega isliye v ke andar dal diya
        	v= map.get("abc1"); // get= it returns value corresponding to key or return null if no such key is present
        }
        System.out.println(v); //agar woh key map mai nhi hai to woh V ki original value means zero lake daga
        
        // To remove the value
        int s= map.remove("abc");// we have to pass the key 
        System.out.println(s); // will print the value which is just deleted
        
        
        // To check if the value is present or not, this is expensive function that takes T.C= O(n). Key ke upar sare operations fast honge than on value
        if(map.containsValue(2)) {
        	System.out.println("has 2 as value");
        }
        
        
        //To iterate over the map for keys, muje mere map ek ek karke har ek chiz pe jana hai
      // you can access all the keys using keySet() but it returns all the keys in a data type called set
        Set<String> keys= map.keySet(); //humare pas saari keys aagyi keys variable mai jiska datatype Set hai
       //now we have all the keys, and now if you want to iterate over these keys we'll use faster iteration
        for( String str: keys) { //read: for every String str in keys
        	System.out.println(str);
        }
        //yeh loop se bhi fast hai
          
	}

}
