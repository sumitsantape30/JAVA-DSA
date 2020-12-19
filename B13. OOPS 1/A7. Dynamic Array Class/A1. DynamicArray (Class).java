package classesAndobjects;

public class DynamicArray {
	
	private int data[]; //we have data array which is going to store all our data.
	private int nextIndex; // this tell us ki data humara konse index pe store hoga, sabse pehle 0th index pe element dalenge so shuru mai nextIndex=0 rahega.
	
	public DynamicArray() {
		
		data=new int[5]; //hum data array starting mai 5 size ke lere
		nextIndex= 0; //nextIndex by default zero hota hai but fir bhi intialize karra
	}
	
	public int size() {
		return nextIndex; //suppose mere pas ek array hai uska nextIndex 3 hai, so next element 3rd index pe jayega but usse pehle 0th pe ek index hoga then 1th 2th index pe hoga means size is 3(oth index to 2nd)
	}
	
	public void add(int element) { // agar mere array mai space hai to add krdo but agar space nhi hai to new array of double size banana padega.
		if(nextIndex==data.length)//check karra array mai space hai ki nhi, agar nextIndex == array ke length means array bhara hua hai
			{
			restructure();
		}
		data[nextIndex]=element; //nextIndex pe element ko dal rha hu and nextIndex ko ++ karra
		nextIndex++;
	}
	
	public void set(int index,int element) { //open register for it's explanation
		if(index > nextIndex) { //jis index pe dalna hai agar woh nextIndex se bada hoga to return kar denge.
			return;
		}
		if(index < nextIndex) { 
			data[index]=element; //jis index pe replace karna chahte ho us index pe element dal rhe
		}else {
			add(element);
		}
	}
	
	public int get(int index) { //open register for it's explanation
		if(index >= nextIndex) { 
			// ERROR OUT
			return -1;
		}
		return data[index];
	}
	
	public boolean isEmpty() {
		if(size()==0) { //if size is zero then it is empty
			return true;
		} else {
			return false;
		}
	}
	
	public int removeLast() {
		if(size()==0) {  //agar size zero rahi to kuch return nhi kar payenge so return -1
			//Error out
			return -1;
		}
		int value=data[nextIndex-1]; //next element jaha add hoga use index 1 piche wala return karenge means nextIndex-1 wala return karna padega
		data[nextIndex-1]=0; //jo value remove ki uski jagah 0 dal rhe h
		nextIndex--; // last wala humne remove kiya so nextIndex ko piche lana chahiye so that aur element add hua to right position pe add ho
		return value;
	}
	
	private void restructure() { //private kiya coz mai chahte hu ki iska access sirf isi class mai ho
		//is function mai humko double sized array banana hai, purane array ke elements new wale mai copy karna hai
		int temp[]= data; //temp old wale array(data) ko point karra
		data=new int[data.length*2]; //maine doubled size ka array banaya and data new array ki taraf point kiya.
		for(int i=0;i<data.length;i++) {
			data[i]= temp[i];//copying data from temp[i] to data[i]
		}
	}
}

