package break_continue;

public class Pattern {

	public static void main(String[] args) {
		int n = 4;
		int i = 1;
		while (i <= n) {
			int j = 1;
			while (j <= n) {
				System.out.print(j + " ");
				j++;
				if (j > i) {
					break; // Break sirf andar wala while loop ko break karega not baharwale loop ko
				}
			}
			System.out.println();
			i++;
		}
	}
}

Input: 4
Output:
1 
1 2 
1 2 3 
1 2 3 4 
