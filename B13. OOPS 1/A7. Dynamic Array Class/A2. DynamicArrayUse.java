package classesAndobjects;

public class DynamicArrayuse {

	public static void main(String[] args) {
		
		DynamicArray d=new DynamicArray(); //humne dynamic array ka object banaya, which does not take any size input from us.
		
		// uske andar mai boht saare elements dal rha hu, and maine koi size nhi bataya 
		for(int i=0;i<100;i++) { //humne size nhi bataye directly 100 elements dalre, dynamic array will handle it.
		//humne add function banaya, shuru mai mera dynamic array empty hai, so pehli bar element dalega to 0th index pe dalega fir 1th then 2th index pe basically pichese dalta jayega.
			d.add(i+10); //(hum dyanmic array ke end/piche mai elements dal rhe h) mai dynamic array mai sabse pehle 10 dalra then i increase hone ke bad 11..
		}
		
		System.out.println(d.size());//we are printing humne kitne elements dynamic array mai dal diye.
		
		d.set(4,10);//koi particular index pe value replace/set karne keliye
		
		System.out.println(d.get(3)); //we are saying, hey dynamic array get me the value at index 3
        System.out.println(d.get(4)); 
        
        while(!d.isEmpty()) { //jabtak dynamic array khali nhi hota last ko remove karo and size print krte raho
        	System.out.println(d.removeLast()); //last element hatane/remove karne keliye.
        	System.out.println("size= " + d.size()); //
        	
        }
	}

}

