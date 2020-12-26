Delete node (recursive)

Given a singly linked list of integers and position 'i', delete the node present at the 'i-th' position in the linked list recursively.
	
 Note :
Assume that the Indexing for the linked list always starts from 0.
No need to print the list, it has already been taken care. Only return the new head to the list.
	
input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains the elements of the singly linked list separated by a single space.
The second line of input contains a single integer depicting the value of 'i'.
	
Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output format :
For each test case/query, print the elements of the updated singly linked list.
Output for every test case will be printed in a seperate line.
	
Constraints :
1 <= t <= 10^2
0 <= M <= 10^5

Where M is the size of the singly linked list.
0 <= i < M

Time Limit:  1sec

Sample Input 1 :
1
3 4 5 2 6 1 9 -1
3
Sample Output 1 :
3 4 5 6 1 9
	
Sample Input 2 :
2
30 -1
0
10 20 30 50 60 -1
4
Sample Output 2 :
10 20 30 50 

Code:
package Delete_Recursively;

import java.util.Scanner;


public class DeleteRecursively {
	
     public static Node<Integer> deletion(Node<Integer> head, int pos){
		
    	 if(pos == 0) {
    		 return head.next; 
    	 }
    	 
    	 if(head== null || head.next== null) {
    		 return head;
    	 }
    	 
    	 head.next= deletion(head.next, pos-1);
    	 return head;
    	 
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
		head= deletion(head, 3);
		print(head);
	}

}
