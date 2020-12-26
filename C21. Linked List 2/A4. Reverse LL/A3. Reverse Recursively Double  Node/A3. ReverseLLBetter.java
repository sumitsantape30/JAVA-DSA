package ReverseLL_Recursive;

import java.util.Scanner;

public class reverse_recursively_double_node {

	public static Node<Integer> takeInput() {
		Node<Integer> head = null, tail = null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();

		while (data != -1) {

			Node<Integer> newNode = new Node<Integer>(data);
			if (head == null) {
				head = newNode;
				tail = newNode;
			} else {
				tail.next = newNode;
				tail = tail.next;
			}
			data = s.nextInt();
		}
		return head;
	}
   
	//humara reversed list ke sirf head se kam nhi ban rha(sirf head rha to list ke end tak pahuchne keliye travel karna pad rha hai), isliye reversed list ka head and tail dono return karayenge but function bas ek hi chiz return kar skta hai so I'm warpping it into a class,then iss class ka object return karwayenge taki un dono properties ka access mil paye
	//so agar kisi function se multiple chize return karwani hai function se to wrapped those things inside a class
	// hume d chize return karni hai so mai ab DoubleNode ka object return karaunga(reference return hoga), so agar woh DoubleNode ke object ka reference return karvaunga to uske pas do chize hogi list ka head and tail
	//DoubleNode type ka return hoga.
	public static DoubleNode reverseLLBetter(Node<Integer> head) {

		if (head == null || head.next == null) {
			//DoubleNOde returned list ka Head and Tail dono store karega
			DoubleNode ans = new DoubleNode(); //DoubleNOde type ka ans		
			ans.head = head; //ans.head means final jo list ban rhi hai uska head kya hoga!? yaha list ka head same hi hoga coz list ki length 0 or 1 hai
			ans.tail = head; //ans.tail bhi head hi hoga
			return ans;
		}
		
		//first element ko chodke baki kam recursion krke lake dega
		DoubleNode smallAns = reverseLLBetter(head.next); //recusive ke bad reversed list ka head aur tail return karega (return type DoubleNode hai so, DoubleNode smallAns liya, iss DoubleNode ke pas reversed list ka head bhi hoga aur reveresd list ka tail bhi hoga)
		smallAns.tail.next = head; //smallAns(reversed list) mai jo tail hoga uske next mai hum jo first element tha usko dalenge.
		head.next = null; //reversed list ke last mai jo element hai uske next mai null dalre

		DoubleNode ans = new DoubleNode(); //DoubleNode ka object bana rhe hai
		ans.head = smallAns.head; // jo reversed list ka head hai(smallAns) woh overall list ka head rahega.
		ans.tail = head; //overall list ka tail head rahega coz usiko piche se join karare

		return ans;
	}

	public static void print(Node<Integer> head) {

		while (head != null) {
			System.out.println(head.data + " ");
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		DoubleNode ans = reverseLLBetter(head);
		print(ans.head);

	}

}

