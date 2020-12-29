package Questions;

import java.util.Scanner;

public class DiameterBinaryTreeBetter {

	//I am not going to return an Integer(neither height nor diameter , I am going to return a pair of both(pair mai pehle height hoga and dusra diameter hoga)
	// hum ek sath bol rhe ki height aur diameter lade taki complexity kam ho, aur bar bar calls nhi honge
	public static Pair<Integer, Integer> heightDiameter(BinaryTreeNode<Integer> root){
		
		if( root == null) { //agar root null hai to iski height and diameter zero hai, so we will create a pair means a object of Pair class
			Pair<Integer, Integer> output= new Pair<>();
			output.first= 0; // output ka first is zero(height)
			output.second= 0; //output ka second is zero (diameter)
			return output; //and we'll return output
		}
		
		//ab jab mai left pe call karunga recursively to woh muje do chize lake dega height and diameter, same jab mai right pe call karunga to woh muje do chize lake dega
		Pair<Integer,Integer> leftOutput= heightDiameter(root.left); //leftOutput contains left ki height and left ka diameter
		Pair<Integer,Integer> rightOutput= heightDiameter(root.right); //rightOutput contains right ki height and right ka diameter

		//overall height and overall diameter return karna hai
		//overall height will be 1 + max of left ki height and right ki height
		int height= 1 + Math.max(leftOutput.first, rightOutput.first);
		
		//Overall Diameter keliye diameter ke teen options hai
		//Diameter ka option 1 : left ki height + right ki height
		int option1= leftOutput.first + rightOutput.first;
		
		//Diameter ka option 2 : leftOutput ka diameter
		int option2= leftOutput.second;
		
		//Diameter ka option 3 : rightOutput ka diameter
		int option3= rightOutput.second;
		
		//so humara overall diameter will be max of all the options
		int diameter= Math.max(option1, Math.max(option2, option3));
		
		//humne overall height and diameter nikal liya ab hum ek pair banake means Pair class ka object banake usme yeh height and diameter dalke return karenge
		Pair<Integer, Integer> output= new Pair<>();
		output.first= height; //Output ki height
		output.second= diameter; //Output ki diameter
		return output; 
			
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
		System.out.println("diameter : "+ heightDiameter(root).second);//heightDiameter call krke uska second print karenge
		System.out.println("Height : "+ heightDiameter(root).first); 
		
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
8
Enter right child of 4
-1
Enter left child of 5
-1
Enter right child of 5
6
Enter left child of 8
9
Enter right child of 8
-1
Enter left child of 6
-1
Enter right child of 6
7
Enter left child of 9
-1
Enter right child of 9
-1
Enter left child of 7
-1
Enter right child of 7
-1
1L:2,R:3
2L:4,R:5
4L:8,
8L:9,
9
5R:6
6R:7
7
3
diameter : 6
Height : 5
