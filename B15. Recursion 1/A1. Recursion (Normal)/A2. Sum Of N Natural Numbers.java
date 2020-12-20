
public class SumOfNaturalNumbers {
	
	public static int sum(int n) {
		if(n==1) { //smallest sum jo mai calculate kr skta hu aur yahipe program stop ho jayega.
			return 1;
		}
		return n+(n-1); //sum of n natural numbers will be equal to n + sum of (n-1) natural numbers.
	}

	public static void main(String[] args) {
		int n=4;
		System.out.println(sum(n));
		

	}

}
