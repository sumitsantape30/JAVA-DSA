package LinkedList_Input;

import java.util.Scanner;

public class LinkedListUse {
	
	//return type kya hona chahiye? puri ki puri list input lega aur list lene ke bad agar muje list chahiye woh, uss list ka access chahiye to hum first node ka reference return karenge coz first node ke pas second node ka address hoga, second node ke pas third wale ka and so on, basically hum head return karenge.
	//agar muje kisiko list deni hai input leke to mai use us list ka head de dunga, to agar head de dunge(first node ka reference) to going forward uske pas sare nodes aa jayenge.
	// abhikeliye I am taking input only for list jo integer values leti hai isliye Node<Integer> likha hua hai.
	public static Node<Integer> takeInput(){
		
		//sabse pehle muje head and tail chahiye jo linked list ke first and last element ko point kr rha hoga, abhi kuch input nhi liya hai so null rahenge dono.
		Node<Integer> head = null, tail = null; //hum last node(tail) bhi apne pas rakh rhe hai ki agar element insert karna hai to directly last node ke next mai add kardenge. (pehle hum first index se last tak travel krte the then insert krte the) this will save our time complexity
	
		Scanner s = new Scanner(System.in);
		int data = s.nextInt(); //iss int data se sirf ek hi bar user se data ayega 
		
		//repeatively input lenge so while loop lagayenge, and jabtak user -1 nhi deta tabtak input lete rahenge
		while(data != -1){ 
			Node<Integer> newNode = new Node<Integer>(data);//user sirf data dega but node hume banana hai, so har number input lene ke bad us number ke corresoponding Node banane ka kam humara, so new data input hone ke bad newNode us new input ko refer karega.
			
			//humne head 'first node' reference karne ke keliye banaya tha so first node input anae ke bad woh head ne new node ko point karna chahiye, head null hai matlab ek bhi input nhi aya hai
			if(head == null){ //so ek input ane ke bad us first new Node input ko head bana dena chahiye
				
				//jo first input ayega, wahi head hai and wahi tail hai
				head = newNode; //jo first data ayega uske node ko head banayenge.
				tail = newNode;
		
			}else{ //else pe pahuche means jo input se data aya woh first input nhi hai, to hume us element ko list ke last mai jake insert karna hai
			//last wale node ke next mai hume humara current node insert karna hai
				
				tail.next = newNode;  
				tail = tail.next; //tail= newNode;
			}
			data = s.nextInt(); //if else ke bad next values lene ki jarurat hai, yeh wala bar bar input lega till while loop is completed
		}
		return head;// First node ka reference return karenge then puri list return hogi
	}
	
	public static void print(Node<Integer> head){
		
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
		Node<Integer> head = takeInput();
		print(head);
		
	}

}
