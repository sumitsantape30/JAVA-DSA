// Data which is in integer form is stored in binary form but for characters binary form is not possible
// But every character has a integer value= ASCII Value
// Characters are getting converted into ASCII Values then they are stored.

public class DataType {

	public static void main(String[] args) {
		char c = 'a';
		System.out.println(c + 3); // Output : 100
		
		int i = c + 10;
		System.out.println(i); // Output : 107
		
		i = c;
//		char abc = i; // You are trying to copy 4bytes into 2bytes so it will give a error
		
		long l = i;
		//i = l; // You are trying to copy 8bytes into 4bytes so it will give a error
		
		double d = i;
		//i = d; // You are trying to copy 8bytes into 4bytes so it will give a error
		
		float f = 1.23f;
		//f = d; // You are trying to copy 8bytes into 4bytes so it will give a error 
		d = f; // 8byte mai 4byte store kr skte hai
		
		int j = 100;
		
	}

}
