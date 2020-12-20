
public class CheckSorted {
	
	public static boolean checkSorted(int input[]) {
		if(input.length <=1) { //simplest problem anyone can give us is single sized array or of size zero, and woh humesha sorted hi rahega so return true.
			return true;
		}
		
		// n-1 size ki problem ka solution pehle nikalna padega.(suppose 4 size ka array to (n-1) size ki problem means first wale ko chodke remaining 3 element)
		// checkSorted hi humara answer lake dega but uska input n-1 size ka array hai, usme saare elements honge first wala nhi hoga that means we need another array.
		int smallInput[]= new int[input.length-1]; //size of the array will be 1 less than the input's size.
		//array banaya ab input array ke 1st index se smallInput array mai elements copy karna chahiye.
		for(int i=1;i<input.length;i++) {
			smallInput[i-1]=input[i]; //smallInput ke 0th index dalne start karna padega so i-1
		}
		
		//hum checkSorted mai smallInput pass karenge coz hume n-1 array sort hai ki nhi yeh pta karna hai
		boolean Smallans= checkSorted(smallInput); //just assume ki yeh bata dega woh sorted hai ya nhi
		
		// jo array maine pass kiya (n-1 size ka) woh sorted nhi hai to obviously overall array sorted nhi hai so return false.
		if(!Smallans) {
			return false;
		}
		
		//agar n-1 size ka array sorted hai to muje input array mai first two elements ko compare karna padega.
		if(input[0]<=input[1]) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		int input[]= {2,1,3,4}; 
		boolean result= checkSorted(input);
		System.out.println(result);

	}

}
