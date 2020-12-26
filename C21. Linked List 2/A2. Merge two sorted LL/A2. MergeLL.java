package Restart;

import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> input() {

		Node<Integer> head = null, tail = null;

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();

		while (data != -1) {

			Node<Integer> newNode = new Node<Integer>(data);
			if( head == null) {
				head= newNode;
				tail= newNode;
			}else {
				tail.next= newNode;
				tail= tail.next;
			}
			data= s.nextInt();
		}
		return head;
	}
	
	public static Node<Integer> mergeSortedLL( Node<Integer> head1, Node<Integer> head2){
		
		if( head1 == null) { //agar head1 means first list null hai to head2 return kar denge means second list return kar denge.
			return head2;
		}
		
		if( head2 == null) { //agar head2 means second list null hai to head1 return kar denge means first list return kar denge.
			return head1;
		}
		
		
		Node<Integer> temp1= head1, temp2= head2;
		Node<Integer> head3= null, tail3= null;
		
		
		if( temp1.data < temp2.data) {
			head3= temp1;
			tail3= temp1;
			temp1= temp1.next;
		}else {
			head3= temp2;
			tail3= temp2;
			temp2= temp2.next;
		} //iss loop ke bad meri final list mai first entry aagyi jisko humne head liya and ek hi element hai to usiko tail liya
		
		while( temp1 != null && temp2 != null) { //tabtak travel karenge jabtak dono mese ek list null nh ho jati
			
			if(temp1.data <= temp2.data){
				tail3.next= temp1;
				tail3= tail3.next;
				temp1= temp1.next;
			}else {
				tail3.next= temp2;
				tail3= tail3.next;
				temp2= temp2.next;
			}
		}
		//yaha tak aye means dono list mese koi ek null hogya, means list khatam hogyi so ab dusre list ke remaining element ko final ke tail mai link kar denge.
		if( temp1 != null) { //temp1 null hai means mera temp2 null hogya so temp1 ko final list aisehi link krdere
			tail3.next= temp1;
		}else {
			tail3.next= temp2;
		}
		return head3; //end mai final list ka head return karenge
	}
	
	public static void print(Node<Integer> head3) {
		
		while( head3 != null) {
			System.out.println(head3.data+" ");
			head3= head3.next;
		}
	}

	public static void main(String[] args) {

		Node<Integer> head1= input();
		Node<Integer> head2= input();
		Node<Integer> head3= mergeSortedLL(head1, head2);
		print(head3);
	}

}
