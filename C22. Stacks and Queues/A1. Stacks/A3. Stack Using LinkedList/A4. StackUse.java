package StackUsingLL;

public class StackUse {

	public static void main(String[] args) throws EmptyStackException  {
     
		//StackUsingLL ka object hum aise bana rhe honge, stack mai kis type ki value insert karni hai woh <> batayenge
		StackUsingLL<Integer> stack= new StackUsingLL<>();
		
		for(int i=1;i<= 5;i++) {
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
