package patterns;
import java.util.Scanner;
public class p3_square {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		while(i<=n)
		{
			int j=n;
			while(j>0)
			{
				System.out.print(j);
				j--;
			}
			System.out.println();
			i++;
		}
	}
}

Input: 5
Output: 
11111
22222
33333
44444
55555

