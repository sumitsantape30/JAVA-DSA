
public class IncrementDecrement {

	public static void main(String[] args) {
		int a = 10;
		//System.out.println(++a); //output : 11
		System.out.println(a++); //Output : 10
		a++;
		++a;
		System.out.println(a); //Output: 13
//========================================================================
	        int a=10;
		int b= a++; //Increment honese pehle a ki old value b mai store hogi then increment hoga
		System.out.println(b); // Output: 10 
		System.out.println(a); // Output: 11
//========================================================================
		int a=10;
	        int b = ++a;
		System.out.println(b); //Output: 11
		System.out.println(a); // Output: 11
		
// All THE CONCEPTS FOR DRECREMENT OPERATOR ARE SIMILAR TO INCREMENT OPERATOR.
		
//======================================================================
		a = 4;
		a *= 2;
		System.out.println(a); //Output: 8
		
		a ^= 2;
		System.out.println(a); // Output: 10
	
		int ans2 = 2 + 3 * 4; //(Wrong Way, use brackets)
		System.out.println(ans2); // Output: 14
		int ans = (2 * 3)/2;  // Right Way
		System.out.println(ans); // Output: 3
		
	}

}
