// This is for BinaryTree and Not BinarySearchTree

package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RootToNodePath {

	public static BinaryTreeNode<Integer> takeInput() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter root data: ");
		int rootdata = s.nextInt();

		if (rootdata == -1) {

			return null;
		}

		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();

		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootdata);

		pendingNodes.add(root);

		while (!pendingNodes.isEmpty()) {

			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

			System.out.println("Enter left child of " + frontNode.data);
			int leftChild = s.nextInt();

			if (leftChild != -1) {

				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}

			System.out.println("Enter right child of " + frontNode.data);
			int rightChild = s.nextInt();

			if (rightChild != -1) {

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

	//jo data dhund rhe hai us node tak hum path return karr rhe honge, means group of integers return kar rhe honge so unko arraylist mai dalke arraylist return karenge.
	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root, int data) {  //input mai hume root milega and uss root ka data milega jo hum chahiye
		
		if (root == null) { //agar tree hi kahli hai to kuch nhi milega so return null
			return null;
		}

		if (root.data == data) { //aagar jo data hume chahiye woh root pehi milgya to hum ek arraylist banayenge aur usme root ka data dalenge aur return karenge.

			ArrayList<Integer> output = new ArrayList<>();
			output.add(root.data);
			return output;
		}

		//yahhpe aaye means na to root null and and nahi jo data chahiye tha woh root pe hai. So, we're going to call on both left side and right side, yeh BST nhi hai so muje pta nhi konse side mai milega so dono side mai call karenge.
		ArrayList<Integer> leftOutput = getRootToNodePath(root.left, data);
		
		//agar left side ka call hoke not null answer aya means hume left mai answer milgya, hum usme root ka data append karenge and return
		if (leftOutput != null) {
			leftOutput.add(root.data);
			return leftOutput;
		}
		
		//yaha pe pahuche means left side mai answer nhi mila so hum ab right mai call karenge
		ArrayList<Integer> rightOutput = getRootToNodePath(root.right, data);
		
		//agar right side se not null answer aya hai means hum path milgyi hai, hum usme apna root ka data append kardenge
		if (rightOutput != null) {
			rightOutput.add(root.data);
			return rightOutput;
		} else { //iss else mai aye means right side se null output aya hai. left side se to pehlehi null agya tha tabhi rightOutput pe pahuche
			return null;
		}
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		printLevelWise(root);
		ArrayList<Integer> result = getRootToNodePath(root, 3);
		System.out.println(result);

	}

}
