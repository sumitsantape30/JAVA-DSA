Next Number

Given a large number represented in the form of a linked list. Write code to increment the number by 1 in-place(i.e. without using extra space).

Note: You don't need to print the elements, just update the elements and return the head of updated LL.

Input Constraints:
1 <= Length of Linked List <=10^6.

Input format :
Line 1 : Linked list elements (separated by space and terminated by -1)
Output Format :
Line 1: Updated linked list elements 

Sample Input 1 :
3 9 2 5 -1
Sample Output 1 :
3 9 2 6

Sample Input 2 :
9 9 9 -1
Sample Output 1 :
1 0 0 0 

Code:

/*************** 
 * Following is the Node class already written 
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
	}
}
 ***************/

public class Solution {


	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
           
        head = reverse(head);
		
		LinkedListNode<Integer> res = head, temp = null ;
		
		int cy = 1, sum;
		
		while ( head != null ) {
			
			//add cy to head.data and store it to sum
			sum = cy + head.data;
		    
			//find carry
			cy = ( sum >= 10 ) ? 1 : 0;
			
			//Update sum it could be >=10 or <10
			sum = sum % 10;
			
			//update data 
			head.data = sum;
			
			// store value in temp for future use
			temp = head;
			head = head.next;
		}
		
		if ( cy > 0 ) {
			
			LinkedListNode<Integer> newNode = new LinkedListNode<>(cy);
			temp.next = newNode;
		}
	
		return reverse(res) ;    
	}

    public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
	   
	   if ( head == null || head.next == null ) {
		   
		   return head;
	   }
	   LinkedListNode<Integer> prev = null;
	   
	   while ( head != null ) {
		   LinkedListNode<Integer> newNode = head.next;
		   head.next = prev;
		   prev = head;
		   head = newNode;
	   }
	   
	   return prev;
   }
}

