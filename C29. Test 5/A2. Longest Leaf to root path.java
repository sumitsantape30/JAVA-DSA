Longest Leaf to root path

Given a binary tree, return the longest path from leaf to root. Longest means, a path which contain maximum number of nodes from leaf to root.
Input format :
Elements in level order form (separated by space)
(If any node does not have left or right child, take -1 in its place)
Line 1 : Binary Tree 1 (separated by space)

Sample Input 1 :
 5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1 :
9
3
6
5

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
	
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		
        if ( root == null ) {
    		return new ArrayList<>();
    	}
    	
    	ArrayList<Integer> leftArray = longestRootToLeafPath( root.left );
    	ArrayList<Integer> rightArray = longestRootToLeafPath( root.right );
    	
    	if( leftArray.size() >= rightArray.size() )
    	{
    		leftArray.add( root.data );
    		return leftArray;
    	} else {
    		rightArray.add( root.data );
    		return rightArray;
    	}
	}
	
}
