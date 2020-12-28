package QueueUsingLL;

// using linkedlist kar rhe hai so generic class rahega, and node ke help se kam kr rhe honge
public class QueueUsingLL<T> {

	//front and rear, do ends hai queue ke, rear pe insertions karenge and front pe deletions so muje front and rear chahiye 
	//front and rear N0de<T> ke references honge, wahi type ke rahenge both
	// bothe of these properties should be private, nobody should have access to this properties other than this class, taki front and rear ke values ko koi change na kr paye
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
