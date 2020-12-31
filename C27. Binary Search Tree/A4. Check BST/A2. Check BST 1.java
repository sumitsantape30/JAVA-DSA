package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BST1 {
	
	  public static int minimum(BinaryTreeNode<Integer>root) { //pure tree mese right side ka minimum nikalne keliye minimum call karre
		  
		  if(root== null) { //agar Tree ke right subtree mai kuh hai hi nhi to 
			  return Integer.MAX_VALUE; // agar mera tree khali hai to mai largest positive integer(sabse bura) return karunga   
		   //- infinity return karne ka matlab usko boht acha mil gya coz usko sabse chota chahiye tha isliye sabse bura output return karenge
		  }
		  
		  // right side ka overall minimum chahiye   = root hoga aur left side ka child hoga aur right side ka child hoga inko compare karenge jo minimum hoga usko return karenge
		  return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)) );  //right side se chota leke aao, left side se chota leke aao aur root se compare karo
	  }
	  
	  
     public static int maximum(BinaryTreeNode<Integer>root) { //pure tree mese left side ka maximum nikalne keliye maximum call karre
		  
		  if(root== null) { 
			  return Integer.MIN_VALUE;  
		  }
		  // left side ka overall maximum chahiye  = root hoga aur left side ka child hoga aur right side ka child
		  return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)) );  
	  }
	
	  public static boolean isBST(BinaryTreeNode<Integer>root) { //hume input mai root mil rha hai
		  
		  if(root== null) { //agar root null hai means pura khali hai tree to definitely BST hai
			  return true;
		  }
		  
		  int leftMax= maximum(root.left); // root ke left side ka maximum chahiye hume
		  int rightMin= minimum(root.right); // root ke right side ka minimum
		  
		  //jaisehi root hume left side ka max and root ke right side ka min milgya to root ke data ke sath compare karenge
		  if(root.data <= leftMax) { //BST mai agar root ka data left subtree ke max se bada hai to true otherwise false (equal bhi nhi hona chahiye)
			  return false; //left side pe root se bakuch chota hona chahiye, so maximum bhi chota hona chahiye, maximum chota hoga to baki sab chote hi rahenge.
		  }
		  
		  
		  if(root.data >= rightMin) { //root ke right subtree ka minimum bada hona chahiye root se tabhi true otherwise false
			  return false;
		  }
		  //yaha tak root keliye check hogya but sabke liye check karna hai
		  
		  boolean isLeftBST= isBST(root.left);// mai left ko bolunga, tu bta tu BST hai ya nhi
		  boolean isRightBST= isBST(root.right); //mai right kabhi bolunga ki tu bta tu BST hai ya nhi
		  
		  //agar dono ke dono BST hai to return true otherwise false
		  if(isLeftBST && isRightBST) {
			  return true;
		  }else {
			  return false;
		  }
	  }
	  
//isme hum n*h kam kr rhe hai, hum isliye extra kam kr rhe hai, pehle left ko bolte hai max le aa fir nich firse bolte hai BST hai ya nhi agar ek baari mai hi bolde ki max bhi chahiye aur isBST bhi chahiye, fir right kabhi bolna padega ki minimum chahiye aur isBST chahiye but ek function kabhi maximum kabhi minimum return nhi kr skta so in the next variation we'll return maximum, minimum as well as isBST, teeno return karenge
	
	   public static BinaryTreeNode<Integer> takeInput( ) {
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Enter root data: ");
			int rootdata = s.nextInt();
					
			
			if ( rootdata == -1 ) {
				
				return null;
			}
			
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

			BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);
			
			pendingNodes.add(root);
			
			while (!pendingNodes.isEmpty() ) {
				
				BinaryTreeNode<Integer> frontNode = pendingNodes.poll();
				
				System.out.println("Enter the left child of " + frontNode.data );
				int leftChild = s.nextInt();
				
				if ( leftChild != -1 ) {
					
					BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
					pendingNodes.add(child);
					frontNode.left = child;
				}
				
				System.out.println("Enter the right child of " + frontNode.data );
				int rightChild = s.nextInt();
				
				if ( rightChild != -1 ) {
					
					BinaryTreeNode<Integer> child = new BinaryTreeNode<>(rightChild);
					pendingNodes.add(child);
					frontNode.right = child;
				}
			}
		  	
		   return root;	
		}
	      

	  public static void printLevelWise(BinaryTreeNode<Integer> root) {

			
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
			pendingNodes.add(root);
		    pendingNodes.add(null);

			while(!pendingNodes.isEmpty()) {
				BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

		    
		        if (frontNode == null) {
		            System.out.println();

		            if (!pendingNodes.isEmpty()) {
		                pendingNodes.add(null);
		            }

		        } else {
		        	System.out.print(frontNode.data + " ");

		            if (frontNode.left != null) {
		                pendingNodes.add(frontNode.left);
		            } 

		            if (frontNode.right != null) {
		                pendingNodes.add(frontNode.right);
		            } 
		        }

			}
			
		}
			
	public static void main(String[] args) {
 
		BinaryTreeNode<Integer> root= takeInput();
		printLevelWise(root);
		boolean result= isBST(root);
	}

}

