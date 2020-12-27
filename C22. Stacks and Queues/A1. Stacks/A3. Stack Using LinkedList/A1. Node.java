package StackUsingLL;

//hum linked list ki bat kar rhe hai means node plays a imp role so node lagega hume, and humne generic banaya hai
public class Node<T> {
	
	T data;
	Node<T> next;
	
	 Node(T data){
		 this.data= data;
		 next= null;
	 }

}
