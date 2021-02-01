Code : In-place heap sort

Given an integer array of size N. Sort this array (in decreasing order) using heap sort.
Note: Space complexity should be O(1).

Input Format:
The first line of input contains an integer, that denotes the value of the size of the array or N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format :
The first and only line of output contains array elements after sorting. The elements of the array in the output are separated by single space.

Constraints :
1 <= n <= 10^6
Time Limit: 1 sec

Sample Input 1:
6 
2 6 8 5 4 3
Sample Output 1:
8 6 5 4 3 2

Code:


//Purane Heap Sort mai humne ek heap(priority qeueu) banaya and heap elements insert krte gye aur remove krte gye. Isme hum extra space le rhe coz hum ek new Priority Queue bana rhe jo internally ek arralist use kr rha hai jisme elements store kr rha hai yeh avoid krne keliye hum new Arraylist nhi banayenge jo bhi insertions removal karre woh sare ke sare ek hi array mai store karre honge so jo heap store karne keliye jo storage lenge woh usi array mai lene wale hai
//*open book and last page of this probelm* suppose i have an array aur muje one by one element into the heap dalne hai, initially i'll assume heap khali hai, to 5 ko heap mai insert karenge to 5 heap mai aajayega, then 1 ko heap mai insert karenge, pehle heap sirf 5 thi ab 1 aya to woh 5 ke left child hoga aur hum upward heapify ka kam karenge

public class InplaceHeapSort {
	
	//iss function ka kam hai ki heap mai insert kardo
	public static void insertIntoVirtualHeap(int arr[], int i) {
		//purane heap sort mai hum insert karne keliye heap.add(element) krte hai but yahape woh array mai already added hi hai, humara bas heapify karne ka kam bacha hai
		//heapify keliye child index aur parent index chahiye hoga
		int childIndex= i; //abhi abhi ith element ko insert kara hai to childIndex will be i
		int parentIndex= (childIndex-1)/2; //parentIndex calculate kar lenge
		
		//yeh karne ke bad bar bar parent aur child ki priority ko compare karna hai
		while(childIndex > 0 ) { 
			if(arr[childIndex] < arr[parentIndex]) { //array ke child index pe jo element pda hai uski priority parent index pe jo element hai usse kam hai to hum swap kar denge
				//swap
				int temp= arr[childIndex]; 
				arr[childIndex]= arr[parentIndex]; // chilIndex pe woh element jo parentIndex pe pda hua hai
				arr[parentIndex]= temp; //aur parentIndex pe child
				
				//aur childIndex aur parentIndex ko update karenge
				childIndex= parentIndex; //ek swapping ke bad parent niche ayega then woh child hojayega
				parentIndex= (childIndex -1)/2; //child chsnge hua to parent ko bhi update karna padega.
				
			}else {
				//agar child ki priority parent ki priority se better hai to swap karneki jarurat hi nhi hai
				return;
			}
		}
	}
	
	// yaha tak humne array ko heap mai convert kiya, ab ek ek karke heap se element remove karne hai and last mai store krte jana hai
	
