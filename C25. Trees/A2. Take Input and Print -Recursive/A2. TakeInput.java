import java.util.Scanner;

public class TakeInput {

	//yeh function mere liye TreeNode return karega
	public static TreeNode<Integer> takeInput(Scanner s) { //humara takeInput scanner input lega
		int n;
		
		//Scanner s= new Scanner(System.in); agar scanner yaha rakha to woh har call ke sath scanner bana rha hai aur fir hume input one by one dena hoga hum directly ek isme input nhi de skte, isliye hum har bar Scanner nhi banayenge so ek hi Scanner banaya jo main mai hai
		
		System.out.println("Enter next node data"); //user keliye print karre
		
		n = s.nextInt(); //yeh humare root ka data hai
		
		//so creating a TreeNode(root) corresponding to root ka data
		TreeNode<Integer> root = new TreeNode<Integer>(n);
		
		//humare pas ab root aa chuka hai, ab hum puchenge uss root data ke kitne childrens hai
		System.out.println("Enter number of children for " + n);
		int childCount = s.nextInt();
		
		//child count milgya ab mai ek ek karke har ek child keliye takeInput() call kardunga
		for (int i = 0; i < childCount; i++) {
			TreeNode<Integer> child = takeInput(s);
			// jo yeh child aya hai, uss chote wale tree ka jo root hai woh humare main root ka child hai 
			root.children.add(child);
		}
		return root; //hum tree ka root return kar denge
	}

	
	public static void print(TreeNode<Integer> root) { //input tree ka root milega and woh isko print karega
		
		//ek string bana rhe jisme root ka data dalte hai
		String s = root.data + ":"; //root ke data ke bad colon : print karna hai
		
		//ab hume ek ek karke har ek child pe jana hai, and 's' ke andar jo yeh childrens hai uska data 's' ke sath append karna hai plus hume ek comma(,) lagana hai
		for (int i = 0; i < root.children.size(); i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		
		//Now we will go back to each child and call print on it
		for (int i = 0; i < root.children.size(); i++) {
			print(root.children.get(i));
		}
	}

	public static void main(String[] args) {
		Scanner s= new Scanner(System.in); //Scanner hum yaha rakhenge so that ek hi isme input de skte, hum takeInput mai Scanner pas karenge
		//humne main  ke andar ek Scanner banaya wahi scanner input de diya ab woh har call ke andar same hi scanner use karra woh humesha naya scanner nhi bana rha 
		
		
		//we'll call takeInput and woh mujhe root lake dega uss tree ka
		// takeInput function muje TreeNode lake dega and mai usko root nam ke variable mai store karunga
		TreeNode<Integer> root = takeInput(s);
		print(root);
	}

}
