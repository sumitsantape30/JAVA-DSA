package TakeInputLevelWise;

//agar collection framework wala queue use kr rhe ho to linkedlist and queue import karna padega
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeUse {
	
	//
	public static TreeNode<Integer> takeInputLevelWise(){
		
		// Recursive nhi hai so main mai scanner bhejne ki jarurat nhi h
		// ab yeh ek ek krke input lega
		Scanner s= new Scanner(System.in);
		
		//sabse pehle root data lena chahiye
		System.out.println("Enter the root data");
		int rootdata= s.nextInt();
		
		//iska children nhi puchenge hum isko pehle queue mai dal dena hai so Ek queue banayenge then root data ke corresponding node banake queue mai dal denge.
		QueueUsingLL<TreeNode<Integer>> pendingNode= new QueueUsingLL<>();// QueueUsingLL use karke queue banayi hai humne aur usme data 'TreeNode' dalenge, jo treenode dalenge woh Integer type ka hoga
		
		TreeNode<Integer> root= new TreeNode<Integer>(rootdata); // root data ke corresponding node bana rhe taki usko queue mai dal ske
		// root ko pehle queue mai dalenge then woh queue se bahar ayega tab uske children puchenge
		
		pendingNode.enqueue(root); //root ke data ke corrsponding jo TreeNode banaye the named "root" usko queue mai delenge then remove karenge tabhi usko children puchenge
		
		while(!pendingNode.isEmpty()) { //hum tabtak kam karenge jabtak humari queue khali nhi hojati
			
			try {
				
				TreeNode<Integer> frontNode= pendingNode.dequeue();//humari queue se front node bahar nikalenge
				//dequeue exception throw karega, so humare pas do options hai ya to hum usko handle karle ya fir hum usko upar throw karde, but exception nhi ayega coz hum wahi check karke loop mai enter kr rhe hai but isko handel karna padega so try catch lagate hai
			
			// humne front node remove kardiya ab hume iss node ke children puchne hai
			System.out.println("Enter the number of children of"+ frontNode.data);
			int numChildren= s.nextInt();
			
			//jitne bhi numchildren honge hume utni bar children input lena hai 
			for(int i=0; i< numChildren; i++) {
				
				//jine numChildren bataye user ne woh children konse hai woh input lenge
				System.out.println("Enter the "+ (i+1) +"th child of "+frontNode.data); //0 se counting karega isliye (i+1) kiye taki 1 se starting kare
				int child= s.nextInt();
				
				//utni bar child input lene ke bad unke corresponding node banayenge
				TreeNode<Integer> childNode= new TreeNode<>(child);
				
				frontNode.children.add(childNode); // Jo queue se remove kiya(root) tha uske arraylist(children list) mai jo childrens(ChildNode) hai woh dal rhe means jo frontNode hai uske childrenList mai childNode ko add karna hai and jo meri queue thi usmemuje ab yeh children dal dene hai
			
				pendingNode.enqueue(childNode);// ab root ka jo childNode(root ke children) hai unko queue mai dalenge coz maine childNode ke children nhi puche hai
				
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
	
//	public static void print(TreeNode<Integer> root) {
//		String s = root.data + ":";
//		for (int i = 0; i < root.children.size(); i++) {
//			s = s + root.children.get(i).data + ",";
//		}
//		System.out.println(s);
//		for (int i = 0; i < root.children.size(); i++) {
//			print(root.children.get(i));
//		}
//	}

	public static void main(String[] args) {
  
		TreeNode<Integer> root= takeInputLevelWise();
		printLevelWise(root);
		
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
3
Enter the 1th child of 3
6
Enter the 2th child of 3
7
Enter the 3th child of 3
8
Enter the number of children of4
1
Enter the 1th child of 4
9
Enter the number of children of5
0
Enter the number of children of6
0
Enter the number of children of7
0
Enter the number of children of8
0
Enter the number of children of9
0
1 
2 3 
4 5 6 7 8 
9 
