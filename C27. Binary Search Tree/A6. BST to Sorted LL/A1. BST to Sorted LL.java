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

import java.util.LinkedList;
import java.util.Queue;

// mai sirf integer data keliye hi bana rha hu so generic nhi rakh rhe
// user se hume sirf data hi milega aur hume operation apne tree pe means root pe karne hai so helper function us karne honge to pass the root also
public class BinarySearchTreeClass {

	private BinaryTreeNode<Integer> root; //hum sare operations internally binary tree node hi use karke karenge.

	public void deleteData(int data) {
		root = deleteData(root, data); // ho skta hai ki root change hojaye (e.g. single node hai jisme 5 hai aur 5 muje 5 ko hi delete karna hai, to mai delete karne ke bad root null hojayega to muje root ko update karna padega.) (eg. aisa bhi ho skta hai suppose do node ka tree hai usme 5 root hai and 4 root ka child aur muje root ko means 5 ko delete karna hai, delete karne ke bad mera root change hoga, mera root ab 4 hai woh ab 4 ko point karega so root update karna padegaa)
	}

	private BinaryTreeNode<Integer> deleteData(BinaryTreeNode<Integer> root, int data) {
		if (root == null) { //agar root null means tree khali hai to kuch hai hi nhi delete karne keliye so return null.
			return null; 
		}

		if (data < root.data) { //jo data delete karna hai agar woh root ke data se chota hai left mai call karenge
			root.left = deleteData(root.left, data);
			return root;

		} else if (data > root.data) { //jo data delete karna hai, agar woh root ke data se bada hoga to right mai call karenge.
			root.right = deleteData(root.right, data);
			return root;
		} else {//jab data root se bada aur chota dono nhi hai, data root ke equal hai means we need to remove root
			// root.data== data --> we need to remove our root itself
			
			if (root.left == null && root.right == null) { //agar root ka left and right dono null hai aur hum root kohi delete kar rhe hai to null return karenge
				return null;
			} else if (root.left == null) { // ab dono null nhi hai sirf left wala null hai to hum root ko chhodke(delete karna hai root) right wala return kr denge
				return root.right;
		
			} else if (root.right == null) { //dono null nhi hai sirf right null hai to hum root ko chhodke left side return kar denge
				return root.left;
				
			} else { //agar dono null nhi hai aur hume root delete karna hai to hume root ki replacement dhundni hai, humne decide kiya tha agar right side ka mai minimum leke aau to muje replacement mil jayegi.
				//ek BST mai minimum dhundne keliye hume sare node pe jane ki jarurat nhi hoti hai
				//suppose hum sbhi root pe hai uske right side mai sabkuch bada hoga so right side mai mat jao left side pe jao. Agar left nhi hai then root is the minimum. Agar left hai to left chale jao. Ab left mai first node pe aagye to uske left pe chale jao, then us node pe aagye iske right mai jake fayda nhi so agar left hai to left pe chale jao warna node answer hai so basically root se minimum chahiye to left left left jate raho till the point jiska left na ho aage, jaisehi uska left nhi hai to wahi humara minimum hojayega hum right mai nhi ja skte coz right mai gye to badhega
				//Basically we need to find the minimum, iske liye recusrion use nhi krte aisehi dhundte hai minimum. Right side pe dhundna haiand right side ka sabse minimum hoga woh humara root hoga
				
				BinaryTreeNode<Integer> minNode = root.right; // root ke right ko minimum man lete hai

				while (minNode.left != null) { //humne right ko minimum man liya tha ab hum us right ke left mai travel karenge jabtak left nhi ho jata
					minNode = minNode.left; //right ke left left left mai jate rahenge to get most minimum
				} //jab yeh while loop khatam hoga humare pas left side mai aisa node agya hai jiska left null hai means apne pas minimum value hai
				
				root.data = minNode.data; //ab root ka data change karke jo minimum wale node ka data hai usko root banayenge
			   
				//humara jo minNode ka data tha usko root bana diya. aur right side mai wahi node tha so usko delete karna padega kyuki usko root bana diye so right side pe delete call karenge
				root.right = deleteData(root.right, minNode.data); //agar 3 node ka tree hai aur hume root delete karna hai, jo right side ek hi element hai wahi mimimum hoga so woh root banega. Ab right wale ko delete karne ke bad null return karega so woh null root ke right mai attach karna padega
				return root;
			}
		}
	}

	public void print() { //yeh print function call krte waqt user input nhi dega so hum helper function banayenge and tree ka root input denge
		printTree(root);
	}

	private void printTree(BinaryTreeNode<Integer> root) {

		if (root == null) {

			return;
		}

		String toBePrinted = root.data + ":";

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

	public void insertData(int data) {
		root = insertData(root, data); 
		//niche code mai agar mera root null(means tree hai hi nhi) hai to mai naya newNode banakr return kr rha hu so muje
		// old data member(root) ko naye root (newNode) ko assign kar dena chahiye
	}

	//hum return isliye kar rhe hai coz there's possibility that root will change means agar initially agar humara root null hai to insert karne ke bad humara root change hone wala hai
	private BinaryTreeNode<Integer> insertData(BinaryTreeNode<Integer> root, int data) {
		if (root == null) { //agar root null(means Tree hi nhi hai so create karenge) hai to i'll create binaryTreeNode and usme woh data dalke return karenge.
			BinaryTreeNode<Integer> newNode = new BinaryTreeNode<>(data);
			return newNode;
		}
        
		//agar root null nhi hai to I need to figure out ki left mai insert karu ya right mai insert karu
		if (root.data > data) { // agar mera root ka data bada hai data se to mai left side mai insert karunga. agar left ka root null hua to left ka root change hojayega, mai root mai jo bhi ayega recusrio ke bad usko lagaunga
			root.left = insertData(root.left, data);

		} else { // agar root ka data less than or equal hai data(jise insert) karna hai usase to right mai call karenge.
			root.right = insertData(root.right, data);
		}
		return root; //jo root aya tha wahi return kardiya I changed my root in only one case, when root was null(basecase wala) usme maine naya banake return kardiya hai baki case mai root waisaka waisa return ho rha hai
	}

	// hasData means Search, whether that data is there or not
	public boolean hasData(int data) { //hume koi root pass nhi kr rha bas data pass kr rha hai obviously user data hi dega aur apne pas root ka access hai so helper function banake root bhi pass karenge.
		
		return hasDataHelper(data, root); // this root is data memeber (which is at top)
	}

	private boolean hasDataHelper(int data, BinaryTreeNode<Integer> root) { // this root is localvariable
		
		if (root == null) { //agar tree khali hai means koi data hi nhi hai tree mai isliye false return karenge
			return false;
		}

		if (root.data == data) { //jo data hume check kaarna hai ki tree mai hai ya nhi, agar woh root pehi milgya to hum true return kardenge
			return true;
		
			//agar root pe nhi hai woh data to hum left aur right pe call karenge, yeh BST hai so left mai karna hai ya right mai decide kr skte but agar sirf binary tree hota to dono side mai karnahi padta call
		} else if (data > root.data) { 
			// agar woh data mere root ke data se bada hai to right side mai call karenge
			return hasDataHelper(data, root.right);
			
		} else {

			return hasDataHelper(data, root.left);// call left
		}
	}
}
