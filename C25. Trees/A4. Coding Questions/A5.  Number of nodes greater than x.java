Code : Number of nodes greater than x

Given a tree and an integer x, find and return number of Nodes which are greater than x.

Input format :
Single Line : First Integer denotes x and rest of the elements in level order form separated by space. Order is - 
Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output Format :
Count of nodes greater than x

Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5

Code:

package Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfNodesGreaterThanX {

	public static int numNodeGreater(TreeNode<Integer> root, int x) {

		if (root == null) {
			return 0;
		}

		int count = 0;

		for (int i = 0; i < root.children.size(); i++) {

			count += numNodeGreater(root.children.get(i), x);
			// System.out.println(root.data +" Inside "+count);
		}

		if (root.data > x) {

			return count + 1;
		}

		return count;
	}

	public static TreeNode<Integer> takeInputLevelWise() {

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the root data");
		int rootdata = s.nextInt();

		QueueUsingLL<TreeNode<Integer>> pendingNode = new QueueUsingLL<>();

		TreeNode<Integer> root = new TreeNode<Integer>(rootdata);

		pendingNode.enqueue(root);

		while (!pendingNode.isEmpty()) {

			try {

				TreeNode<Integer> frontNode = pendingNode.dequeue();// front ko bahar nikalenge

				System.out.println("Enter the number of children of" + frontNode.data);

				int numChildren = s.nextInt();

				for (int i = 0; i < numChildren; i++) {

					System.out.println("Enter the " + (i + 1) + "th child of " + frontNode.data);

					int child = s.nextInt();

					TreeNode<Integer> childNode = new TreeNode<>(child);

					frontNode.children.add(childNode); // Connected frontNode(parent) to childNode(children)

					pendingNode.enqueue(childNode);// child ko queue mai dala

				}

			} catch (QueueEmptyException e) {

				// SHouldn't come here
				return null;
			}

		}
		return root;
	}

	public static void printLevelWise(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<>();

		queue.add(root);
		queue.add(null);

		while (!queue.isEmpty()) {

			TreeNode<Integer> frontNode = queue.poll();

			if (frontNode == null) {

				System.out.println();

				if (!queue.isEmpty()) {

					queue.add(null);
				}
			}

			else {

				System.out.print(frontNode.data + " ");

				for (int i = 0; i < frontNode.children.size(); i++) {

					queue.add(frontNode.children.get(i));
				}
			}
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int x = s.nextInt();
		TreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		int count = numNodeGreater(root, x);
		System.out.println(count);
	}

}
