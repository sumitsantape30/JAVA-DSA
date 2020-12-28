package QueueUsingArray;

public class DynamicQueue {
	
	private int data[];
	//I also want rear and front where I'll be deleting and inserting element s
	private int front; // Index at which front element is stored
	private int rear; //Index at which rear element is stored
	private int size;
	
	public DynamicQueue() {
		data= new int[10];
		front= -1;
		rear= -1;
		size= 0;
	}
	
	public DynamicQueue(int capacity) {
		data= new int[capacity];
		front= -1;
		rear= -1;
		size= 0;
	}
	
    int size() {
    	return size;
    }
    
    boolean isEmpty() {
    	return (size==0);
    }
    
    int front() throws QueueEmptyException {
    	
    	if(size ==0) {
    		QueueEmptyException e= new QueueEmptyException();
    		throw e;
    	}
    	
    	return data[front];
    }
    
    int rear()throws QueueEmptyException {
    	
    	if(size ==0) {
    		QueueEmptyException e= new QueueEmptyException();
    		throw e;
    	}
    	return data[rear];
    }
    
    void enqueue(int element) throws QueueFullException {
    	
    	if(size== data.length) {
//    		QueueFullException e= new QueueFullException();
//    		throw e;
    		
    		//agar queue full hogya hai to hum exception throw nhi karenge hum array ki capacity double karenge 
    		doubleCapacity();
    	}
    	
    	if(size==0) {
    		front=0;
    	}
    	size++;
    	//rear= (rear+1) % data.length;
    	rear++;                      
    	if(rear== data.length) {  // Circular queue coz aage nhi badh pa rhe to aage ajao
    		rear= 0;
    	}
    	
    	data[rear]= element;
    	
    }
    
    private void doubleCapacity() {
    	//agar humne as it is copy kiya to sab clumsy hojayega so hume uss order mai arrange karna chahiye jis order mai initally aye hai.
    	
    	int temp[]= data; //temp mai hum purana array store karre
    	data= new int[2* temp.length]; //double size ka data array banare
    	// ab hume copy karneka kam karna hai, hum front se copy karenge coz pehle front wala element aya 
    	int index= 0; //yeh data array ka index hai, jo double size ka banaye the woh
    	for(int i=front;i <=temp.length;i++) { //new data array mai hum front se element copy karenge coz wahi pehle aye hai queue mai
    		data[index]= temp[i]; 
    		index++;
    	}
    	//array full hone ke bad jo elements add kiye the woh circular queue se 0th index se add hue honge so 0th index se leke front se ek kam element tak copy karenge coz front se aage wale already copy kar chuke hai
    	for(int i=0;i <= front-1;i++) {
    		data[index]= temp[i];
    		index++;
    	}
    	
    	//values rearrange hone ke bad double size array mai front 0th index pe rahega and rear sabse last means temp array ke length-1 index pe rahega
    	front= 0;
    	rear= temp.length-1;
    	
    	//humne, jis order mai aye the wahi order mai copy kiye bas 	
    }
    
    int dequeue() throws QueueEmptyException {
    	
    	if(size==0) {
    		QueueEmptyException e= new QueueEmptyException();
    		throw e;
    	}
    	
    	int temp = data[front];
    	front++;
    	
    	if(front== data.length) { // Circular queue coz aage nhi badh pa rhe to aage ajao
    		front= 0;
    	}
    	
    	size--;
    	if(size== 0) {
    		front = -1;
    		rear= -1;
    	}
    	return temp;
    }
    
}
