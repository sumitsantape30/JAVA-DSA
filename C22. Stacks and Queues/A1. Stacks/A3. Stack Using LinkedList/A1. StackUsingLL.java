Code : Stack Using LL

Implement a Stack Data Structure specifically to store integer data using a Singly Linked List.
The data members should be private.

You need to implement the following public functions :
1. Constructor:
It initialises the data members as required.
2. push(data) :
This function should take one argument of type integer. It pushes the element into the stack and returns nothing.
3. pop() :
It pops the element from the top of the stack and in turn, returns the element being popped or deleted. In case the stack is empty, it returns -1.
4. top :
It returns the element being kept at the top of the stack. In case the stack is empty, it returns -1.
5. size() :
It returns the size of the stack at any given instance of time.
6. isEmpty() :
It returns a boolean value indicating whether the stack is empty or not.

Operations Performed on the Stack:
Query-1(Denoted by an integer 1): Pushes an integer data to the stack.
Query-2(Denoted by an integer 2): Pops the data kept at the top of the stack and returns it to the caller.
Query-3(Denoted by an integer 3): Fetches and returns the data being kept at the top of the stack but doesn't remove it, unlike the pop function.
Query-4(Denoted by an integer 4): Returns the current size of the stack.
Query-5(Denoted by an integer 5): Returns a boolean value denoting whether the stack is empty or not.

Input Format:
The first line contains an integer 'q' which denotes the number of queries to be run against each operation in the stack. 
Then the test cases follow.
Every 'q' lines represent an operation that needs to be performed.
For the push operation, the input line will contain two integers separated by a single space, representing the type of the operation in integer and the integer data being pushed into the stack.
For the rest of the operations on the stack, the input line will contain only one integer value, representing the query being performed on the stack.

Output Format:
For Query-1, you do not need to return anything.
For Query-2, prints the data being popped from the stack.
For Query-3, prints the data kept on the top of the stack.
For Query-4, prints the current size of the stack.
For Query-5, prints 'true' or 'false'(without quotes).

Output for every query will be printed in a separate line.

Note:
You are not required to print anything explicitly. It has already been taken care of. Just implement the function.
 Constraints:
1 <= q <= 10^5
1 <= x <= 5
-2^31 <= data <= 2^31 - 1 and data != -1

Where 'q' is the total number of queries being performed on the stack, 'x' is the range for every query and data represents the integer pushed into the stack. 

Time Limit: 1 second
Sample Input 1:
6
1 13
1 47
4
5
2
3
Sample Output 1:
2
false
47
13

Sample Input 2:
4
5
2
1 10
5
Sample Output 2:
true
-1
false

Explanation of Sample Input 2:
There are 4 queries in total.
The first one is Query-5: It tells whether the stack is empty or not. Since the stack is empty at this point, the output is  'true'.
The second one is Query-2: It pops the data from the stack. Since at this point in time, no data exist in the stack hence, it prints -1.
The third one is Query-1: It pushes the specified data 10 into the stack and since the function doesn't return anything, nothing is printed.
The fourth one is Query-5: It tells whether the stack is empty at this point or not. Since the stack has one element and hence it is not empty, false is printed.

Code:

package StackUsingLL;


//hum linked list ki bat kar rhe hai means node plays a imp role so node lagega hume, humne node generic mai banaya hai so StackUsingLL bhi hume generic lena hoga
public class StackUsingLL<T> {
 
	//hume yaha data[] array ki jarurat nhi hai hum head rakhenge coz head sehi insertion aur head sehi deletion karenge, hum linkedlist ki chain banake rakh rhe honge so top index ki bhi jarurat nhi hai. Head hi humare liye top ka kam karega aur linkedlist ki chain bhi maintain karega
	private Node<T> head; 
	private int size; //then hume stack ka size rakh lena chahiye array ki case mai size rakhne ki jarurat isliye nhi thi kyuki waha top se figure out kar rhe the, hum yaha size variable rakh rhe jab bhi hum push karenge means koi element insert karenge to size++ and pop kiye to size-- karenge.
	
	
	public StackUsingLL() { //StackUsingLL class ke corresponding constructor banayenge. Jab iss class ka object banayenge to intially list mai kuch nhi rahega.
		head= null;
		size= 0;
		//yeh dono statements nhi likha tobhi chalta coz by default non premitives datamemeber null se initialize hota hai and premitives integer hai to zero se initialise hota hai
	}
	
	int size() { //stack ka size
		return size;
	}
	
	boolean isEmpty() { //agar stack ka size zero hoga to Empty hoga
		
		return size() == 0; // head== null- agar head null hoga tobhi Empty hoga to hum yeh bhi use krs kte hai
	}
	
	
	T top() throws EmptyStackException { //stack ka topmost element read karna hai muje to woh head ka data return karega and node mai <T> type ka data  rahega na so wahi type ka data return karenge
		
		if(size()==0) { //khali stack ka top koi access karneki koshish na kare so throw exception
			// EmptyStackException e= new EmptyStackException
			// throw e
			throw new EmptyStackException();
		}
		
		return head.data; // We are adding elements to the starting so top will be head
	}
	
	//hume element push karte waqt, jis element ko insert karna hai usko node banayenge and uss newNode ke next mai head attach kar denge and fir head ko update kar denge.
	void push(T element) { //kya element push karna hai woh input mai rahega and woh T type ka data hi input lega.
       
		Node<T> newNode= new Node<T>(element);
		newNode.next= head; //jis element ko insert karna hai uske node ke next mai head attach karre
		head= newNode;
		size++; //humne ek element/node/data insert kiya hai so size  ko badhana padega.
	}
	
	//stack se kuch pop karna hai, stack se head hi pop hoga coz last time jo element add hua tha woh head hi hai
	T pop() throws EmptyStackException { // we will be returning the value that is popped so that will be of type T
		
		if(size()==0) { //agar stack khali hai ya head null hai to exception throw karenge coz exception throw nhi kiya to head.data nullpointer exception throw karega kyuki head null hoga
			// EmptyStackException e= new EmptyStackException
			// throw e
			throw new EmptyStackException();
		}
		//pop karna hai to head pe jo node rakha hai wahi pop hoga, head pe rakha hai element matlab pop hone ke bad head ko update karna padega
		T tempdata= head.data;// jo node pop karre woh return bhi karna hai isliye tempdata mai store karre
		head= head.next;
		size--; //ek element humne stack se remove kiya so size kam karenge
		return tempdata;

	}

}
