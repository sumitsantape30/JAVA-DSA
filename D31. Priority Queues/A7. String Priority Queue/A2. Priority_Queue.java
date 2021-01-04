package InbuildMaxPriorityQueue;

import java.util.ArrayList;


public class Priority_Queue {

	private ArrayList<Integer> heap; // mere heap data member ka access kisiko nhi milna chahiye

	public Priority_Queue() {
		heap = new ArrayList<>(); // by default null hote hai and it will refer to the new arraylist
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}
	

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// agar priority queue khali hoga to exception throw karega
			throw new PriorityQueueException();
		}
		return heap.get(0); // jo 0th index pe hoga woh minimum priority wala integer hai so woh return
							// karre
	}
	

	void insert(int element) {
		heap.add(element);// jo element heap mai insert karna hai woh arraylist ke last mai add hota hai

		// insert karre means upward heapify karna padega means parent ke sath compare
		// krke priority wise swap karna padega
		int childIndex = heap.size() - 1; // initially childIndex is last element
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {// jabtak root pe nhi pahuchte tabtak

			if (heap.get(childIndex) < heap.get(parentIndex)) { // child and parent ki priorities ko compare karenge

				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex)); // arraylist(heap) mai set karna hai muje, childindex pe
																// parent ki value set krdi
				heap.set(parentIndex, temp); // parentIndex pe childrenko dala
				childIndex = parentIndex; // woh root tak check karega jo parent hai woh child banega
				parentIndex = (childIndex - 1) / 2; // parentIndex ko dubara se update kardena chahiye

			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException { // jo element remove hua hai woh return karega
		if (isEmpty()) {
			throw new PriorityQueueException();
		}

		int temp = heap.get(0); // Jo element remove karre woh return bhi karna hai

		heap.set(0, heap.get(heap.size() - 1)); // Jo last pe hai usko root(min/0th index) pe leke ayenge
		heap.remove(heap.size() - 1); // Jo last pe element pada hai usko remove kardo

		int index = 0; // root ka index
		int minIndex = index; // dono children mese jo minimum hoga uska index
		int leftChildIndex = 1;
		int rightChildIndex = 2;

		while (leftChildIndex < heap.size()) { // jabtak range mai hai (leaf node ho jane ke bad, uske children nhi
												// rahenge compare karne keliye)

			// values compare krke index update karre
			if (heap.get(leftChildIndex) < heap.get(minIndex)) {
				minIndex = leftChildIndex; // agar leftchild ki value kam hai right wale se to minIndex ko update karke
											// leftChildIndex diya
			}
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) { //agar leftchildren nhi hoga to rightChildren hoga hi nhi ro
				minIndex = rightChildIndex;
			}

			if (minIndex == index) { // jab khatam hoajega to index aur minIndex equal hojayega tab aage nhi run
										// karna hai
				break;
			} else {

				// swap
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex));
				heap.set(minIndex, temp1);
				index= minIndex; // jab ek operation hojayega to index update karna padega
				leftChildIndex= 2 * index + 1;
				rightChildIndex= 2 * index + 2;
				
			}
		}
		return temp;
	}
	      
}
