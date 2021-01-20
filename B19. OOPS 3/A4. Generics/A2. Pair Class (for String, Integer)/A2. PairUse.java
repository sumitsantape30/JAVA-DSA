package Generics;

public class PairUse {

	public static void main(String[] args) {
    
        //since humare pair mai 2 type ka data store hone wala hai to muje two type ka data input dena padega.
		
		//agar same type ke rakhne hai
		Pair<String, String> p=  new Pair<String, String>("ab","cd");
		
		
		//muje first Integer Chahiye and Second String chahiye.
		Pair<Integer, String> p1= new Pair<Integer, String>(10, "abc");
		
		p1.getFirst(); //p1 ka first Integer return karega.
		p1.getSecond(); //p2 ka second String return karte hai
		
		//Character,Character ka pair banana hai
		Pair<Character, Character> p2= new Pair<>('a','b');
		
		// I want to create a pair jiske andar jo pehli chiz hai woh and uske andar ek aur pair hai that is pair of Integer,Integer 
		//agar muje teen chize sath rakhne hai, and isi pair class ko use krke rakhne hai -- mai pair class ka object banaunga jiski pehli chiz ek aur pair hai and dusri chiz Integer hai, so effectively uske andar 3 integers aagye, First ke andar ek pair hai jiske andar do Integers hai, Second ke andar ek Integer hai
	    
		int a= 10;
		int b= 12;
		int c= 23;
		
		Pair<Integer, Integer> internalPair= new Pair<>(a,b); //mai internalPair as a first argument and c as second argument de skta hu
		Pair<Pair<Integer,Integer>, Integer> p3= new Pair<>(internalPair, c); //iss constructor ko do argument chahiye pehle argument mai ek pair chahiye and dusre argument mai ek integer chahiye
	    
		//printing 3rd integer
                System.out.println(p3.getSecond()); //Output: 23 (3rd Integer)
        
                //agar first integer chahiye
                System.out.println(p3.getFirst().getFirst()); //sirg getFirst() karne se pehle pair aa jayega.
                //Output: 10
        
                //agar second element chahiye.
                System.out.println(p3.getFirst().getSecond()); //Output: 12
	}

}
