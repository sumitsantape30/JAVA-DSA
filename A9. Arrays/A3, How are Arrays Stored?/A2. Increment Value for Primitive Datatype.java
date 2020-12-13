package HowAreArraysStored;

public class HowAreArrayStored {

	public static void increment(int i) {
		i++;
	}

	public static void main(String[] args) {

		int i = 5;
		increment(i);
		System.out.println(i); // main wala 'i' and increment wala 'i' dono different hai so main ko bas apna 'i' pta tha so wahi print kiya

//Output: 5

	}

}
//==============================================================================

package HowAreArraysStored;

public class HowAreArrayStored {

	public static int increment(int i) {
		i++;
		return i;
	}

	public static void main(String[] args) {

		int i = 5;
		i = increment(i);
		System.out.println(i);

//Output: 6

	}

}
