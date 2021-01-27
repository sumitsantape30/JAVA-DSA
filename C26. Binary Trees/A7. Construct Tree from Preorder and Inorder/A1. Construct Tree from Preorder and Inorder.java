package Questions;

import java.util.Scanner;

public class ConstructTree {

	//tree banana hai to tree ka root return karenge
	public static BinaryTreeNode<Integer> buildTree( int in[], int pre[] ){ //hume input mai inorder aur preorder ke arrays mil rhe hoga
		//user se hume sirf do chize mil rhi hogi so hum helper function use karenge
		return buildTreeHelper(in, pre, 0, in.length-1, 0, pre.length-1); //hum heper function mai input denge: in,pre, inorder ka start, inorder ka end, preorder ka start, preorder ka end
		
	}
	
	public static BinaryTreeNode<Integer> buildTreeHelper( int in[], int pre[], int inS, int inE, int preS, int preE  ) { //input mai muje dono array mil rha hai, inorder ka start & end and preorder ka start and End. Inko use krke muje apna tree build karna hai
        //mai assume kr rha ki dono array ki length same hai, agar nhi hogi to obviously invalid input hai
		//Basecase: agar start ne end ko cross kiya(means end ke piche start hai) to obviously tumhara array khali hai so return empty tree
		if( inS > inE) {
			return null;
		}
		
		//rootData mere preorder ke starting mai hoga usko rootData mai store karenge and then uska root banayenge
		int rootData= pre[preS] ; //mera root preorder ke starting mai hoga. index mai 0 mat dena, hume ek range mai karna hai so start index dena
		BinaryTreeNode<Integer> root= new BinaryTreeNode<>(rootData); //in the end we'll be returning root, yeh humare final wale tree ka root hai
		
		//hume preorder ke start mai root milgya hai ab usi root ko inorder mai dhundte hai kaha rakha hua hai hai root ka index
		int rootInIndex= -1; //abhi pta nhi hai to -1 rakh lete hai
		
		//Inorder ki jo range hai, inS to inE, har ek element pe jayenge iss range mai aur check karenge inorder array mai rootData hai kya
		for( int i= inS; i<= inE; i++) {
			if( in[i] == rootData) {
				//jaisehi inorder ka rootData mil gyaa, i will set rootInIndex to be i and i'll break karenge aur kuch nhi karna
				rootInIndex= i;
				break;
			}
		}
		
		//agar mai loop ke bahar agya aur fir bhi mera rootInIndex -1 hi hai to input hi galat hai
		if( rootInIndex == -1) {
			return null;
		}
		
		//muje inorder ke left ka start chahiye
		//muje inorder ke left ka end chahiye
		// muje preorder ke left ka start chahiye
		// muje preorder ke left ka end chahiye and yahi variables muje right keliye bhi chahiye.
		
		//muje overall inorder ka start and end pta hai aur maine root ka index dhund liya hai
		int leftInS = inS ; //left ka inorder start will be jo overall inorder ka start tha wahi
		int leftInE = rootInIndex -1; //left inorder ka end, humne inorder mai jo index dhunde hai usse 1 se kam tak hai inorder ka left
		int rightInS = rootInIndex +1 ; // right ka inorder start hoga: inorder ke root ke index ke just next se
		int rightInE = inE; //right ka inorder bilkul end mai jake khatam hoga so this will be inE
		//inorder ke fill hogye ab preorder ke
		
		//ab muje preorder mai figure out karna hai right kaha se kaha tk hai aur left kaha se kahatk hai
		int leftPreS = preS +1 ; // jo preorder ka overall start tha +1(root) wahise left ka preorder start ho rha hai 
		int leftPreE = leftInE - leftInS + leftPreS ; //left ka preorder keliye inorder ke left ki length nikalte hai aur use yaha use krte hai
		//yaha tak left ka preorder kaha khatam hoga yeh agya
		int rightPreS = leftPreE +1; //right ka preorder waisehi start hojata hai jaisehi left khatam hota hai
		int rightPreE = preE; //jahapr overall preorder end ho rha hai waha right ka preorder end hoga
		
		//agar muje yeh 8 variables mil gye ab mai left generate kar lunga using the same function
		root.left= buildTreeHelper(in, pre, leftInS, leftInE, leftPreS, leftPreE); //input mai in,pre, left ke inorder ka start, left ke inorder ka end, left ke preorder ka start, left ke preorder ka end. And mere pas left aajyega mera. Yeh function choti problem hai recursion apne aap kar dega. Yeh left Tree build krke ayega aur use hum root ke left mai attach ka denge.
		
		//same function for generating right
		root.right= buildTreeHelper(in, pre, rightInS, rightInE, rightPreS, rightPreE);
		
		
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

		//do arrays input dena hai, inorder and preorder
		int in[]= {4,2,5,1,3,7};
		int pre[]= {1,2,4,5,3,7};
		BinaryTreeNode<Integer> root= buildTree(in, pre);
		printTree(root);
	}

}

Output:

1L:2,R:3
2L:4,R:5
4
5
3R:7
7
