Check if a Binary Tree is BST

Given a binary tree with N number of nodes, check if that input tree is BST (Binary Search Tree). If yes, return true, return false otherwise.

Note: Duplicate elements should be kept in the right subtree.

Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have a left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format :
The first and only line of output contains either true or false.

Constraints :
Time Limit: 1 second

Sample Input 1 :
3 1 5 -1 2 -1 -1 -1 -1
Sample Output 1 :
true

Sample Input 2 :
5 2 10 0 1 -1 15 -1 -1 -1 -1 -1 -1
Sample Output 2 :
false

Code:

public class Solution {

    public static boolean isBST(BinaryTreeNode<Integer> root ) {
    	    if ( root.left == null && root.right == null ) {
			
			        return true;
		    }
    	   return isBST( root, Integer.MIN_VALUE, Integer.MAX_VALUE );
    }
    
	public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max ) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		if ( root == null ) {
			
			return true;
		}
		
		if ( min > root.data || root.data > max ) {
			
			return false;
		}
		
		return isBST( root.left , min, root.data ) && isBST( root.right, root.data , max );
		
	}
}
