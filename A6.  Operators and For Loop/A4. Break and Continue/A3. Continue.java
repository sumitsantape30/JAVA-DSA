package break_continue;

public class ContinueDemo {

	public static void main(String[] args) {

// Continue statement in while loop-----------------------------
		
                int n=10;
		int i=1;
		while( i<= n) {
			if( i== 5) {
				i++; // bina iss i++ ke it will give output as break gives
				continue;
			}
			System.out.println(i);
			i++;
		}
		
Output with middle i++:
1
2
3
4
6
7
8
9
10

Output without middle i++;
1
2
3
4

		
// Continue statement in for loop-------------------------------
		
		for (int k = 1; k <= 10; k++) {
			if (k == 5) {
				continue;
			}
			System.out.println(k);
		}

Output of for loop:
1
2
3
4
6
7
8
9
10

	}

}
