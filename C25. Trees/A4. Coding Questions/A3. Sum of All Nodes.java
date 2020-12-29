Code : Sum of nodes

Given a generic tree, count and return the sum of all nodes present in the given tree.

Input format :
Elements in level order form separated by space (as per done in class). Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Sum of all nodes

Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190

Code:

package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SumOfNodes {
	
	public static int sumofnodes(TreeNode<Integer> root) {
		
		if(root == null) {
			return 0;
		}
		
		int sum= root.data; //root ke corresponding hum sum mai data store karenge and baki node keliye recursion call karenge
		
		for(int i=0; i< root.children.size();i++) {
			sum= sum + sumofnodes(root.children.get(i));
		}
		return sum;
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
		int sum= sumofnodes(root);
		System.out.println(sum);
	}

}
