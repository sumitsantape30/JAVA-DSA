package Questions;

import java.util.Scanner;

public class DiameterBInaryTree {
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		
		if( root == null) { //basecase
			return 0; //koi do node nhi hai to unke bich ka distance zero so mera diameter zero hogya
		}
		
		//will explore all three options
		//option1 : height of left subtree + height of right subtree
		int option1= height(root.left) + height(root.right);
		
		//option 2: humara answer left diameter hoga
		int option2= diameter(root.left);
		
		//option 3: humara answer right diameter hoga
		int option3= diameter(root.right);
		
		//inn teeno mese jo maximum hoga woh mera answer hoga
		return Math.max(option1, Math.max(option2,  option3));
			
	}

	public static int height(BinaryTreeNode<Integer> root) {

		if( root == null) { //if root is null then height is zero
			return 0;
		}
		
		//we'll return 1+ maximum of left height and maximum of right height.
		int leftH= height(root.left);
		int rightH = height(root.right);
		return 1+ Math.max( leftH, rightH);
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}

			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}

	public static void printTree(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		String toBePrinted = root.data + "";
		if (root.left != null) {
			toBePrinted += "L:" + root.left.data + ",";
		}

		if (root.right != null) {
			toBePrinted += "R:" + root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {

		BinaryTreeNode<Integer> root= takeInputLevelWise();
		printTree(root);
		System.out.println("Diameter : " + diameter(root));
	}

}

Output:

Enter root data
1
Enter left child of 1
2
Enter right child of 1
4
Enter left child of 2
3
Enter right child of 2
5
Enter left child of 4
-1
Enter right child of 4
-1
Enter left child of 3
9
Enter right child of 3
-1
Enter left child of 5
-1
Enter right child of 5
6
Enter left child of 9
10
Enter right child of 9
-1
Enter left child of 6
-1
Enter right child of 6
7
Enter left child of 10
11
Enter right child of 10
-1
Enter left child of 7
-1
Enter right child of 7
8
Enter left child of 11
-1
Enter right child of 11
-1
Enter left child of 8
-1
Enter right child of 8
-1
1L:2,R:4
2L:3,R:5
3L:9,
9L:10,
10L:11,
11
5R:6
6R:7
7R:8
8
4
Diameter : 8
