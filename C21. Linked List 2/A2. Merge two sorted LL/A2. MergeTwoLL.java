Code : Merge two sorted LL

You have been given two sorted(in ascending order) singly linked lists of integers.
Write a function to merge them in such a way that the resulting singly linked list is also sorted(in ascending order) and return the new head to the list.

Note :
Try solving this in O(1) auxiliary space.
No need to print the list, it has already been taken care.

Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.
The first line of each test case or query contains the elements of the first sorted singly linked list separated by a single space. 
The second line of the input contains the elements of the second sorted singly linked list separated by a single space. 

Remember/Consider :
While specifying the list elements for input, -1 indicates the end of the singly linked list and hence, would never be a list element

Output :
For each test case/query, print the resulting sorted singly linked list, separated by a single space.
Output for every test case will be printed in a seperate line.

Constraints :
1 <= t = 10^2
0 <= N <= 10 ^ 4
0 <= M <= 10 ^ 4
Where N and M denote the sizes of the singly linked lists. 

Time Limit: 1sec
Sample Input 1 :
1
2 5 8 12 -1
3 6 9 -1
Sample Output 1 :
2 3 5 6 8 9 12 
	
Sample Input 2 :
2
2 5 8 12 -1
3 6 9 -1
10 40 60 60 80 -1
10 20 30 40 50 60 90 100 -1
Sample Output 2 :
2 3 5 6 8 9 12 
10 10 20 30 40 40 50 60 60 60 80 90 100

Code:

package Restart;

import java.util.Scanner;

public class LinkedListUse {

	public static Node<Integer> input() {

		Node<Integer> head = null, tail = null;

		Scanner s = new Scanner(System.in);
		int data = s.nextInt();

		while (data != -1) {

			Node<Integer> newNode = new Node<Integer>(data);
			if( head == null) {
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
	
	public static Node<Integer> mergeSortedLL( Node<Integer> head1, Node<Integer> head2){
		
		if( head1 == null) { //agar head1 means first list null hai to head2 return kar denge means second list return kar denge.
			return head2;
		}
		
		if( head2 == null) { //agar head2 means second list null hai to head1 return kar denge means first list return kar denge.
			return head1;
		}
		
		
		Node<Integer> temp1= head1, temp2= head2; // dono list ke heads temp mai lenge taaki aage compare karne keliye traverse kr paye
		Node<Integer> head3= null, tail3= null; //final list ke head and tail intially null rahega
		
		
		if( temp1.data < temp2.data) {
			head3= temp1;
			tail3= temp1;
			temp1= temp1.next;
		}else {
			head3= temp2;
			tail3= temp2;
			temp2= temp2.next;
		} //iss loop ke bad meri final list mai first entry aagyi jisko humne head liya and ek hi element hai to usiko tail liya
		
		while( temp1 != null && temp2 != null) { //tabtak travel karenge jabtak dono mese ek list null nhi ho jati, means tabtak travel karenge jabtak dono list bhi not null hai
			
			if(temp1.data <= temp2.data){
				tail3.next= temp1;
				tail3= tail3.next;
				temp1= temp1.next;
			}else {
				tail3.next= temp2;
				tail3= tail3.next;
				temp2= temp2.next;
			}
		}
		//yaha tak aye means dono list mese koi ek null hogya, means list khatam hogyi so ab dusre list ke remaining element ko final ke tail mai link kar denge.
		if( temp1 != null) { //temp1 null hai means mera temp2 null hogya so temp1 ko final list aisehi link krdere
			tail3.next= temp1;
		}else {
			tail3.next= temp2;
		}
		return head3; //end mai final list ka head return karenge
	}
	
	public static void print(Node<Integer> head3) {
		
		while( head3 != null) {
			System.out.println(head3.data+" ");
			head3= head3.next;
		}
	}

	public static void main(String[] args) {

		Node<Integer> head1= input();
		Node<Integer> head2= input();
		Node<Integer> head3= mergeSortedLL(head1, head2);
		print(head3);
	}

}
