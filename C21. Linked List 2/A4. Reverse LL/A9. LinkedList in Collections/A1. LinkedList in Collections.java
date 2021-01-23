package Collection_LinkedList;

//the already implementation of linkedlist is in the form of linkedlist class
//linkedList nam se class hai already java collections framework mai, aur agar muje linkedlist banani hai uss linkedlist from collection framework ka use krke to muje uss class ka ek object create karna hoga
import java.util.LinkedList; 

public class CollectionsLinkedList {

	public static void main(String[] args) {

		//agar muje linkedlist mai integers store karne hai to <Integer>
		//and this implementation of linkedlist is doubly linkedlist (connection to next and previous both is there)
		// yeh linkedlist class ka object hai so isme node ko uske next mai link karna is not important
		LinkedList<Integer> list = new LinkedList<>();// jo linkedlist class already hai uska object banaya hai humne
		
		// jo bhi element .add function se add kr rhe hai woh list ke end mai add hote jayenge.
		list.add(10);//  list mai elements add karne keliye (add function matlab woh node create kr rha hai)
		list.add(30);
		
		// .addFirst function se list ke beginning mai add hoga elements
		list.addFirst(10);
		list.addFirst(30);
		
		//jaise .addFirst hai waisehi .addLast bhi hai but .add function bhi same hi kam krta hai
		
		//koi index ki value replace karna hai
		list.set(2,40);
		
		System.out.println(list.size()); //kitne elements hai list ke andar
		
		System.out.println();
		
		//agae muje list mai iterate/traverse karna hai and print karna hai list ke
		for(int i=0;i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

}
