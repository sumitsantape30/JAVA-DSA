package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DepthOfNode {
	
	
	  public static void printAtK(TreeNode<Integer> root, int k) {
		  
		  if(k < 0) {
			  return;
		  }
		  
		  //this is basecase
		  if(k== 0) { //agar depth zero hai to root ka data print kar denge
			  System.out.println(root.data);
			  return;
		  }
		  
		  //if k is non zero positive , to mai ek ek karke har child pe jaunga  aur k-1 pe printAtK call karunga
		  for(int i =0 ; i< root.children.size();i++) {
			  printAtK(root.children.get(i), k-1); //k depth se 0 depth tak ke sare node print karne hai so k ko har bar 1 decrease karna padega.
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
       printAtK(root,2);
		
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
7
Enter the number of children of3
1
Enter the 1th child of 3
8
Enter the number of children of4
2
Enter the 1th child of 4
6
Enter the 2th child of 4
8
Enter the number of children of7
0
Enter the number of children of8
1
Enter the 1th child of 8
9
Enter the number of children of6
0
Enter the number of children of8
0
Enter the number of children of9
0
1 
2 3 
4 7 8 
6 8 9 
4
7
8
(depth 2 pe 4,7,8 hai)
