// We should use .equals and == , because == will compare their addresses and .equals will compare their contents.


public class comparison_of_strings {

	public static void main(String[] args) {

		String str1= "abcdef";
		String str2= "abcdef";
		
		if( str1 == str2) { //By string pool concept: str1 ka string pool mai 'abc' bana then str2 kabhi content str1 se same hi hai isliye str2 bhi str1 wale 'abc' ko refer karega.
			System.out.println("True");
		}else {
			System.out.println("False");
		}
    
   //iss method pe completely rely nhi kr skte when it comes to compare the contents 
    
//=================================================================================

//Use this method only when we have to check the contents of the string.
 
    String str1= "abc";
		String str2= "abc";
		
		if(str1.equals(str2)) {
			System.out.println("Equal");
		}else {
			System.out.println("Unequal");
		}
 

	}
}
