Number of Nodes greater than x

Given a tree and an integer x, find and return number of Nodes which are greater than x.
Input format :
Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of nodes greater than x

Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3

Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5

Code:

public class Solution {

/*	TreeNode class 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/

	
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		if (root == null) {

			return 0;
		}
        
		int count = 0;
		
		for ( int i = 0; i < root.children.size(); i++ ) {
            
			count += numNodeGreater( root.children.get(i) , x );
			//System.out.println(root.data +" Inside "+count);
		}
        
        
		if ( root.data > x ) {
			
			return count + 1;
			
		}
         
		return count;

	}
	
}
