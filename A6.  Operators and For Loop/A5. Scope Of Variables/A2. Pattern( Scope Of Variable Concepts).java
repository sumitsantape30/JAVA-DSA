package lec6;

public class ScopeOfVariables {

	public static void main(String[] args) {

		int i = 10;
		System.out.println(i); // Output: 10
		if (i == 10) {
			int n = 23;
			System.out.println(i); //Output: 10
			System.out.println(n); // Output: 23
		}else {
			int n=345;
		}
		
		int n=4;
		System.out.println(n); //Output: 4
		
		i= 1;
		while (i <= n) {
			int j=1;
			//int i= 23; bahar already 'i' bana hua hai to yaha 'i' banane ki koshish mat karna
			while( j<= i) {
				// int j= 1; // similary yaha 'j' banane ki koshish mat karna kyuki 'j' already bana hua hai
				System.out.print(j);
				j++;
			}
			System.out.println();
			i++;
		}
		
		/* Important points to keep in mind
		   1. Use only after declaration.
		   2. No two variables with same name can co-exist. (same name ke variables ho skte hai but alag alag scope hona chahiye)
		   3. Scope of a variable is limited to surrounding block.
		   */
	}
}

Output:
10
10
23
4
1
12
123
1234
