package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NodesWithLargestData {
	
	public static int largest(TreeNode<Integer> root) {
		
		//sabse pehle edge case, this is not basecase
		if(root == null) { 
			return Integer.MIN_VALUE; //yeh value khali tree ki sabse largest value hogi. agar khali tree hai, aur hume largest chahiye so -infinity return kar denge
		}
		
		int ans= root.data;
		
		//ek ek karke har child(subtree) pe jayege and use bolenge apna largest lake do means har subtree ka largest lake do
		for(int i= 0; i< root.children.size(); i++) {
			int childLargest = largest(root.children.get(i));
			
			//yeh subtree ka largest bada h than the answer we had so far, to hum answer ko update kar denge
			if( childLargest > ans) {
				ans= childLargest;
			}
		}
		return ans;
		
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
       TreeNode<Integer> root = takeInputLevelWise();
       printLevelWise(root);
       System.out.println(largest(root));
		
	}

}

Output:

Enter the root data
1
Enter the number of children of1
3
Enter the 1th child of 1
2
Enter the 2th child of 1
3
Enter the 3th child of 1
4
Enter the number of children of2
0
Enter the number of children of3
2
Enter the 1th child of 3
5
Enter the 2th child of 3
6
Enter the number of children of4
2
Enter the 1th child of 4
8
Enter the 2th child of 4
20
Enter the number of children of5
0
Enter the number of children of6
0
Enter the number of children of8
0
Enter the number of children of20
0
1 
2 3 4 
5 6 8 20 
20
