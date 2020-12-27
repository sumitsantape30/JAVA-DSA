package StackUsingLL;

import java.util.Stack;

public class StackInCollections {

	public static void main(String[] args) {
 
		//<Integer> kind of data, we want to insert in the stack
		Stack<Integer> stack= new Stack<>();// this will create a stack for us
		
		//ek array lete hai and yeh elements ek ek karke stack mai insert karenge
		int arr[]= {5,2,8,1};
		
		//Pushing and popping array elements
		for(int i=0;i< arr.length;i++) {
			stack.push(arr[i]);
		}
		
		//array ke elements stack mai dalne ke bad we'll remove it
		while(!stack.isEmpty()) { //jabtak stack khali nhi hota hai tabtak pop krte rahenge
			
//			System.out.print(stack.peek()); //to read what topmost element is 
//			stack.pop();
			
			System.out.println(stack.pop()); //jo element delete karre woh print bhi karre
        //stack mai array elements add karne ke bad bottom pe 5 hoga and stack ke top 1 hoga, fir delete krte waqt jo top pe hai means 1 delete hoga, so pop krne ke bad 1 pehle print hoga		
		}
	}

}
