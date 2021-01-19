
public class Return_Keypad {

	public static char[] numberOptions(int n) {
		switch (n) {
		case 2:
			char options2[] = { 'a', 'b', 'c' };
			return options2;
		case 3:
			char option3[] = { 'd', 'e', 'f' };
			return option3;
		case 4:
			char option4[] = { 'g', 'h', 'i' };
			return option4;
		default:
			char options[] = { '\0' };
			return options;
		}

	}

	public static String[] returnKeypad(int n) {
		if (n == 0) { // jab n zero hoga to usko koi keypad combination nhi hoga so we should return an size 1 array jisme empty string hoga
			String ans[] = { "" };
			return ans;
		}
		int lastDigit = n % 10;
		int smallerNumber = n / 10;

		String smallAns[] = returnKeypad(smallerNumber);

		char options[] = numberOptions(lastDigit);
		String ans[] = new String[smallAns.length * options.length];
		int k = 0;

		for (int i = 0; i < smallAns.length; i++) {
			for (int j = 0; j < options.length; j++) {
				ans[k] = smallAns[i] + options[j];
				k++;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int n = 234;
		String ans[] = returnKeypad(n);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

}
