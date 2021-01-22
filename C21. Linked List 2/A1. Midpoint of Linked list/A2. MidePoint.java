package Restart;

import java.util.Scanner;

public class Practices {

	public static Node<Integer> input() {
		Node<Integer> head = null, tail = null;

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();

		while (data != -1) {
			Node<Integer> newNode = new Node<Integer>(data);

			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}

	public static int length(Node<Integer> head) {
		int length = 0;

		while (head != null) {
			length++;
			head = head.next;
		}
		return length;
	}

	//Do pointers lenge, dono starting mai first node pe honge, slow ko mai ek step se aage move karunga and fast ko two steps se aage karunga(initially slow and fast dono head se start hue) 
	// Slow jis speed se move karra fast uske double speed se move karra, jab fast end pe pahuch chuka hoga to humara slow mid pe hoga, slow jispe hoga wahi midpoint hoga.
	public static Node<Integer> midPoint(Node<Integer> head, int length) {

		if (head == null || head.next == null) {
			return head;
		}

		// do pointers lenge slow and fast, dono starting mai first node pe honge, slow ek step aage jayega and fast do step aage jayega, jab fast end pe pahuch chuka hoga to slow humara mipoint pe hoga, slow jispe hoga woh answer hoga.
		Node<Integer> slow = head;
		Node<Integer> fast = head;

		if (length % 2 == 0) {

			while (fast != null && fast.next.next != null) { // even ki case mai tabtak aage badhate rahenge jabtak fast ke next ka next null nhi ho jata
				slow = slow.next;
				fast = fast.next.next;
			}
		} else {

			while (fast != null && fast.next != null) { // odd ki case mai tabtak aage badhte rahenge jabtak fast ke next wala null nhi hojata.
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow;
	}

	public static void main(String[] args) {

		Node<Integer> head = input();
		int length = length(head);
		Node<Integer> midpoint = midPoint(head, length);
		System.out.println(midpoint.data);
	}

}
