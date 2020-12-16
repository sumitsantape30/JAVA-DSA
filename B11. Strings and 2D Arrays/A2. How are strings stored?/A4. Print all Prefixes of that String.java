import java.util.Scanner;

public class print_prefixes {

	public static String input() {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		return str;
	}

	//substring use krke 0 se 0 tak ki string print karenge, mera start index fix hai and end index i ke sath badhege aur +1 karna padega coz substring mai endIndex include nhi hota..
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
