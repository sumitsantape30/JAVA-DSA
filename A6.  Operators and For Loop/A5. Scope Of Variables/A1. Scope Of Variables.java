package lec6;

public class ScopeOfVariables {

	public static void main(String[] args) {

//======================================================================================================================================
		int i = 10;
		System.out.println(i);
		if (i == 10) {
			int n = 23;
			System.out.println(n);
		}
		System.out.println(n);// yaha error ayega coz 'int n' bracket ke andar initialise hua hai to uska scopre sirf bracket mai hi rahega bracket ke bahar access nhi kr skte.
//=========================================================================================================================================
		int i = 10;
		System.out.println(i);
		if (i == 10) {
			//int i=23; // yaha error ayega coz same named variable use nhi kr skte. 
			int n = 23;
			System.out.println(i);// System ko confusion hoga ki konse 'i' ki bat kr rhe so waha error ayega.
			System.out.println(n);
		}
Output:
10
10
23

//===========================================================================================================================================
	        int i = 10;
		System.out.println(i); // Output: 10
		if (i == 10) {
			int n = 23;
			System.out.println(i); //Output: 10
			System.out.println(n); // Output: 23
		}
		
		int n= 34; // firse 'n' initialise kar skte hai coz iss line tak koi aur local variable named 'n' nhi hai, upar jo n hai uska scope brackets ke andar hi hai.
		System.out.println(n); //Output: 34
//============================================================================================================================================
		int i = 10;
		System.out.println(i); // Output: 10
		if (i == 10) {
			int n = 23;
			System.out.println(i); //Output: 10
			System.out.println(n); // Output: 23
		}else{
			int n=234;
		}
		
		System.out.println(n);// yaha error ayaga coz dono 'n' ka scope brackets ke andar hi hai, else lagane se kuch change nhi hoga
//==============================================================================================================================================
		int i = 10;
		System.out.println(i); // Output: 10
		if (i == 10) {
			int n = 23;
			System.out.println(i); //Output: 10
			System.out.println(n); // Output: 23
		}else{
			int n=234;
		}
		
		int n=23; // you cannot name two local variables with same but ek ka scope khatam hogya hai to dusra bana skta hu same nam ka coz pehle n ka scope hogya hai ab woh available nhi hai
		System.out.println(n);

	}
}
