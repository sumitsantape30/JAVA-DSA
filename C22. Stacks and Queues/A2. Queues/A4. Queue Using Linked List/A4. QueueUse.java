package QueueUsingLL;

public class QueueUse {

	public static void main(String[] args) {

		//QueuUsingLL ka object banayenge and Integers dal rhe honge uske andar
		QueueUsingLL<Integer> queue= new QueueUsingLL<>();
		
		//isme try catch lagane ki jarurat nhi hai coz yeh linked list hai yaha QueueFullException nhi ayega
		for(int i=1;i<=5;i++) {
			queue.enqueue(i);
		}
		
		while(!queue.isEmpty()) {
			try {
				System.out.println(queue.dequeue());
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

}
