Remove Leaf nodes

Given a binary tree, remove all leaf nodes from it. Leaf nodes are those nodes, which don't have any children.

Note:
1. Root will also be a leaf node if it doesn't have left and right child. 
2. You don't need to print the tree, just remove all leaf nodes and return the updated root.

Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output Format:
The updated binary tree, after removing leaf nodes, is printed level wise. Each level is printed in new line.

Constraints
Time Limit: 1 second

Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
8
3 10
6 14  

Code:

import java.util.ArrayList;


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

	public static BinaryTreeNode<Integer> removeAllLeaves(BinaryTreeNode<Integer> root){
		
		if ( root == null ) {
			
			return null;
		}
		if ( root.left == null && root.right == null ) {
		
			return null;
		}
		
		root.left = removeAllLeaves( root.left );
		root.right = removeAllLeaves( root.right );
	
		return root;

	}

}
