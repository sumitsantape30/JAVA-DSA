package ReverseLL_Recursive;

import java.util.Scanner;


public class reverse_n2 {
	
	public static Node<Integer> takeinput(){
		Node<Integer> head= null,tail= null;
		Scanner s= new Scanner(System.in);
		int data= s.nextInt();
		
		while(data != -1) {
			
			Node<Integer> newNode= new Node<Integer>(data);
			if(head== null) {
				head= newNode;
				tail= newNode;
			}else{
				tail.next= newNode;
				tail= tail.next;
			}
			data= s.nextInt();
		}
		return head;
	}
	
	//list ka head return karenge so Node<Integer> return type
	public static Node<Integer> reverseR(Node<Integer> head){
		
		if(head== null || head.next== null) { //basecase= khali list hai ya 1 length ki list hai to already sorted hai
			return head;
		}
		//yahase niche aaye means at least 2 length ki string hai
		
		Node<Integer> finalHead= reverseR(head.next); //ek element chhodke aage ki list ko reverse karre, hum usme recusrion call karre to we can expect ki reverse karke ladega and muje reversed list ka head collect karna hai
	   //humara 1st element abhibhi head pe pda hua hai, so us element ko leke reversed list ke end mai attach karna hai, reversed list finalHead mai collected hai
	
		//end pe jane keliye travel karna padega so temp variable lete hai
		Node<Integer> temp= finalHead;
		
		//travel karenge last element pe pahuchne keliye
		while(temp.next != null) { //jabtak temp ka next null nhi ho jata tabtak travel krte rahenge, jab last element pe pahuchnege to uska next null hi hoga
			temp =temp.next;
		}
		//loop ke bahar ke bad hum last element pe honge means temp humra last element hoga so uske next mai head(purane list ka head, head mai hi original list ke first element ka access hai) dal denge.
		temp.next= head;
		head.next= null; //first element ko last mai le gye ab uske next mai null dalna padega.
		
		return finalHead;
	}
	
	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.print(head.data+ " ");
			head= head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		Node<Integer> head= takeinput();
		head= reverseR(head);
		print(head);
	}

}
