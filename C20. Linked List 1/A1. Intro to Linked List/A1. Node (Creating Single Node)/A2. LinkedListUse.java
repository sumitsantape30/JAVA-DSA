package LinkedList;

public class LinkedListUse {
	
	public static void main(String[] args) {

		//linkedlist ka ek node create karna matlab uss Node class ka ek object create karna, Node class is template ki LinkedList ke nodes kaise dikhne chahiye 
		Node<Integer> node1= new Node<Integer>(10); //mera ek node ban gya jiska data 10 hai
		
		//node 1 ka data access karne keliye
		System.out.println(node1.data);
	    
		//node 1 ka next access karne keliye
		System.out.println(node1.next);
   
   }
}

Output:
10
null
