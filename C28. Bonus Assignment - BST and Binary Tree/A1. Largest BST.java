Largest BST

Given a Binary tree, find the largest BST subtree. That is, you need to find the BST with maximum height in the given binary tree. You have to return the height of largest BST.

Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format:
The first and only line of output contains the height of the largest BST.

Constraints:
Time Limit: 1 second

Sample Input 1:
5 10 6 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
2

Code:

class Pair< t1, t2>{
	
	public t1 first;
	public t2 second;
}
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
	public static Pair<Pair<Integer,Integer>, Pair<Integer,Boolean>> largestbst( BinaryTreeNode<Integer> root ){
		
	if ( root == null ) {
			
	 Pair<Pair<Integer, Integer>, Pair<Integer, Boolean> > ans = new Pair<>();
	 Pair<Integer, Integer> pair1 = new Pair<>();
	 pair1.first = Integer.MIN_VALUE;
	 pair1.second = Integer.MAX_VALUE;
	 
	 Pair<Integer, Boolean> pair2 = new Pair<>();
	 pair2.first = 0;
	 pair2.second = true;
	 
	 ans.first = pair1;
	 ans.second = pair2;
	
	 return ans;
	}
	
	Pair<Pair<Integer,Integer>, Pair<Integer,Boolean>> leftsubtree = largestbst( root.left );
	Pair<Pair<Integer,Integer>, Pair<Integer,Boolean>> rightsubtree = largestbst( root.right );
	Pair<Pair<Integer,Integer>, Pair<Integer,Boolean>> ans = new  Pair<Pair<Integer,Integer>, Pair<Integer,Boolean>>();
	Pair<Integer,Integer> pair1 = new Pair<>();
	Pair<Integer,Boolean> pair2 = new Pair<>();
	pair1.first = Math.max( root.data, Math.max( leftsubtree.first.first, rightsubtree.first.first ));
	pair1.second = Math.min( root.data, Math.min( leftsubtree.first.second, rightsubtree.first.second ));

	pair2.second = leftsubtree.second.second && rightsubtree.second.second && ( root.data > leftsubtree.first.first) && (root.data < rightsubtree.first.second);
	
	if ( pair2.second ) {
		pair2.first = Math.max( leftsubtree.second.first, rightsubtree.second.first ) + 1;
	
	} else {
		pair2.first = Math.max( leftsubtree.second.first, rightsubtree.second.first );
		
	}
	
	ans.first = pair1;
	ans.second = pair2;
	
	return ans;
   }
	
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		return largestbst( root ).second.first;
	
	}

}
