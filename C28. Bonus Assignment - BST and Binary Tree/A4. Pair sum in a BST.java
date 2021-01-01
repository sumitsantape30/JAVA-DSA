Pair sum in a BST

Given a binary search tree and an integer S, find pair of nodes in the BST which sum to S. You can use extra space of the order of O(log n).

Note:
1. Assume BST contains all unique elements.
2. In a pair, print the smaller element first.

Input Format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of S.
Output format:
You have to print each pair in a different line (pair elements separated by space). The order of different pairs, to be printed, does not matter.

Constraints:
Time Limit: 1 second 

Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 1:
2 10
5 7

Code:

import java.util.Stack;

public class Solution {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
	public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
		if( root == null ) {
			return;
		}
		
		Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		BinaryTreeNode<Integer> temp = root;
		
		while( temp != null ) {
			
			s1.push( temp );
			temp = temp.left;
		}
		
		temp = root;
		while (temp != null) {

			s2.push(temp);
			temp = temp.right;
		}
		
		while ( !s1.isEmpty() && !s2.isEmpty() && ( s1.peek().data < s2.peek().data )) {
		BinaryTreeNode<Integer> frontNodeOfLeft = s1.peek(), frontNodeOfRight = s2.peek();
		
		if ( frontNodeOfLeft.data + frontNodeOfRight.data == s ) {
		    
			System.out.println( frontNodeOfLeft.data +" "+ frontNodeOfRight.data );
			s2.pop();
			s1.pop();
		
			frontNodeOfLeft = frontNodeOfLeft.right;
				while (frontNodeOfLeft != null) {

					s1.push(frontNodeOfLeft);
					frontNodeOfLeft = frontNodeOfLeft.left;
				}

				frontNodeOfRight = frontNodeOfRight.left;
				while (frontNodeOfRight != null) {

					s2.push(frontNodeOfRight);
					frontNodeOfRight = frontNodeOfRight.right;
				}
			
				
			
		} else  if (frontNodeOfLeft.data + frontNodeOfRight.data < s ) {
		    
			s1.pop();
			frontNodeOfLeft = frontNodeOfLeft.right;

			while (frontNodeOfLeft != null) {

				s1.push(frontNodeOfLeft);
				frontNodeOfLeft = frontNodeOfLeft.left;
			}
			
		} else {
			
			s2.pop();
            frontNodeOfRight = frontNodeOfRight.left;
			
			while( frontNodeOfRight != null ) {
				
				s2.push( frontNodeOfRight );
				frontNodeOfRight = frontNodeOfRight.right;
			}
			
		}
		
	  }
	}

}
