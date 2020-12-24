package ArrayList;

import java.util.ArrayList;

public class for_each_loop {

	public static void main(String[] args) {

		ArrayList<Integer> list1 = new ArrayList<>();
		list1.add(15);
		list1.add(20);
		list1.add(50);
		list1.add(2, 25);

		//agar list1 pe traverse karna hai to index 0 se start kr rhe ek ek krke
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();

		//for each loop indexes pe nhi list ke actual elements/values pe step by step jata hai
		for (int elem : list1) { //read: for each elem in list1
			System.out.print(elem + " ");
		}
		
		
		//Agar list mai edit karna hai, koi changes list mai karne hai to us case mai for each loop ka use mat karna
		for( int elem : list1) {
			System.out.print(elem+" ");
			elem= 100; //kya aise karne se pure ke pure ki entry 100 hojayegi? nhi isme koi changes karoge to original list mai koi change nhi hoge, so list mai changes karne keliye hume for loop use nhi krte, hum bas pure list pe iterate/traverse krne keliye for each loop use krte hai
		}
		

		//ArraList is generic so agar muje ArrayList String ki banani hai to String ki bhi bana skte hai
		ArrayList<String> list2= new ArrayList<>();
		//similary you can create list of students or any non premitive, generic hai to sirf non premitives hi likh skte hai <> iss bracket mai
			
	}

}
