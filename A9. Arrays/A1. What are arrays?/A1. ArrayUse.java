public class ArrayUse {
	
	public static void main(String[] args) {
  
                int arr[]= new int[10];
		arr[10]= 15; // Invalid Index also you cannot put -1(negative) numbers as indexing starts from 0. 
		System.out.println(arr[10]); // agar mai array ke invalid index pe jake read/write karne ki koshish karunga to i'll get ArrayIndexOutOfBoundsException.
    //Invalid index means woh index hai hi nhi array mai.
    
//========================================================================================================================================================================
	 	int n = 10;
		int[] arr = new int[n];
		//arr[0] = 15;
		System.out.println(arr[0]); // Jab hum array banate hai uss array ke sare indexes pe by default value zero hoti hai.
		System.out.println(arr[5]);

Output:
0
0

//========================================================================================================================================================================
		//To create arrays of other datatypes
    
		char chArray[] = new char[11];
                double dArray[] = new dArray[12];
                System.out.println(chArray[0]); // All the elements in character array are initialised to null(empty space)
		System.out.println(dArray[0]); // All the elements in the double are intialised to 0.0

Output:
    (null for char)
0.0

//============================================================================================================================================================================
    
    //To assign and access values for char and double
     
		char chaArr[]= new char[7];
		double dArr[]= new double[12];
		
		chaArr[2]= 'a';
		dArr[3]= 1.2;
		
		System.out.println(chaArr[2]); // Ouput: a
		System.out.println(dArr[3]);  // Output: 1.2

	}
} 
