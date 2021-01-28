package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair<T, V> {
	public T first;
	public V second;
}

//BST1 approach mai timecomplexity acchi nhi aa rhi thi coz hum left pehi do bar recursion call krre the for max and for isBST
// issue was hum apne left ko bol rhe the max lake de fir hum first bolte the ki yeh btate isBST so kam repeat ho rha hai. *Baki Description Book mai*

//hume yaha left and right ko teeno chize mangne wale hai minimum, maximum and isBST so for that we need a triplet jisme do integer honge and ek boolean
// for triplet: triplet class bana lete hai or pair class ke andar ek pair integer, integer rakh lenge aur ek boolean, and yahi return karwa lenge
public class BST2 {

	public static Pair<Boolean, Pair<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root) { //we will return a pair which has boolean and another pair which has 2 integers 

		if (root == null) { //agar tree khali hai to BST to hai. hum iska minumum +ve infinity return karenge and maximum mai -infinity
           
			//I am assuming second pair ka pehle minimum and dursa maximum hai 
			
			//Pair class ka object banayenge, yeh mera output hai, abhi tree khali hai to hum abhi output mai aisehi values dalenge
			Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
			output.first = true; //output ka first is boolean which will be true
			output.second = new Pair<Integer, Integer>(); //output ka second will be another pair of integer,integer
			output.second.first = Integer.MAX_VALUE; //second pair ka first is minimum usme sabse bekar minimum value denge that is +infinty
			output.second.second = Integer.MIN_VALUE; // second pair ka second is maximum usme hum sabse bekar maximum value denge that is -infinity
			return output; //and output return karenge
		}
		
		//basecase done ab left aur right se yahi chize mangwate hai

		Pair<Boolean, Pair<Integer, Integer>> leftOutput = isBST2(root.left); //yeh muje left ka min and max and bst hai ya nhi yeh lake dega
		Pair<Boolean, Pair<Integer, Integer>> rightOutput = isBST2(root.right); //yeh muje right ka min and max and bst hai ya nhi yeh lake dega

		//overall min and max nikal rhe
		//overall minimum 
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.second));
		
		//overall maximum
		
		int max = Math.max(root.data, Math.max(leftOutput.second.first, rightOutput.second.second));

		//Overall isBSt
		//root ka data left side ke maximum se bada hona chahiye and right side ke minimum se equal or chota hona chahiye sirf yeh do condtions enough nhi hai, Main tree ka left itself should also be BST and right also should be BST

		Boolean isBST= (root.data > leftOutput.second.second) 
				&& (root.data <= rightOutput.second.first)
				&& leftOutput.first && rightOutput.first; //left and right bhi completely BST hona chahiye
	           //yeh charo condtions agar true ho rhi hai to humara tree BST hai
		
		//ab Pair class ka object named Output banake sari values usme dalenge
		Pair<Boolean, Pair<Integer, Integer>> output = new Pair<Boolean, Pair<Integer, Integer>>();
		output.first = isBST; //output ka first is BST hai ya nhi
		output.second = new Pair<Integer, Integer>(); //Output ka second will be another pair of Integer,Integer
		output.second.first = min; //output ke second pair ka first is minimum, jo overall min nikala tha wahi use hoga
		output.second.second = max; //Output ke sceond pair ka second is maximum, jo overall maximum hai woh use hoga
		return output;
	}

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

			System.out.println("Enter the left child of " + frontNode.data);
			int leftChild = s.nextInt();

			if (leftChild != -1) {

				BinaryTreeNode<Integer> child = new BinaryTreeNode<>(leftChild);
				pendingNodes.add(child);
				frontNode.left = child;
			}

			System.out.println("Enter the right child of " + frontNode.data);
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

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		printLevelWise(root);
		Pair<Boolean, Pair<Integer, Integer>> result = isBST2(root);
	}

}
