package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTraversal {
	
	public static void preOrder(TreeNode<Integer> root) {
		
		//edge case handle karre
		if(root== null) { //agar root null hai so null ka data print karega to null pointer exception aajayegi
			return;
		}
		
		//sabse pehle aatehi root bolega muje print karo
		System.out.print(root.data+" ");
		
		//fir hum ek ek karke har ek child pe pre order call kar denge
		for(int i=0; i< root.children.size(); i++) {
			preOrder(root.children.get(i));
		}
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
		preOrder(root);
    System.out.println();
	}

}

Output:

Enter the root data
1
Enter the number of children of1
2
Enter the 1th child of 1
2
Enter the 2th child of 1
3
Enter the number of children of2
2
Enter the 1th child of 2
4
Enter the 2th child of 2
5
Enter the number of children of3
2
Enter the 1th child of 3
6
Enter the 2th child of 3
7
Enter the number of children of4
0
Enter the number of children of5
0
Enter the number of children of6
0
Enter the number of children of7
0
1 
2 3 
4 5 6 7 
1 2 4 5 3 6 7 (left se right call hoga)

