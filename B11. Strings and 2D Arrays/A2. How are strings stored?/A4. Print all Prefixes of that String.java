import java.util.Scanner;

public class print_prefixes {

	public static String input() {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		return str;
	}

	//prefixes print karne keliye substring mai startIndex=0 and endIndex= i+1 print karenge.
	public static void printprefixes(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println(str.substring(0, i + 1));
		}
	}

	public static void main(String[] args) {
		String userinput = input();
		printprefixes(userinput);

	}

}

Input: Sumit
Output:
S
Su
Sum
Sumi
Sumit
