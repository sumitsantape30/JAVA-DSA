ZigZag tree

Given a binary tree, print the zig zag order. In zigzag order, level 1 is printed from left to right, level 2 from right to left and so on. This means odd levels should get printed from left to right and even level right to left.

Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output Format:
The binary tree is printed level wise, as described in the task. Each level is printed in new line.

Constraints
Time Limit: 1 second

Sample Input :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output :
5
10 6
2 3
9

Code:

import java.util.ArrayList;
import java.util.Stack;

public class Solution {

	/*	Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	 */

	public static void printZigZag(BinaryTreeNode<Integer> root) {
		
            Stack<BinaryTreeNode<Integer>> s1 = new Stack<>();
		  Stack<BinaryTreeNode<Integer>> s2 = new Stack<>();
		  s1.push(root);
		  
		  while ( !( s1.isEmpty() && s2.isEmpty() ) ) {
			
			   
			while (!s1.isEmpty()) {
                   
				   BinaryTreeNode<Integer> frontNode = s1.pop();
				   System.out.print( frontNode.data + " ");
				   
				   if ( frontNode.left != null ) {
					   s2.push( frontNode.left );
				   }
				   
				   if ( frontNode.right != null ) {
					   s2.push( frontNode.right );
				   }
			}
            System.out.println();
			while (!s2.isEmpty()) {
				 BinaryTreeNode<Integer> frontNode = s2.pop();
				   System.out.print( frontNode.data + " ");
				   
				   if ( frontNode.right != null ) {
					   s1.push( frontNode.right );
				   }
				   
				   if ( frontNode.left != null ) {
					   s1.push( frontNode.left );
				   }
			}
			System.out.println();
		  } 
		  
		

	}


}
