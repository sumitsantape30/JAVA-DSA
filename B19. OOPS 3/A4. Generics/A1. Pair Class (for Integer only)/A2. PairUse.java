package Generics;

public class PairUse {

	public static void main(String[] args) {
    
		//Pair banate waqt hume batana chahiye hum kis type ka data class mai dalna hai, and jo nya pair hoga woh bhi string type ka hoga.
		Pair<String> p=  new Pair<String>("ab","cd");// humne ek pair banaya hai, string type ka 
		p.setFirst("def"); //p.setFirst ab by default String hi input lega.
		
		//p.getFirst() bhi ab by default String hi return karega so I can put it inside a string
		String s= p.getFirst();
		
		//when you are creating a Pair, you can create a Pair of whatever type you want to create it of
        
		//primitive datatype ko hum generic mai nhi de skte but har primitive datatype ke corresponding ek superficial class bani hui hai
		//Pair<int> p1= new Pair<integer>(2,3); -- yeh nhi chalga, tum int type ka pair nhi bana skte coz it's primitive datatype, it's not object, hum sirf object ke sub classes ka bana skte hai
		Pair<Integer> p1= new Pair<Integer>(1,2); //Integer creates an object
		
		//Character type ka pair
		Pair<Character> c1= new Pair<>('a', 'b'); //second bracket<> ke andar maine Character nhi likha, jaisehi left side mai Character dikhega woh apne aap assume karlega right mai Character
	}

}
