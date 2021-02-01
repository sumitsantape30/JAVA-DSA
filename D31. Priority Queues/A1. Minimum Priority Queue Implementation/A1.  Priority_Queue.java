import java.util.ArrayList;

//Hum minimum heap keliye implement kar rhe hai
//Iss priority_Qeueu class ko implment karne wale hai hum, iske liye muje heap, kyuki mai heap ko as a array store karunga but there's size constraint in arrays. So humare heap mai size constraint na aaye so there's option ki hum dynamic form of array use karenge and i.e. ArrayList.
public class Priority_Queue {

	private ArrayList<Integer> heap; // meri heap arraylist ke form mai store hogi. And meri heap ke access kisiko na mile isliye private rakh rhe h, meri heap ka access bas isi class ke through milrha h

	public Priority_Queue() { //mai chahta hu ki jaisehi Priority_Class ka object banaye to ek heap bhi bane
		heap = new ArrayList<>(); // abhitak meri ArrayList bani nhi hai woh by default null hogi as it's non primitive isliye abhi banayi
	}

	boolean isEmpty() { //to check if the priority queue is empty or not
		//priority queue khali hona matlab matlab heap(arraylist) khali hona
		return heap.size() == 0;
	}

	int size() { //priority queue ke size keliye
		return heap.size(); //jo arraylist ka size hoga wahi humari priority queue ka size hoga
	}
	
