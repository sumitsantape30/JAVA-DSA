Code: Print Elements in Range

Given a Binary Search Tree and two integers k1 and k2, find and print the elements which are in range k1 and k2 (both inclusive).
Print the elements in increasing order.

Input format:
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
The following line contains two integers, that denote the value of k1 and k2.

Output Format:
 The first and only line of output prints the elements which are in range k1 and k2 (both inclusive). Print the elements in increasing order.

Constraints:
Time Limit: 1 second

Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
6 10
Sample Output 1:
6 7 8 10

Code:

package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintInRange {
	
//Normal Binary Tree hota to mai har node pe jata and check karta kya iss node ka data k1 and k2 ke bich mai hai, agar hai to print karo warna aage chalo
// BST mai har node pe jane ki jarurat nhi hai
// how do it? agar
// left pe call karna hai ya nhi karna, will take a call based upon root ke data ka minimum(k1) se kya comparison hai
//right side pe call karna hai nhi karna, will take a call based upon root ke data ka humare maximum se kya comparison hai. (agar range ka maximum chota hai root ke data se to obviosuly right pe call hi nhi karenge
// range ka minimum agar root ke data se bada hai to left mai call karenge hi nhi, sirf right pe call karnege
	public static void printInRange(BinaryTreeNode<Integer> root, int k1 , int k2) { //k1 to k2 ki range mai k1 is minimum and k2 is maximum
		 {
			 if(root== null) {
				 return;
			 }
			 
			 if( k1 < root.data) {
				 printInRange( root.left, k1, k2);
			 }
			 
			 if(k2 > root.data) {
				 printInRange(root.right, k1, k2);
			 }
			  
			 if( root.data >= k1 && root.data<= k2) {
				 System.out.println(root.data+" ");
			 }
		 }
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
	
	public static void main(String[] args) {
           BinaryTreeNode<Integer> root= takeInput();
           printLevelWise(root);
           printInRange(root,6,10);
		
	}

}

