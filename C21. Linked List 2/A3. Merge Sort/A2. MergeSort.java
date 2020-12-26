Code : Merge Sort

Given a singly linked list of integers, sort it using 'Merge Sort.'

Note :
No need to print the list, it has already been taken care. Only return the new head to the list.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first and the only line of each test case or query contains the elements of the singly linked list separated by a single space.

Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output format :
For each test case/query, print the elements of the sorted singly linked list.
Output for every test case will be printed in a seperate line.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.

Time Limit: 1sec

Sample Input 1 :
1
10 9 8 7 6 5 4 3 -1
Sample Output 1 :
 3 4 5 6 7 8 9 10 
 
 Sample Output 2 :
2
-1
10 -5 9 90 5 67 1 89 -1
Sample Output 2 :
-5 1 5 9 10 67 89 90 

Code:

package MergeSort;

import java.util.Scanner;

public class MergeSort {

	public static Node<Integer> takeinput() {
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

	public static int Length(Node<Integer> head) {

		int length = 0;

		while (head != null) {
			head = head.next;
			length = length + 1;
		}
		return length;
	}

	public static Node<Integer> MidPoint(Node<Integer> head) {
		if (head == null || head.next == null) {
			System.out.println(" ");
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head;

		int len = Length(head);

		if (len % 2 == 0) {
			while (fast != null && fast.next.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		} else {
			while (fast != null && fast.next != null) {
				slow = slow.next;
				fast = fast.next.next;
			}
		}
		return slow;
	}

	public static Node<Integer> merge2Sortedlist(Node<Integer> head1, Node<Integer> head2) {

		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}

		Node<Integer> head3 = null, tail3 = null, temp1 = head1, temp2 = head2;

		if (temp1.data <= temp2.data) {
			head3 = temp1;
			tail3 = temp1;
			temp1 = temp1.next;
		} else {
			head3 = temp2;
			tail3 = temp2;
			temp2 = temp2.next;
		}

		while (temp1 != null && temp2 != null) {

			if (temp1.data <= temp2.data) {
				tail3.next = temp1;
				tail3 = tail3.next;
				temp1 = temp1.next;
			} else {
				tail3.next = temp2;
				tail3 = tail3.next;
				temp2 = temp2.next;
			}
		}

		if (temp1 != null) {
			tail3.next = temp1;
		} else {
			tail3.next = temp2;
		}
		return head3;
	}

	public static Node<Integer> mergeSort(Node<Integer> head) {// Recursive

		if (head == null || head.next == null) {
			return head;
		}

		Node<Integer> mid = MidPoint(head);
		Node<Integer> midnext = mid.next; // midnext yeh dusra part hai list ka
		mid.next = null;

		Node<Integer> left = mergeSort(head);
		Node<Integer> right = mergeSort(midnext);

		Node<Integer> Merged = merge2Sortedlist(left, right);

		return Merged;
	}

	public static void print(Node<Integer> head) {

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node<Integer> head = takeinput();
		Node<Integer> newHead = mergeSort(head);
		print(newHead);
	}

}
