
public class BinaryTreeUse {

	//hum jobhi function honge woh BinaryTreeUse mai likhenge BinaryTreeNode class ko use krke.
	public static void main(String[] args) {

		//Binary tree node banate Integer type ka
		BinaryTreeNode<Integer> root= new BinaryTreeNode<Integer>(1);
		BinaryTreeNode<Integer> node1= new BinaryTreeNode<Integer>(2);
		
	   //ab hum node1 ko root ke left mai rakh denge isiliye data memeber public kiya the taki changes kar paye
		root.left= node1;
		
		BinaryTreeNode<Integer> node2= new BinaryTreeNode<Integer>(3);
		root.right= node2;
	
	}

}
