Code: BST to Sorted LL

Given a BST, convert it into a sorted linked list. You have to return the head of LL.

Input format:
The first and only line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.   
Output Format:
The first and only line of output prints the elements of sorted linked list.

Constraints:
Time Limit: 1 second

Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
Sample Output 1:
2 5 6 7 8 10

Code:

package BinarySearchTree;

class Pair1<T1 , T2>{
	T1 head;
	T2 tail;
	
	public Pair1(T1 head, T2 tail) {
		head= head;
		tail= tail;
	}
}

public class BSTToSortedLL {
	
	public static Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>>  BSTToSortedLL2(BinaryTreeNode<Integer>root){
		
		if(root == null) {
			Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> ans= new Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>>(null,null);		
			return ans;
		}
		
		Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> rhs= BSTToSortedLL2(root.right);
		Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> lhs= BSTToSortedLL2(root.left);
		
		LinkedListNode<Integer> rootNode = new LinkedListNode<Integer>(root.data);
		
		if(lhs.tail !=null) {
			lhs.tail.next= rootNode;
		}else {
			
			lhs.head= rootNode;	
		}
		
		if(rhs.head != null) {
		 rootNode.next= rhs.head;
		}
		
		Pair1<LinkedListNode<Integer>, LinkedListNode<Integer>> ans= new Pair1 <LinkedListNode<Integer>, LinkedListNode<Integer>>(lhs.head, rhs.tail);
		return ans;
	}
	
	public static LinkedListNode<Integer> BSTToSortedLL( BinaryTreeNode<Integer> root){
		
		return BSTToSortedLL2(root).head;
	}
	
	
	public static void main(String[] args) {
    
	}

}

