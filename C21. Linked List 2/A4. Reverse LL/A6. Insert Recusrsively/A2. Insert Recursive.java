package Insert_Recursive;
import java.util.Scanner;

public class Insert_Recursive {
	
	public static Node<Integer> insert(Node<Integer> head, int pos, int element ){
		
		if(pos==0) { //agar pos 0 pe insert karna haito
			// agar zero positon pe insert karna hai to uss element ke corresponding newNode banake uske next mai baki list link kardenge
			Node<Integer> newNode= new Node<Integer>(element);
			newNode.next= head; 	
			return newNode;
		}
		
		if(head== null) { // agar head null hua but pos fir bhi koi number h to 
			return head;
		}
		
		//hum recursion ke bolenge 1 element/head chhodke aage ki list mai pos-1 pe element insert karke list lake de
		head.next= insert(head.next, pos-1, element);// Jo new inserted list hogi uska head lake dega and jo humare pas head hai uske next mai attach kardena padega
		return head; //finally overall list ka head return karega.
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
       head= insert(head,4,20);
       print(head);
		
	}

}
