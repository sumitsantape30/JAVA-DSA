package QueueUsingArray;

public class QueueUse {

	public static void main(String[] args) {

		// QueueUsingArray ka object banayenge
		QueueUsingArray queue = new QueueUsingArray();

		
		for (int i = 1; i <= 5; i++) {
			try {
				queue.enqueue(i); //QueuFullException nhi ayega so try catch se surround krlete hai
			} catch (QueueFullException e) {
				// Do not reach here
			}
		}

		while (!queue.isEmpty()) { //jabtak queue khali nhi hoti tabtak print krte hai
			try {
				System.out.println(queue.dequeue()); //exception nhi ayega yaha but try catch mai dal dete hai
			} catch (QueueEmptyException e) {
				// Never reach here
			}
		}
	}

}

Output:
1
2
3
4
5
