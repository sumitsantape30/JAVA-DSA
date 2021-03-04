package Restart;

import java.util.Scanner;

public class Practice {

	public static void main(String[] args) {

		char c= 'a'; //agar character banana hai to aise banate
		
		String str= "abcdefgh"; //string is the keyword, str is the reference, and string internally character array ke form mai store hoti hai
		
		System.out.println(str.charAt(1)); //agar muje ek particular index pe string mai kya character rakha hai print karne keliye
		//System.out.println(str[1]) --> this is the wrong way to access any particular element from the string
	
		System.out.println(str.length()); //agar muje mere string ki length chahiye.
		
		//str.substring( startIndex, endIndex) --> endIndex answer ka part nhi hoga.
		System.out.println( str.substring(1,6)); //agar muje string ka particular part chahiye 
		
		System.out.println( str.substring(1)); //agar humne bas startIndex supply kiya to startIndex leke end tak string laake dega.
	
		//agar muje puri string print karna hai, both ways print complete string.
		System.out.println( str.substring(0));
		System.out.println(str);
		
		//agar substring mai str.length diya to empty space print karega coz end se leke end tak kuch nhi hai
		System.out.println(str.substring(str.length()));
		
		//you can store this string in third string and then print length of third string.
		String temp= str.substring(str.length()); // mai bol rha hu ki length ke age ki string print kardo
		System.out.println(temp.length()); //Output: 0
	    
		//agar usme +1 kiya to woh index out of bound exception dega coz length mai aur 1 add hora.
		// so jo bhi index access karre that should be valid.
		String temp1= str.substring(str.length()+1);
		System.out.println(temp1); //Output: IndexOutOfBoundsException: String index out of range: -1
		
		
		System.out.println(str.charAt(9));// hum invalid index access karneki koshish karre so index out of bound exception.
	    
		// 1 se leke 1 tak substring print karre to empty space dega
		System.out.println(str.substring(1,1)); // Output:  (Empty Space)
		
                //str.conatains return true if the string contains that character sequence otherwise false return karega.
		System.out.println(str.contains("abc")); //Output: true
	}
}
