package Restart;

public class LinkedListUse {

	//agar hume list print karni hai to hume usme list deni hogi, to hum usme input first node ka reference de denge, coz first denge to usko pta hoga second kaha h, second ko third kaha h pta hoga.
	// so jab bhi hum list pass kr rhe honge to hum first node ka reference pass kr rhe honge, first node ka reference is head.
	public static void print( Node<Integer> head) { // Node<T> type ka hi hume input dena padega

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {

		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		node1.next = node2;
		node2.next = node3;

		Node<Integer> head = node1;
        print(head);
        print(head); 

// main wala head and print function wala head dono alag alag hai
// suppose main wale head mai pehle @150 tha, to print function karne bad bhi main wale head mai @150 hi rahega.
//print function sirf apne local wale head ko aage traverse kar rha hai, jab print function khatam hoga to woh head null hojayega.
// dubara print call karenge to us call mai main wala hi head jayega.
		
	}

}
