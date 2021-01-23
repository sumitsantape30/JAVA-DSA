package ReverseLL_Recursive;
import java.util.Scanner;

public class Reverse_Recursively_on {
	
	public static Node<Integer> reverseLLR(Node<Integer> head){
		
		if( head== null || head.next== null) {
			return head;
		}
		
		Node<Integer> reversedTail= head.next; // mere first element ke bad wala jo node hai wahi recursion ke bad tail hoga so woh tail apn pehlehi rakhlete hai apne pas taki badme head ko directly iss tail ke pich attach kr ske
		Node<Integer> smallHead= reverseLLR(head.next); // reversed list ka head smallHead mai store hoga recursion hone ke bad
		//muje ab yeh reversed list ke tail pe jake head ko attach karna hai
		reversedTail.next= head;
		head.next= null;
		
	    return smallHead;
	}
	
	public static Node<Integer> TakeInput() {
		Node<Integer> head= null, tail=null;

		Scanner s= new Scanner(System.in);
		int data= s.nextInt();
		
		while(data != -1) {
			Node<Integer> newNode= new Node<Integer>(data);
			if( head==null) {
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
		System.out.println();
	}

	public static void main(String[] args) {
        Node<Integer> head= TakeInput();
        head =  reverseLLR(head);
        print(head);
	}
	
}
