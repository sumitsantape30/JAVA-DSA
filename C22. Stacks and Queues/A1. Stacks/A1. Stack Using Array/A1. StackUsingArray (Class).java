package StackUsingArray;

public class StackUsingArray { 
     //data memeber private rakhenge taki koi change na kr paye, inka access mai functions ke throguh dunga
	private int data[]; //humne stack array mai rakhne ka decide kiya so obviosuly ek array legega
	private int top;// this is the index of the topmost element of the stack to track ki agar push(10) kiya to konse index pe 10 ko add karna chahiye, top() call kiya to konsa element output dena chahiye yeh track karne keliye top rakhre
	
	public StackUsingArray() { //StackUsingArray ka constructor, jab StackUsingArray ka object banega to apne aap 10 size ka array ban jayega
		data= new int[10];
		top= -1; //jaisehi object banaega to stack initially khali rahega so top ko -1 pe rakh rha hai means stack pura khali hai
	}
	
	public StackUsingArray(int capacity) { //user se puchte hai usko kitni capacity ka array banana hai, upr wale mai by default 10 size ka ban jata tha
		data= new int[capacity];
		top= -1;
	}
	
	
	// static kyu nhi liya? =new stack bana rhe means StackUsingArray class ka ek object bana rhe so do we want ki har stack/object keliye isEmpty() common ho? nhi na har object/stack ka isEmpty function khudka hona chahiye, so yeh shared property nhi hai sare stacks/objects ki so static nhi lenge
	public  boolean isEmpty() { // har stack/object ka apna function hona chahiye jo btayega woh stack empty hai ya nhi so woh shared property nhi saare stacks ki so it wont be static
		
		 //agar top -1 pe hai means mera stack khali hai, coz koi element add hota to top bhi update hota
		//return (top == -1);
		
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	//top array ke index ke corresponding badhega so agar top 0 pe hai means array mai 1 element hai uska size 1 hoga fir
	public int size() { //stack size matlab number of elements in the stack, agar array ka size 10 hai aur maine usme ek hi element dala hai to mere liye stack ka size 1 hai
		return top+1; //agar top 2 pe hai means 0 pe ek element pda hua hai 1 pe ek hai and 2 pe ek element pda hua hai (intially sabse pehle jab stack sirf banna hai tab top -1 hoga uss time stack ka size hoga : top= -1 +1 = zero
	}
	
	public int top() throws StackEmptyException {
		if(size()==0 ) { // or top== -1 can also be used
			// StackEmptyException ka object banake throw karenge
			StackEmptyException e= new StackEmptyException();
			throw e;
		}
		return data[top];
	}
	
	
	//stack mai kuch  element dalna hai to top ko purane index se age bahdhayenge and uss index pe jispe top hai waha array mai element add krdenge
	public void push(int elem)  throws StackFullException  {
		//agar array pura bhar chuka hai to hum ya fir exception throw kr skte hai ya fir array ka size double kar skte hai 
		// check if size of stack is equal to length of an array
		if(size()== data.length) {
//			StackFullException e= new StackFullException();
//			throw e; 

			//To double the stack capacity
			doubleCapacity();	
		}
		
		top++; // top= top+1
		data[top]= elem;
	}
	
	private void doubleCapacity() {
		int temp[]= data;
		data= new int[2* temp.length];
		
		for(int i=0; i<= top; i++) { // array ki size full thi tabhi doubleCapacity call hua means top array ke last index pe hoga so wahatk loop chalare
			data[i]= temp[i];
		}
	}
	
	//pop ka kam hoga jo top pe element rakha hua hai usko remove krde
	//return type int dere means yeh top wala element remove bhi karega and batayega topmost element tha kya jo remove hua
	public int pop() throws StackEmptyException  {// will return the element which is deleted
		//khali stack se delete nhi karega so check size
		if(size()== 0) { //agar stack khali hai to tum kuch pop nhi kr skte
			//Stack Empty
		   StackEmptyException e= new StackEmptyException();
		   throw e; 
		}
		
		int temp = data[top];
		top--;
		return temp;
	}	
}

