package Restart;

public class LinkedListUse {

	public static void main(String[] args) {

		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		node1.next = node2;
		node2.next = node3;

		Node<Integer> head = node1;

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
		//Output: 10 20 30 (sirf first loop ka result ayega second loop ka result nhi ayega)
		// first wala loop khatam hojayega jab head null hojayega.
		// jab head null hoga tab hum first loop ke bahar ayenge, then second loop tak ayenge tab head already null ho chuka hoga so second loop enter hi nhi karenge coz loop condition false hogi

//=========================================================================================================================================================================================================		
		//if you want ki kuch kam karne ke bad list ko aage bhi use karna hai tumhe, we'll keep a reference of the first node with us in temp.
		//agar woh head/list hume first loop ke bad bhi use karna hai to first loop ke pehlehi uss head ko temp mai store karke rakh lo
		
		Node<Integer> node1 = new Node<>(10);
		Node<Integer> node2 = new Node<>(20);
		Node<Integer> node3 = new Node<>(30);
		node1.next = node2;
		node2.next = node3;

		Node<Integer> head = node1;
		Node<Integer> temp= head;
		
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
		
		head= temp; //yeh likhne ke bad mai use wapas first first pe leke aya
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		
	}

}
