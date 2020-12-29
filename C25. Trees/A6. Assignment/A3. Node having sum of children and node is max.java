Node having sum of children and node is max

Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.
Input format :
Line 1 : Elements in level order form separated by space (as per done in class). Order is -
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element
Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Sample Output 1 :
1

Code:

public class Solution {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	public static int sumOfAllNode(TreeNode<Integer> root) {

		if (root == null) {

			return 0;
		}

		int sum = root.data;

		for (int i = 0; i < root.children.size(); i++) {

			sum += root.children.get(i).data;
		}

		return sum;
	}
	
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		   
        if (root == null) {

				return null;
			}

			TreeNode<Integer> ans = root;
			int sum = sumOfAllNode(root);
			
			TreeNode<Integer> maxNode = null;
			int maxSum = Integer.MIN_VALUE;
		    
		    for (int i = 0; i < root.children.size(); i++) {

			   TreeNode<Integer> x = maxSumNode(root.children.get(i));
			   
			   int xsum = sumOfAllNode(x);
			   
			   if ( xsum > maxSum ) {
				   
				   maxSum = xsum;
				   maxNode = x;
			   }
			}
		    
		    if ( sum > maxSum ) {
		    	
		    	return ans;
		    }

			return maxNode;
	}
	
}
