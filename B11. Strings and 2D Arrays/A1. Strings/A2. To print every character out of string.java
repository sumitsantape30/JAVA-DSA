
public class charsinSeparateLines {
	
	public static void print( String str) { //Input will be the string jise print karna hai
		
		//ek line mai ek character print karna hai hume matlab ek ek karke har character pe jana chahiye hume
		for( int i=0 ; i< str.length(); i++) {
			System.out.println(str.charAt(i));
      //System.out.println(str);--> yeh puri string ko print kardega but hume yeh nhi karna hai
		}
	}

	public static void main(String[] args) {
	
		String str= "abcdefgh";
		print(str);

	}

}

Output:
a
b
c
d
e
f
g
h

