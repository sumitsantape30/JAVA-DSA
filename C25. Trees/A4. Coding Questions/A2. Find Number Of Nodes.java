package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfNodes {
	
	public static int numNode(TreeNode<Integer> root) {
		
		//humari for loop ki wajah se apne aap handle hogyi hai, humne for loop lagaya hai to agar koi child nhi hoga to woh call hi nhi karega aage loop mai, there's only one where it won't work - agar tumne intial mai hi null input de diye, means humne bola ki Tree hi nhi hai, khali hai tree
		if(root== null) { // agar input mai tree khali hai, kuch bhi nhi h tree mai.( this is not the base case, this is edge case) (basecase woh hota hai jab recursion chota hote hote hote hum wahapr aate hai, but iss case mai hum ispe kabhi nhi ayenge, hum ispe tabhi ayenge agar user initially input mai null pass kiya sirf usi case mai humara edge case hit hoga
			return 0;
		} 	
		
		int count= 1; //root ke corresponding 1 le lete hai instead of starting count from 0
		
		//ek ek krke har ek child ke upar call kar dete hai ki batao number of nodes
		for(int i=0; i< root.children.size();i++) {
			count= count+ numNode(root.children.get(i));
		}
		return count;
		
		//humne root ka count 1 liya then baki jitne bhi nodes hai humne bola uska count hum nhi kar rhe recursively humare liye count hoke aajayega so aise basecase handle hua
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

		int count= numNode(root);
		System.out.println(count);
	}

}

Code:

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
8

