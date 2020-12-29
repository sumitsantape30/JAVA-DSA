package Questions;

import java.util.Scanner;

public class InorderTraversal {
	
	//hum print karre, kuch return nhi karre
	public static void inorder( BinaryTreeNode<Integer> root) {
		
		//sabse ephle basecase
		if(root  == null) {
			return;
		}
		
		//fir mai left pe call karunga inorder fir uske bad root apna data print karega
		inorder(root.left);
		
		System.out.println(root.data + " "); //left pe call karne ke bad root bolega mai print hounga
		
		//root khud print hone ke ab apne right pe call karega
		inorder(root.right);
		
		//that's it isse humara inorder traversal print hojayega
		
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
		inorder(root);
	}

}

Output:

Enter root data
1
Enter left child of 1
2
Enter right child of 1
3
Enter left child of 2
4
Enter right child of 2
5
Enter left child of 3
6
Enter right child of 3
7
Enter left child of 4
-1
Enter right child of 4
-1
Enter left child of 5
-1
Enter right child of 5
-1
Enter left child of 6
-1
Enter right child of 6
-1
Enter left child of 7
-1
Enter right child of 7
-1
1L:2,R:3
2L:4,R:5
4
5
3L:6,R:7
6
7
4 
2 
5 
1 
6 
3 
7 
