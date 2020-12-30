Balanced

Given a binary tree, check if it is balanced. Return true if given binary tree is balanced, false otherwise.

Balanced Binary Tree:
A empty binary tree or binary tree with zero nodes is always balanced. For a non empty binary tree to be balanced, following conditions must be met:
1. The left and right subtrees must be balanced.
2. |hL - hR| <= 1, where hL is the height or depth of left subtree and hR is the height or depth of right subtree.    

Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format
The first and only line of output contains true or false.

Constraints
Time Limit: 1 second

Sample Input 1 :
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
false

Sample Input 2 :
1 2 3 -1 -1 -1 -1
Sample Output 2 :
true

Code:

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
     public static int height(BinaryTreeNode<Integer> root) {
		
        if ( root == null ) {
        	
        	return 0;
        }
        
        int leftCount = 1;
        int rightCount = 1;
        
        leftCount += height( root.left );
        rightCount += height( root.right );
        
        return Math.max(leftCount, rightCount );
        
	}


	
	public static boolean checkBalanced(BinaryTreeNode<Integer> root){
		
		 if ( root == null ) {
	    	
	    	return true;
	    }
		
        if ( Math.abs(height(root.left) - height(root.right )) > 1) {
        	
        	return false;
        }
        
        return checkBalanced( root.left ) && checkBalanced( root.right );
		
	}
	
}
