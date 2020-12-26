package Reverse_Iterative;

import java.util.Scanner;


public class Reverse {
	
	public static Node<Integer> takeInput(){
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
	
	public static Node<Integer> reverse(Node<Integer> head){
		
	   
       Node<Integer> curr= head; //intially current first node pehi hoga
       Node<Integer> prev= null; //initially current first node pe hoga to uska previous wala koi node hai hi nhi so null
       Node<Integer> temp;
       
       while(curr != null) { //current aage aage badhate jayega ennd tak... jab current null hojayega tp rukna hai. Jab current khatam hojayga to prev last wale node pe hoga
    	   temp = curr.next; //current ka next wala node hai usko store karlena chahiye
    	   curr.next= prev; //current ke next wale ko bolenge previous ko point kr
    	   prev= curr; //ab jo current hai woh previous banne wala hai
    	   curr= temp; // and jo temp mai store kiye the pehle ab woh current hoga.
       }
       return prev;	//Jab current khatam hojayga to prev last wale node pe hoga and last node hi hamara head hai reverse ke bad so prev return kar rhe h
	}
	
  public static void print(Node<Integer> head) {
		
		
		while(head != null){
			System.out.println(head.data+" ");
			head= head.next;
			}
		}
	
	public static void main(String[] args) {
 
		Node<Integer> head= takeInput();
		head= reverse(head);
		print(head);
	}

}
