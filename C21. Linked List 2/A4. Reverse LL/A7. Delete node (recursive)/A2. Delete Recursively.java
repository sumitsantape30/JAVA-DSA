package Delete_Recursively;

import java.util.Scanner;


public class DeleteRecursively {
	
     public static Node<Integer> deletion(Node<Integer> head, int pos){
		
    	 if(pos == 0) {
    		 return head.next; 
    	 }
    	 
    	 if(head== null || head.next== null) {
    		 return head;
    	 }
    	 
    	 head.next= deletion(head.next, pos-1);
    	 return head;
    	 
	  }
	
	public static Node<Integer> takeInput(){
		Node<Integer> head= null, tail= null;
		Scanner s= new Scanner(System.in);
		int data= s.nextInt();
		
		while( data != -1) {
			Node<Integer> newNode= new Node<Integer>(data);
			if(head==null) {
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
	
	
	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.println(head.data+" ");
			head= head.next;
		}
	}

	public static void main(String[] args) {

		Node<Integer> head= takeInput();
		head= deletion(head, 3);
		print(head);
	}

}
