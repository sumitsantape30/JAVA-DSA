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
        Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int s = 0;
       for ( int i = 1; i <= n; i++)
       {
           if( i % 2 == 0)
           {
               s += i;
           }
       }
       System.out.println(s);
    }
}
