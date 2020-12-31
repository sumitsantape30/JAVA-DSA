package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsBST3 {

//isme hum upar se niche ja rhe hai, top to bottom
	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) { //we'get input a root and along with it we need two more integers min and max which are part of range(they meant kitne se kitne bich mai ho skta hai)
		
		if( root == null) { //agar tree khali hai to we'll return true
			return true;
		}
		
		if(root.data < min && root.data > max) { //root ka data range ke bich mai hona chahiye, agar range mai nhi hai to will return false aage nhi dekhenge
			return false;
		}
		
		//mai left and right pe call karunga and woh BST hai ki nhi lake denge
		boolean isLeftOk= isBST3(root.left , min, root.data-1); //left keliye minimum value same hi rahegi and jitna root hai usse kam
		boolean isRightOk= isBST3(root.right, root.data+1 , max); //right side pe lower value change ho rhi hai, everything has to be grater than root, can be equal to root as well so root.data se leke max tak
		
		//and if both are true then our tree is BST so return true otherwise return false
		return isLeftOk && isRightOk;
		
	}
	
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

		while (!pendingNodes.isEmpty()) {
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

    Scanner s= new Scanner(System.in);
    int min= s.nextInt();
    int max= s.nextInt();
		BinaryTreeNode<Integer> root = takeInput();
		printLevelWise(root);
		System.out.println(isBST3(root, min, max));
        
	}

}
