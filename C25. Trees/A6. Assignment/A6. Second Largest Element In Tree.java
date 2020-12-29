Second Largest Element In Tree

Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.

Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 

Output format:
Second Largest node data

Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40

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
	
	public static void RemoveMax( TreeNode<Integer> root, int largest ) {
		
		if ( root == null ) {
			
			return;
		}
		
		if ( root.data == largest ) {
			
			root.data = Integer.MIN_VALUE;
		}
		
		for ( int i = 0; i < root.children.size(); i++ ) {
			
			RemoveMax( root.children.get(i), largest );
		}
		
	}
	public static TreeNode<Integer> largest(TreeNode<Integer> root){
		// Edge Case not base case
	    if (root == null) {

			return null;
		}
        
	    TreeNode<Integer> large = root;
		int largest = root.data;
        int childLargest = 0;
		
        for (int i = 0; i < root.children.size(); i++) {
            
			TreeNode<Integer> largestChild = largest(root.children.get(i));
		    childLargest = largestChild.data;
		    
			if ( largestChild == null ) {
				
				continue;
			}
			if ( childLargest > largest ) {
				
				largest = childLargest ;
				large = largestChild;
			}
		}

		return large;
	}
    	
	
	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


		 if (root == null) {

   			return null;
   		}
        
        RemoveMax ( root, largest(root).data );
        
        return largest(root);

	}	
}