	//is function mai hume element ko remove karne ka kam krna hai ek ek karke
	public static int removeMinFromVirtualHeap( int arr[], int heapSize) {
		//purane heap sort ke removeMin mai hum arraylist use krte the for removing, and heap ka size lere the 'currently meri heap kitte size ki hai'
		
		int temp= arr[0]; // min wala remove hoga aur isko return bhi karna hai isliye temp mai dale
		arr[0]= arr[heapSize -1];// last wale ko first pos pe leke aye
		heapSize--; //last wala element ab starting mai aagya so last wale ko delete karne keliye heap ka size 1 se kam kr rhe. (purane isme arraylist pe remove() call karna padta tha)
		
		int index=0; //jis index pe hume kam karna hai (abhi minIndex lene ki jarurat nhi hai, we can ignore it)
		int leftChildIndex= 2*index +1; //iss index(just uparwala) ka left child ka index
		int rightChildIndex= 2*index +2; //iss index(just uparwala) ka right child ka index 
		
		while( leftChildIndex < heapSize) { //hum tabtak kam karenge jab dono child ki priotiy jada hai or jabtak hum leaf node tak nhi pohoch jate, leafNode tak pohochne ka condition is jabtak leftChildIndex is less than heapSize
			
			int minIndex= index; //dono mese minimum ka index, now i'm assuming ki index hi minIndex hai
			if(arr[leftChildIndex] < arr[minIndex]) { //agar left child index ki value index se kam hai to woh apna minimum hai use minIndex mai dal denge
				minIndex= leftChildIndex;
			}
			
			//aisa ho skta hai ki right child exist hi na krta ho so we should check ki jo rightChildIndex hai woh heapSize ke kam hai
			if(rightChildIndex < heapSize && arr[rightChildIndex] < arr[minIndex]) {
				minIndex= rightChildIndex;
			}
			
			//minIndex index ke equal nhi hai matlab muje swap karna hai (index aur minIndex wale elements ko swap karna hai)
			if(minIndex != index) {
				int temp1= arr[index]; //temp pe array ka index wala element dal dete hai
				arr[index]= arr[minIndex]; //array ki index wali position pe jo minimum hai use dalenge
				arr[minIndex]= temp1; //array ke minIndex pe temp1 ko dalte hai
				
				//iske bad humara kam rehta hai ki index ko update kare dono child kobhi update kare
				index= minIndex; // ab muje minIndex pe element that uspe kam karna hai
				leftChildIndex= 2*index +1;
				rightChildIndex= 2*index +2;

				
			} else { //means minIndex aur index equal hai to muje swap nhi karna so I should break
				break;
			}
		}
		return temp;//jo element remove hua woh return karenge
	}
	

	public static void main(String[] args) {

		int arr[] = {5,1,9,2,0,6};
		//in array elements ko ek ek krke queue mai insert karna hai to queue muje nayi wali nhi chahiye, i'll instead create a function, hum isi array mai ek heap insert karne wale hai
		for(int i = 0; i < arr.length; i++){ 
			insertIntoVirtualHeap(arr,i); //array aur konsa element heap mai insert karna hai uska index de denge function mai. Meri heap array mai hi store hogi
		}
		// yeh karne ke bad ek ek karke sare elements ko heap mai insert gogye hai means heap mere array mai hi stored hai. Mere array elements is tarah se arranged hogye hai that they form a heap.
		
		for(int i=0; i< arr.length; i++) {
		    // yeh muje Jo element remove karre woh lake dega aur usko hum array ke sabse last index mai store karenge
		   arr[arr.length -1 -i]= removeMinFromVirtualHeap(arr, arr.length-i); // iss array mese jaise jaise ek ek karke elements remove krte jayenge to heap ka size change hoga but array ka change nhi hoga so hume yaha heap ka size bhi pass karna chahiye, so intially heap size full hai(array.length), then ek ek element remove karoge to heap ka size ek aur kam hojayega so heap ka size would be arr.length-i
		//kyu likhe maine aisa *(arr, arr.length-i)* ? kyuki mai array to pass kr hi rha hu, but har bar array ki length aur heap ki length same nhi hone wali hai. Initially array 6 size ka hai to heap bhi 6 size ka hai but agar ek element remove kar denge to array 6 hi size ka rahega but heap meri 5 size ki hojayegi internally so isliye heap size array size change hote ja rhe hai
		//jaise jaise i badhta jayega elements remove krte jayenge aur heap size kam hota jayega so humne heap size bhi pass kardiya.
		}
		
		for(int i=0; i<arr.length; i++) { 
			System.out.print(arr[i]+" ");
			}
	}

}


Output:
	9 6 5 2 1 0 //we got output in descending order
	//Agar output ascending order mai chahiye to isko reverse karo ya fir maximum priority ke according implement kro and we'll achieve in ascending order

