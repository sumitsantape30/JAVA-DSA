kReverse

Given a singly linked list of integers, reverse the nodes of the linked list 'k' at a time and return its modified list.
 'k' is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of 'k,' then left-out nodes, in the end, should be reversed as well.
Example :
Given this linked list: 1 -> 2 -> 3 -> 4 -> 5
For k = 2, you should return: 2 -> 1 -> 4 -> 3 -> 5
For k = 3, you should return: 3 -> 2 -> 1 -> 4 -> 5

 Note :
No need to print the list, it has already been taken care. Only return the new head to the list.

 Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains the elements of the singly linked list separated by a single space.
The second line of input contains a single integer depicting the value of 'k'.

 Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output format :
For each test case/query, print the elements of the updated singly linked list.
Output for every test case will be printed in a seperate line.

Constraints :
1 <= t <= 10^2
0 <= M <= 10^5
Where M is the size of the singly linked list.
0 <= k <= M

Time Limit:  1sec

Sample Input 1 :
1
1 2 3 4 5 6 7 8 9 10 -1
4
Sample Output 1 :
4 3 2 1 8 7 6 5 10 9

Sample Input 2 :
2
1 2 3 4 5 -1
0
10 20 30 40 -1
4
Sample Output 2 :
1 2 3 4 5 
40 30 20 10 

Code:

/*

    Following is the Node class already written for the Linked List

    class LinkedListNode<T> {
        T data;
        LinkedListNode<T> next;
    
        public LinkedListNode(T data) {
            this.data = data;
        }
    }

*/

public class Solution {

	public static int length(LinkedListNode<Integer> head){
		
		int len = 0;
		
		while(head != null) {
		
			head = head.next;
			
			len += 1;
		
		}
		
		return len;
		
	}
	 public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head) {
	    	
		      if(head == null || head.next == null) {
				
				   return head;
			   
			   }
	   
			   LinkedListNode<Integer> newNode =  reverse(head.next);
			  
			   head.next.next = head;
			  
			   head.next = null;
			   
			   return newNode;
			   
		}
	
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		
		if( k  >= length(head)) {
			
			return reverse(head);
		}
		LinkedListNode<Integer> t1 = head, h1 = head;
		
		int c = 1;
		
		while( c < k ) {
			
			t1 = t1.next;
			
			c++;
		}
		LinkedListNode<Integer> h2 = t1.next;
		t1.next = null;
		
	    LinkedListNode<Integer> revList = reverse( h1 );
	    
	    //LinkedListNode<Integer> tailOfRevList = h1;
	    
	    LinkedListNode<Integer> smallAns = kReverse( h2, k );
		
	    h1.next = smallAns;
	    
	    return revList;
	}

}
