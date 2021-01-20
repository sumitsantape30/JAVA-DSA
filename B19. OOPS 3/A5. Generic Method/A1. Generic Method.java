package Generic_Methods;

public class print {
	
	//1. agar tum ek function ko generic banana chahte ho, jahape hum output return type likhre usse pehle <T> karna padega.
	//2. <T> matlab generic hai, T kya hai woh apne aap figure out karlega jab hum input denge.
	//3. agar maine integer array diya to woh apne aap figure out karlege ki integer array input hai,and input object class se inherited hona chahiye(Integer,Character etc.) so primitives nhi de skte
	public static<T> void PrintArray(T arr[]) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]);
			System.out.print(" ");
		}
		System.out.println();
	}
	  
	public static void main(String[] args) {
		
	  // int arr[]= new int[10];
	  //PrintArray(arr);        == yeh nhi kr skte coz hum primitives input nhi de skte

       Integer arr[]=new Integer[10];
       for(int i=0;i<arr.length;i++) {
    	   arr[i]= i+1; //Integer array mai 1,2,3,4,.... dal rhe h
       }
	
       String str[]=new String[10];
       for(int i=0;i<str.length;i++) {
    	   str[i]="abc"; //pure aaray mai "abc" dal diya
       }
       
       PrintArray(arr);
       PrintArray(str);
       //Print array is ready to print as long as not primitive hai
	}

}
