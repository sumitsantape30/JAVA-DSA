Code : Print Level Wise

Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in differnet lines.

Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 

Output Format :
Level wise print

Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50

Code:

import java.util.LinkedList;
import java.util.Queue;
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
	
	public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
       Queue<TreeNode<Integer>> queue = new LinkedList<>();
		
	   queue.add(root);
	   queue.add(null);
		
	   while ( !queue.isEmpty() ) {
		    
		   TreeNode<Integer> frontNode = queue.poll();
		   
		   if ( frontNode == null ) {
			   
			   System.out.println();
			   
			   if ( !queue.isEmpty() ) {
				   
				   queue.add(null);
			   }
		   } 
		   
		   else {
			   
			   System.out.print(frontNode.data + " ");
			   
			   for ( int i = 0; i < frontNode.children.size(); i++ ) {
				   
				   queue.add(frontNode.children.get(i));
			   }
		   }
	   }
	}
		
}
