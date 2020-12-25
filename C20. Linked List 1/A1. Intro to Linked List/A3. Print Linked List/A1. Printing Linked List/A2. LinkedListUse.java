package Restart;

public class LinkedListUse {

	public static void main(String[] args) {

		//in teen statements se memory mai 3 nodes banenge and three variables referring to those three node.
		Node<Integer> node1= new Node<>(10);
        Node<Integer> node2= new Node<>(20);
        Node<Integer> node3= new Node<>(30);
        node1.next= node2;
        node2.next= node3; //"node3" ke pas third wale node ka address hai isliye hum us address ko node2 ke next mai dal rhe hai
	
        //humara head obviously first node hoga, so head store karne ke liye ek refernce banate hai
        //Node<Integer head; == maine bas itna likha means it's a reference, abhi kisiko ko refer/point nhi kr rha, abhi puri tarah se khali hai
        Node<Integer> head= node1; //iska matalb head ke andar ab node1 jise refer kr rha tha uska reference hai, to ab head and node1 same hi node ko refer kr rhe hai, so head is just a reference to the first node
        
        //Printing Linked List
       //muje data bar bar print karna hai jabtak meri linkedlist khatam nhi hoti so will use while loop
        //last wale node ke next mai null hai means list khatam ho chuki hai so jabtak head null nhi hota tabtak travel karenge.
        while( head != null) {
        	System.out.print(head.data+" ");
        	head= head.next;  //ek node ka data print karane ke bad muje had ko next node pe move karana hoga. starting mai head first node ko refer rha hai so uske pas first node ka address hoga, but next node print krne keliye head ko next node ko refer karna chahiye.
        } 
        //head ek node ko point kr rha hai, us node ka data print karega, aage badh jao, head ko ek ek krke aage move kr rhe hai
	    //Arrays mai ek step age badhne keliye i++ krte the yaha head= head.next krke le rhe honge.
	}

}
