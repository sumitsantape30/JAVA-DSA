package InsertNode;

import java.util.Scanner;

public class LinkedListUse {
	
	public static Node<Integer> takeInput(){
		
		Node<Integer> head= null, tail= null;
		
		Scanner s=new Scanner(System.in);
		int data= s.nextInt();
		
		while(data != -1) {
			
			Node<Integer> newNode= new Node<Integer>(data);
			
			if(head== null) {
				head= newNode;
				tail= newNode;
			}else {
				
				tail.next= newNode;
				tail= tail.next;
			}
			data= s.nextInt();
		}
		return head;
	}
	
	
	public static Node<Integer> insert(Node<Integer> head,int data,int pos){ //input mai list ka head milega, konsi list mai insert karna hai, kya data insert karna hai aur konsi position pe insert karna hai. 
		
		//jis data ko insert karna hai uske corresponding ek node banana padega.
		Node<Integer> newNode= new Node<Integer>(data);
		
		if(pos==0) {
			newNode.next= head;
		      return newNode;	//agar 0th position pe insertion kr rhe hai to head update hona chahiye
		}
		
		//iss node ko insert karne keliye muje jis position pe insert karna hai uske ek pehle wale element tak pahuchna hai
		int i=0;//sabse first node ka index zero hai, so i ko zero se start kr rhe hai
		
		Node<Integer>temp =head; //ek ek krke aage badhenge, head zeroth position ke corresponding hai to i zero pe hai to temp bhi head pe hai abhi, fir hum temp ko ek ek krke move karenge
		
		while(i< pos-1) { //jabtak temp pos-1 pe nhi pohochta tabtak age badhta rehna hai, means jabtak 'i' pos-1 index pe nhi pohochta
			
			temp= temp.next;// hume temp ko pos-1 position pe leke ana hai taki new node ke sath link kar paye
			i++;
		} //while loop ke bad mera temp jis pos pe insert karna hai uske thi ek pehle(pos-1) index pe agya
		
		//so, jis data ko insert karna tha uske corresponging jo node banaye the uske next mai temp ke next mai jo node hai usko dalna hoga
		//link directly todne se pehle usko kisike sath likh krdo so that wo lost na hojaye
		newNode.next= temp.next;
		temp.next= newNode;
        return head;
		
        //agar pehlehi temp ke next mai new node dala to pehle jo element temp ke next mai tha uspe pahuch nhi payenge so  pahle jo element temp ke next mai hai usko newNode ke next mai dalo and then newNode ko temp ke next mai dalo(open book for clear)
	
	}
	
	public static void print(Node<Integer> head) {
		
		while(head != null) {
			System.out.print(head.data+" ");
			head= head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		
		Node<Integer> head= takeInput();
		head= insert(head,80,0); //agar 0th position pe insertion hua to head update hona chahiye, agar update nhi kiya to niche wala print() fucntion jo main wala head hai wahi input lega.
		print(head);
	}

}
		
		
		
