package QueueUsingLL;
import java.util.LinkedList;
import java.util.Queue;


public class QueueInCollection {

	public static void main(String[] args) {

		//Queue is an Interface, it has certain methods which has to be implemented
		//Because Queue is an interface we cannot create object of interface but we can create the references
		//we can make this reference point to the object of linked list class (LinkedList class mai queue implement kara hua hai)
		// so we can just make object of linkedlist class and make this reference of queue point that linkedlist class
		Queue<Integer> queue= new LinkedList<>();
		
		//the commonly used function that we except a queue to have are
		queue.add(10); //to insert an element into the queue we have .add instead of Enqueue()
		queue.add(20); 
		System.out.println(queue.peek());//To print the front element of the queue
		System.out.println(queue.poll()); // To remove an element from the queue
		System.out.println(queue.size());
	
//Queue is an interface so we will have to implement it so either we can create our class which can implement the every function of the queue but that will be unwanted coz we'll have to write implementtion ourselves so if you want to skip that we use linkedlist class.
// Why we are able to use linkedlist class? beacause linkedlist class has implemented this interface already for us so we can straight away write something like this -	Queue<Integer> queue= new LinkedList<>(); and then can use the normal functions that we want to, we can use add, we can use peek, poll
	}

}
