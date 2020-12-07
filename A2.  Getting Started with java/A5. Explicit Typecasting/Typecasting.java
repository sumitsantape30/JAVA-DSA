
public class DataType {

	public static void main(String[] args) {
		char c = 'a';
		//System.out.println(c + 3);
		
		int i = c + 10;
		//System.out.println(i);
		
		i = c;
		char abc = (char)i;
		
		long l = i;
		l = 12345654321L;
		i = (int)l;
		System.out.println(l);
		System.out.println(i);
		
		double d = i;
		//i = d;
		
		float f = 1.23f;
		//f = d;
		d = f;
		
		int j = 100;
	}
}

Output:
12345432
-539247567 // Why we got negative number? 
	   // coz, Out of the 8bytes of the long only 4bytes gets copied, out of this 4bytes first bit was 1 that's why we got negative numbers.
