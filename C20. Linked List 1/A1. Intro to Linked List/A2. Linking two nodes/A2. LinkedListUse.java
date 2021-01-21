package LinkedList;

public class LinkedListUse {

	public static void main(String[] args) {

		Node<Integer> node1= new Node<Integer>(10); //iss statement se new krte hi memory mai ek node bana jiska data 10 hai and next null hai, jo node memory mai bana us node ka reference "node1" hai, and jis address pe woh node bana let's say @150 hai 
		
		System.out.println(node1.data);
		System.out.println(node1.next);
		
		Node<Integer> node2=new Node<Integer>(20); //yeh line ek aur linkedlist ka node bana degi mere liye jiska data 20 hoga and next null hoga and iska ek reference hoga, "Node2" jo memory mai bane hue node ko refer kar rha hai. and iss node ka address let's say @250 hai.
		
		//ab mai chahta hu jo two node banaye unka mai link banadu
		//agar node1 ke next mai null ki jagah node2 ka address/reference aa jaye to link ban jayegi ki 10 ke bad 20 pe jana hai
		node1.next= node2; //node1 ki next mai 2nd wale node ka reference dalna chahiye for linking, so second node ka reference "node2" ke pas hai
		
		System.out.println(node2); //yeh and iske niche wala same address print karenge coz node2 refrence hai node ka and node1 ka next node2 ko refer kr rha hai
		System.out.println(node1.next); 
		
		}

}

Output:
10
null
LinkedList.Node@15db9742
LinkedList.Node@15db9742