	//hum minimum heap implement karre so so yeh function sabse minimum priority wala element dega
	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// agar priority queue(heap) khali hoga to exception throw karega
			throw new PriorityQueueException();
			//agar exception nhi lagya to indexoutofbound error aajeyega
		}
		return heap.get(0); // meri heap ke 0th index pe jo hoga woh minimum priority wala integer hai so woh return karenge
	}
	
	
	//insert karneka first step is hum jis element ko inset karna hai usko heap(arralist) ke sabse last mai add karenge. Insert karne ke bad heap order property bhi ensure karna hai iskliye jis element ko insert kiye uske parent ke sath compare karo
	void insert(int element) { //input will be the element which we have to insert
		heap.add(element);// jo element heap mai insert karna hai woh arraylist ke last mai add hota hai

		//after adding we need to perform the steps for upward heapify
		// insert karre means upward heapify karna padega means parent ke sath compare krke priority wise swap karna padega isliye child ka index aur parent ka index lagega so pehle woh nikalenge
		int childIndex = heap.size() - 1; // initially childIndex last element pe hai/hoga
		int parentIndex = (childIndex - 1) / 2; 

		//ab hume compare karna hai child aur parent ki priority ko, yeh kam hum jabtak root pe nhi pohoch jate tabtak ya to parent ki priority kam nhi hoti child se tabtak karenge. Yeh repeatedly karna hai isliye loop
		while (childIndex > 0) {// jabtak root pe nhi pahuchte tabtak
       
			if (heap.get(childIndex) < heap.get(parentIndex)) { // child and parent ki priorities ko compare karenge. childIndex pe jo element hai agar woh chota hai parentIndex wale element se to dono ke swap karna hai
            
				//for swapping i need temp, mai childIndex wale position pe jo element hai usko temp mai dalunga and childIndex wale position pe parentIndex wala element dalunga.
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex)); // arraylist(heap) mai set karna hai muje, childindex pe parent ki value set krdi
				heap.set(parentIndex, temp); // parentIndex pe temp(child) ko set karenge
               
				//yeh swap karne ke bad jo childIndex pe element rakha tha woh parentIndex pe chala gya hai ab usko uske parent ke sath compare karna padega
				childIndex = parentIndex; // woh root tak check karna hai so jo parent hai woh child banega
				parentIndex = (childIndex - 1) / 2; // humne humara childIndex update kiya so parentIndex ko firse calculate karna padega

			} else {
				//else mai aaye means child index ki priority parent index ki priority se kam nhi hai, means woh ya to equal hai or badi hai. agar equal or badi hai to uss case mai swap karne ki jarurat nhi hai aur aage badhna bhi nhi yahi pe ruk jana chahiye so return karenge.
				return;
			}
		}
	}

	
	int removeMin() throws PriorityQueueException { //jo element remove karenge wahi element return bhi karenge
		if (isEmpty()) {
			throw new PriorityQueueException();
		}

		int temp = heap.get(0); // Jo element remove karre woh return bhi karna hai isliye temp mai store karre

		// Jo last index pe hai usko root(min/0th index) pe leke ayenge means set karenge
		heap.set(0, heap.get(heap.size() - 1)); 
		heap.remove(heap.size() - 1); // Jo last pe index element pada hai usko hum delete karenge coz hum usko 0th index pe leke aagye hai
      
		//yeh kam hone ke bad humara major kam that is heapify baki hai, and hum downward heapify karenge as last element pehle index pe arr rha h
		//heapify karne keliye root ke left and right dono children ke sath compare karna padega, and dono child mese jo bhi minimum hoga usko root wala replace karega.
		int index = 0; // root ka index. Index is the node jisko hum compare kar rhe hai
		int minIndex = index; // dono children mese jo minimum hoga uska sath hume replace karna hai isliye jo minimum hoga uska index hai minIndex, And initially jo root ka index hai wahi minIndex rahega
		int leftChildIndex = 1; // left= 2*i+1 (i=0) //root ke dono childrens ke index nikalenge taki unko root ke sath compare kar paye.
		int rightChildIndex = 2; // right= 2*i+2 (

		while (leftChildIndex < heap.size()) { // yeh kam hume bar bar karna hai jabtak range mai hai means jabtak leaf node nhi aajata (leaf node ho jane ke bad, uske children nhi rahenge compare karne keliye) (heap mai hum sabse pehle left side mai element insert karte hai isliye leftChildIndex < heap.size() kiya hai, agar left child nhi hoga to right hogahi nhi coz insertion left se hota hai)

			// right and left ki donoki values compare karenge and minIndex pe rakhe hue element se chote honge to minIndex ko update karenge
			if (heap.get(leftChildIndex) < heap.get(minIndex)) { 
				minIndex = leftChildIndex; // agar leftchild ki value kam hai right wale se to minIndex ko update karne kelie leftChildIndex dal diya
			}
			
			//left child se compare hojayega coz left child exist krta yeh guaranteed hai kyuki entry condition hi wahi hai so we should first make sure ki right wala child exist krta hai ya nhi and then compare karenge so this childIndex should be less than heap size
			if (rightChildIndex < heap.size() && heap.get(rightChildIndex) < heap.get(minIndex)) { //right wale child ko aur minIndex wale element ko compare karre and right child element chota hua to minIndex ko update kr denge
				minIndex = rightChildIndex;
			}
			
			//humare pas indexes aagye hai ab swapping kaneka kam karenge

			if (minIndex == index) { //aisi bhi condtion hogi jisme aur swap karna hi na ho aur niche jana hi na ho means jab root ki priority already minimum hai meatalb jab index == minIndex hoga to hume ruk jana hai
				break;
			} else {

				// swap
				int temp1 = heap.get(index);
				heap.set(index, heap.get(minIndex)); //dono children mese jo chota hoga uska index minIndex mai aagya hoga to usko old wale root ke place pe dal denge.
				heap.set(minIndex, temp1); //dono children mese jo chota tha uske index pe humne jo temp mai pehle root ki value dali thi usko set kardenge
				index= minIndex; // jab ek operation hojayega to index(root) update karna padega, so left right child mese jo minimum hoga usko root banana padega
				//left right child bhi update karne padege root update karne ke bad
				leftChildIndex= 2 * index + 1;
				rightChildIndex= 2 * index + 2;
				
			}
		}
		//finally jo element remove karna tha usko remove kardenge
		return temp;
	}
	      
}
