Length of LL

For a given singly linked list of integers, find and return its length. Do it using an iterative method.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
First and the only line of each test case or query contains elements of the singly linked list separated by a single space. 

 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element.

Output format :
For each test case, print the length of the linked list.
Output for every test case will be printed in a separate line.

 Constraints :
1 <= t <= 10^2
0 <= N <= 10^5

Time Limit: 1 sec

Sample Input 1 :
1
3 4 5 2 6 1 9 -1
Sample Output 1 :
7

Sample Input 2 :
2
10 76 39 -3 2 9 -23 9 -1
-1
Sample Output 2 :
8
0

Code:

package LinkedList_Input;

import java.util.Scanner;

public class Assign_LengthOfLL {

	public static Node<Integer> takeInput() {
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
				tail = newNode; // tail = tail.next
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

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		int result = length(head);
		System.out.println(result);

	}

}
