package Questions;

import java.util.Scanner;

public class CountNodesInBinaryTree {
	
	public static int CountNodes(BinaryTreeNode<Integer> root) {
	
		//Trees mai hum utne hi call krte the jitne children hai, agar ek node aisi aagyo jiska koi child nhi hai to hum koi call nhi krte the but hum yaha pakke se two calls kr rhe hai (left and right) without looking at whether left is null or not and whether right is null or not, we are making two calls so hume ab basecase ki jarurat padegi
		if( root == null) {
			return 0; //this is basecase now
		}
		
		int count=1;
		
		count += CountNodes(root.left);
		count += CountNodes(root.right);
		
		return count;
		
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
		System.out.println(CountNodes(root));
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
-1
Enter right child of 3
-1
Enter left child of 4
-1
Enter right child of 4
-1
Enter left child of 5
-1
Enter right child of 5
-1
1L:2,R:3
2L:4,R:5
4
5
3
5
