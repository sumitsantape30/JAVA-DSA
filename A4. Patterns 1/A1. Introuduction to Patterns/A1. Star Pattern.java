package patterns;
import java.util.Scanner;

public class p1_square {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int i=1;
		while(i<=n)
		{
			int j=1;
			while(j<=n)
			{
				System.out.print("4");
				j++;
			}
			System.out.println();
			i++;
		}
	}
}
