Code : Queue Using LL

Implement a Queue Data Structure specifically to store integer data using a Singly Linked List.
The data members should be private.
	
You need to implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. enqueue(data) :
This function should take one argument of type integer. It enqueues the element into the queue and returns nothing.
3. dequeue() :
It dequeues/removes the element from the front of the queue and in turn, returns the element being dequeued or removed. In case the queue is empty, it returns -1.
4. front() :
It returns the element being kept at the front of the queue. In case the queue is empty, it returns -1.
5. getSize() :
It returns the size of the queue at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the queue is empty or not.

Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Enqueues an integer data to the queue.
Query-2(Denoted by an integer 2): Dequeues the data kept at the front of the queue and returns it to the caller.
Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the front of the queue but doesn't remove it, unlike the dequeue function.
Query-4(Denoted by an integer 4): Returns the current size of the queue.
Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the queue is empty or not.
	
Input Format:
The first line contains an integer 'q' which denotes the number of queries to be run against each operation on the queue. 
Then the test cases follow.
Every 'q' lines represent an operation that needs to be performed.
For the enqueue operation, the input line will contain two integers separated by a single space, representing the type of the operation in integer and the integer data being enqueued into the queue.
For the rest of the operations on the queue, the input line will contain only one integer value, representing the query being performed on the queue.
	
Output Format:
For Query-1, you do not need to return anything.
For Query-2, prints the data being dequeued from the queue.
For Query-3, prints the data kept on the front of the queue.
For Query-4, prints the current size of the queue.
For Query-5, prints 'true' or 'false'(without quotes).

Output for every query will be printed in a separate line.
	
 Note:
You are not required to print anything explicitly. It has already been taken care of. Just implement the functions.
Constraints:
1 <= q <= 10^5
1 <= x <= 5
-2^31 <= data <= 2^31 - 1 and data != -1

Where 'q' is the total number of queries being performed on the queue, 'x' is the range for every query and data represents the integer pushed into the queue. 

Time Limit: 1 second
Sample Input 1:
7
1 17
1 23
1 11
2
2
2
2
Sample Output 1:
17
23
11
-1
	
Sample Input 2:
3
2
1 10
4
Sample Output 2:
-1 
1

Code:

package QueueUsingLL;

// using linkedlist kar rhe hai so generic class rahega, and node ke help se kam kr rhe honge
public class QueueUsingLL<T> {

	//front and rear, do ends hai queue ke, rear pe insertions karenge and front pe deletions so muje front and rear chahiye 
	//front and rear Node<T> ke references honge, wahi type ke rahenge both
	// both of these properties should be private, nobody should have access to this properties other than this class, taki front and rear ke values ko koi change na kr paye
 	private Node<T> front;
	private Node<T> rear;
	// agar size variable nhi rakha to jab bhi Queue ka size chahiye hoga to har bar linkedlist ka length nikal rhe honge, and linkedlist ka length nikalna is O(n) isliye size variable rakhenge, jab bhi queue mai enqueue karenge to size  ko ++ karenge aur dequeue krne ke waqt size -- karenge.
	int size; 	
	
	public QueueUsingLL() {
		//initially jab queue khali hai to  non primitives front and rear null se initialise honga and primitives integer size 0 se initialise hoga
		// agar humne intialise nhi kiya tab bhi koi bhi class mai non primitives data members hai to unki default value null hoti hai, and primitives ki default value 0 hoti hai
		front= null; 
		rear= null;
		size= 0;
	}
	
	int size() { //Queue ka size return karre
		return size;
	}
	
	boolean isEmpty() { //agar queue khali hai means size zero hai to isEmpty true rahega
		return size==0;
	}
	
	//front ka return type Node<T> nhi rahega means agar koi humari queue use kr rha hai to usko pta hai basically ki yeh internally linkedlist wala logic hai
	//mai queque mai ek data dalunga to receive karne ke waqt bhi I should receive data, and data ka type T hai so front ka return type bhi T rahega. (Data input diya hai to data laake do bas), hum Node<T> bas apne queue ko implement karne keliye use kr rhe hai
	T front() throws QueueEmptyException { 
		
		if( size==0) { //agar queue kahli hogi to mera front null pehi rahega so QueueEmptyException throw karenge
			throw new QueueEmptyException();
		}
		
		return front.data; //front will be refering to the front element of the Queue uska data return karenge
	}
	
	//jo bhi enqueue operations hai woh rear end pe honge, initially front and rear dono null rahenge so agar Queue mai first element dal rhe hai to front tab null hi hoga so first wala elements dalne kebad front bhi usiko point karega and rear bhi
	void enqueue(T element) {
		
		//Enqueue kar rhe hai to uss element ke corresponding ek node banana chahiye
		Node<T> newNode= new Node<>(element);
		
		if(rear== null) { //rear null hai matlab puri Queue khali hai aur fist element hum dalne ja rhe hai, so yeh first element hoga to front bhi usko point karega and rear bhi
			front= newNode;
			rear= newNode;
		}else {
			//agar woh first element nhi hai to humne rear end pe insertion karna hi so rear ke next mai hum newNode link kar denge and rear ko update kar denge
			rear.next= newNode;
             rear= rear.next;// rear= newNode; bhi use kr skte
		}
		size++; //enqueue kar rhe hai means ek element queue mai dal rhe hai so size badhana padega
	}
	
	//dequeue front se hoga
	T dequeue() throws QueueEmptyException { //jo element remove karre woh bhi return karenge, uska type T rahega
		
		if( size()==0) {
			throw new QueueEmptyException();
		}
		
		T temp= front.data; //front wala element remove karenge, remove karne ke bad usko return bhi karna hai isliye temp mai store kr rhe hai
		// front ke remove karne ke bad front ko update karne keliye aage move kardena chahiye
		front= front.next;
		
		if(size()==1) { //agar ek hi node bacha hai to front ko front.next karne ke bad front null hojayega but rear wahi rahega so, hum agar last element remove kr rhe hai front to null hogahi but rear kobhi null kardena chahiye
			rear = null;
		}
		
		size--; //remove karne ke bad size kam karni chahiye
		
		return temp;
	}
}
