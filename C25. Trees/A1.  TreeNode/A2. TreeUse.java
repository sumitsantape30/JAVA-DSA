
public class TreeUse {

	public static void main(String[] args) {

		TreeNode<Integer> root= new TreeNode<Integer>(4); 
		TreeNode<Integer> node1= new TreeNode<Integer>(2); 
		TreeNode<Integer> node2 = new TreeNode<Integer>(3); 
		TreeNode<Integer> node3= new TreeNode<Integer>(5); 
		TreeNode<Integer> node4= new TreeNode<Integer>(6); 
		
		root.children.add(node1);//root ke andar jo arraylist(us arraylist ka nam chidren hai) hai usme node1 add kr rhe h means root ka node1 child hai
		root.children.add(node2); 
		root.children.add(node3);
       //yaha tak 2,3,5 humne 4 ke children(ArrayList) mai add kardiye
		
		node2.children.add(node4); //node2 ke pas jo arraylist hai usme hum node4 ko dal rhe hai
		
	}

}
