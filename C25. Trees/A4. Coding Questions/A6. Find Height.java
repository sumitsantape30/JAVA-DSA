Code : Find Height

Given a generic tree, find and return the height of given tree.

Input format:
The first line of input contains data of the nodes of the tree in level order form. The order is: data for root node, number of children to root node, data of each of child nodes and so on and so forth for each node. The data of the nodes of the tree is separated by space.  
Output Format :
The first and only line of output prints the height of the given generic tree.

Constraints:
Time Limit: 1 sec

Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1:
3

Code:

package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaxHeight {
	
	public static int height(TreeNode<Integer> root) {
		if( root== null ) { //agar tree null hoga to uski height 0 hogi
			return 0;
		}
		
		int maxHeight= 0; //aisehi max height 0 assume kr rhe hai
		
		//hum har ek substree pe jake uski height mang rhe hai and usko hum max height ke sath compare karenge, aur max Height ko update kar denge 
		for(int i=0; i<root.children.size();i++) {
			int max= height(root.children.get(i));
			
			if( maxHeight < max) {
				maxHeight= max ;
			}
		}
		return maxHeight + 1;
	}
	
	 public static TreeNode<Integer> takeInputLevelWise(){
			
			Scanner s= new Scanner(System.in); 
			
			System.out.println("Enter the root data");
			int rootdata= s.nextInt();
			
			QueueUsingLL<TreeNode<Integer>> pendingNode= new QueueUsingLL<>();
			
			TreeNode<Integer> root= new TreeNode<Integer>(rootdata);
			
			pendingNode.enqueue(root);
			
			while(!pendingNode.isEmpty()) {
				
				try {
					
					TreeNode<Integer> frontNode= pendingNode.dequeue();//front ko bahar nikalenge
					
				System.out.println("Enter the number of children of"+ frontNode.data);
				
				int numChildren= s.nextInt();
				
				for(int i=0; i< numChildren; i++) {
					
					System.out.println("Enter the "+ (i+1) +"th child of "+frontNode.data);
					
					int child= s.nextInt();
					
					TreeNode<Integer> childNode= new TreeNode<>(child);
					
					frontNode.children.add(childNode); // Connected frontNode(parent) to childNode(children)
					
					pendingNode.enqueue(childNode);// child ko queue mai dala
					
					}
				
				} catch (QueueEmptyException e) {
					
					// SHouldn't come here
					return null;
				} 
					
			}
			return root; 
		}
	 
	 public static void printLevelWise(TreeNode<Integer> root){
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

	public static void main(String[] args) {
      TreeNode<Integer> root= takeInputLevelWise();
      printLevelWise(root);
      height(root);
		
	}

}
