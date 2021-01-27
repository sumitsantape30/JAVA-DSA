Code: Search Node in BST

Given a BST and an integer k. Find if the integer k is present in given BST or not. You have to return true, if node with data k is present, return false otherwise.

Note: Assume that BST contains all unique elements.

Input Format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
The following line of input contains an integer, that denotes the value of k.
Output Format:
The first and only line of output contains a boolean value. Print true, if node with data k is present, print false otherwise. 

Constraints:
Time Limit: 1 second

Sample Input 1 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
2
Sample Output 1 :
true

Sample Input 2 :
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
12
Sample Output 2 :
false

Code:

package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SearchNodeInBST {
	
	 //agar hum ek binary tree mai yeh kam kr rhe hote to pehle left pe call krte aur right pe bhi call krte aur dono mese answer aajata to hum us node ko return kardete but the benefit of binary search tree is that you do not have to call on both sides, you can figure out which side to call and which side to ignore
	 //agar mere root pe 5 rakha hai aur muje 10 dhundna hai to muje right mai jana hai left mai nhi jana
	 //so sabse pehle mai dekhunga kya root ke barabr hai? if hai to return root. then dekhunga kya root ke data se bada hai? if hai to right mai dhundate. Agar root data se chota hai to hum left mai dhund lenge.
	public static BinaryTreeNode<Integer> searchNodeInBST(BinaryTreeNode<Integer> root, int k) {

		if (root == null) { // basecase: agar root hi null hai to kya dhundenge
			return null;
		}

		// agar root ka data search query ke barabr hai to return root,
		if (k == root.data) {
			return root;
		}

		if (k > root.data) {
			return searchNodeInBST(root.right, k);
		}
		return searchNodeInBST(root.left, k);

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

		public static void main(String[] args)  {
			
			Scanner s= new Scanner(System.in);
			int k= s.nextInt();
			BinaryTreeNode<Integer> root= takeInput();
			printLevelWise(root);
			System.out.println(searchNodeInBST(root,k));
			
		}
}
