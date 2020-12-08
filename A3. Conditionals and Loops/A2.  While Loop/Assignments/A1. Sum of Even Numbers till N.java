Sum of Even Numbers till N

Given a number N, print sum of all even numbers from 1 to N.

Input Format :
Integer N
Output Format :
Required Sum 

Sample Input 1 :
 6
Sample Output 1 :
12

Code:

package while_loops
import java.util.*;
public class Solution
{
	public static void main(String args[])
    {
                Scanner s= new Scanner(System.in);
		
		int n= s.nextInt();
		int sum=0;
		int i=1;
		while(i <= n) {
			
			if( i % 2 == 0) {
             sum= sum + i;
			}
			i++;
		}
		System.out.println(sum);
    }
}
