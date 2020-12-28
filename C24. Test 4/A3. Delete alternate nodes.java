Delete alternate nodes

Given a Singly Linked List of integers, delete all the alternate nodes in the list.

Example:
List: 10 -> 20 -> 30 -> 40 -> 50 -> 60 -> null
Alternate nodes will be:  20, 40, and 60.

Hence after deleting, the list will be:
Output: 10 -> 30 -> 50 -> null

Note :
The head of the list will remain the same. Don't need to print or return anything.

Input format :
The first and the only line of input will contain the elements of the Singly Linked List separated by a single space and terminated by -1.
Output Format :
The only line of output will contain the updated list elements.

Input Constraints:
1 <= N <= 10^6.
Where N is the size of the Singly Linked List

Time Limit: 1sec
Sample Input 1:
1 2 3 4 5 -1
Sample Output 1:
1 3 5

Sample Input 2:
10 20 30 40 50 60 70 -1
Sample Output 2:
10 30 50 70 

Code:

/* 

    Following is the class used to represent the Node of a Singly Linked List

    class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.setData(data);
            this.next = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

    }
*/

public class Solution {

    public static void deleteAlternateNodes(Node<Integer> head) {
         if ( head == null || head.next == null ) {
			
			return;
		}
		
		Node<Integer> h1 = head, t1 = h1;
		Node<Integer> h2 = head.next , t2 = h2;
		
		head = head.next.next;
		
		while ( head != null && head.next != null ) {
			
			t1.next = head;
			t2.next = head.next;
			
			t1 = t1.next;
			t2 = t2.next;
			
			head = head.next.next;
			
		}
		
		if ( head != null ) {
			
			t1.next = head;
			t1 = t1.next;
		}
		
		t1.next = null;
		t2.next = null;
		
		//print(h1);
		
		
    }
    public static void print(Node<Integer> head) {

		while (head != null) {

			System.out.print(head.data + " ");

			head = head.next;
		}
	}
}
