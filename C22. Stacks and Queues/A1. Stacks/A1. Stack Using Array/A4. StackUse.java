package StackUsingArray;

public class StackUse {

	// main mai throws likhne ka matlab console pe dikh jayega
	public static void main(String[] args) throws StackFullException {

		// Naya stack banana matlab StackUsingArray class ka ek object banana.
		StackUsingArray stack = new StackUsingArray();

//		stack.data=100;
//		stack.top= 45;  these both cannot be accessed as these are private coz user can change it, so user ko koi faraq nhi pdta ki stack using array bana hai ki linkedlist isiliye mere stack ke sath koi random changes na kara, isliye nahi array ka access denge nahi top ka access denge sirf un functionalities ka access denge jo hum chahte hai stack ke pas hai

		for (int i = 1; i <= 5; i++) {
			stack.push(i);
		}

		// jabtak stack pura khali nhi hota tabtak pop karenge
		while (!stack.isEmpty())// jabtak stack isEmpty false hai tabtak delete karenge
		{
			try { //muje pta hai yeh exception ke andar mai kabhi jaunga hi nhi kyuki mai tabhi tak kam kr rha hu jabtak stack khali nhi hoga to empty to ho hi nhi skta
				
				System.out.println(stack.pop());
				
			} catch (StackEmptyException e) {
				// will never reach here
			}
		}
	}

}
