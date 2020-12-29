import java.util.Scanner;

public class BinaryTreeInput {

	//hum Scanner sath mai pass karenge jaise Trees mai kiya coz I don't want ki har recursion call mai dubara dubara Scanner ban rha ho so we'll just pass one Scanner
	public static BinaryTreeNode<Integer> takeInput( Scanner s){
		
		//hum aate hi root ka data input lenge
		int rootData;
		System.out.println("Enter the root data");
		rootData= s.nextInt();
		
		//ab assume krte hai ki agar user ko input nhi dena hai to -1 de dega, agar woh chahta hai ki muje null tree banana hai jisme ek bhi node nhi hai to woh muje shuru mai -1 de dega
		if( rootData  == -1) { //this is basecase
			return null;
		}
		// if this is not the case then rootData use krke apna BinryTreeNode banaunga jo root hoga
		BinaryTreeNode<Integer> root= new BinaryTreeNode<>(rootData); //ek object bana liya jisko mai root bol rha hu, rootData ko use krke maine apna root object bana liya
		
		//Tree ke case hum yaha puchte the root ke kitne children hai but yaha to do hi children ho skte hai usse jada nhi ho skte, isliye hum yaha ek bar left child keliye aur ek bar right child keliye takeInput call kar denge
		//ab muje root ke left mai kuch lagana hai, isliye root keliye takeInput call karenge and Scanner bhejenge
		root.left= takeInput(s);
		root.right= takeInput(s); //right keliye bhi takeInput call karenge aur Scanner pass karenge.
		
		//last mai root return karenge
		return root;
	}
	
	public static void printTree( BinaryTreeNode<Integer> root) {
		
		if( root == null) { //this is my basecase, coz hum yaha left pe bhi call karre and right pe bhi
			return ;
		}
		
		//ab ek string banayenge aur data String mai dalenge
		String toBePrinted=  root.data+ ""; //isko string mai convert karnekeliye msine empty String append kardi
		
		//agar left hai to mai print wali jo string hai usme append karenge "" + root ke left ka data
		if( root.left != null) { //agar root ka left null nhi hai
			toBePrinted += "L : " + root.left.data + ",";
		//agar root ka left null hua to mai iss if ke andar nhi jaunga aur mai attach karneki koshish nhi karunga isko
		} //exactly aisehi right wale ke sath
		
		if( root.right != null) { //agar root ka right null nhi hai
			toBePrinted += "R: " + root.right.data ;
		}
		
		//ab mai isko print kar dunga
		System.out.println(toBePrinted); //iss line mai humne first root ke bare(1: L2, R3) mai print kiya ab iske bad muje recursively aage print karna hai
		
		//ab hum left and right pe recusrion karenge and unko unka kam karne bolenge, hume tension nhi leni hai coz recursion humara dhyan rakhega, humne basecase ka dhyan rakha hai, ek step humne dhyan se karliya hai ab jo smaller proble hai woh recursion apne aap dekh lega
		printTree(root.left);
		printTree(root.right);	
	}
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		BinaryTreeNode<Integer> root= takeInput(s);
		printTree(root);
		
		s.close(); //pura kam hogya to hum Scanner ko close kr skte hai
	}

}
