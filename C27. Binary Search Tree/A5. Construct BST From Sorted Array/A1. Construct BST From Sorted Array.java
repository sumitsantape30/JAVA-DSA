Code: Construct BST From Sorted Array

Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.
Note: If array size is even, take first mid as root.

Input format:
The first line of input contains an integer, which denotes the value of n. The following line contains n space separated integers, that denote the values of array.
Output Format:
The first and only line of output contains values of BST nodes, printed in pre order traversal.

Constraints:
Time Limit: 1 second

Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7 

Code:

package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConstructBSTFromSortedArray {
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int arr[], int sI, int eI){
		if(sI > eI) {
			return null;
		}
		
		//firstly we'll go to middle and middle kohi root banayenge coz mid is easily asscessible element
		int mid= (sI + eI)/2;
	
		BinaryTreeNode<Integer> root= new BinaryTreeNode<>(arr[mid]);
		
		//we have the root now we need to find left and right, left lane keliye array mai mid-1 tak recursion call karenge and same with right and unko root mai dalegne aur end mai root return kar denge
		 root.left= SortedArrayToBST(arr,sI, mid-1);
		 root.right= SortedArrayToBST(arr, mid+1, eI);
		 
		 return root;
		
	}
	
	public static BinaryTreeNode<Integer> SortedArrayToBST(int arr[]){ //user se sirf array lenge and use hume Binary Search tree mai construct karna hai
		
		//mid nikalne keliye start index and end index hum humari taraf se input dere so helper function banare
		return SortedArrayToBST(arr, 0, arr.length-1);
		
	}
	
	
	public static int[] takeInput() {
		Scanner s= new Scanner(System.in);
		int n= s.nextInt();
		int arr[]= new int[n];
		
		for(int i=0; i< n ; i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	
	  public static void printLevelWise(BinaryTreeNode<Integer> root) {

			
			Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
			pendingNodes.add(root);
		    pendingNodes.add(null);

			while(!pendingNodes.isEmpty()) {
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
    int input[]= takeInput();
     BinaryTreeNode<Integer> root= SortedArrayToBST(input);
     printLevelWise(root);
	}

}
