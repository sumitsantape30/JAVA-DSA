Star Pattern

Print the following pattern
Pattern for N = 4

Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines

Constraints :
0 <= N <= 50

Sample Input 1 :
3
Sample Output 1 :
   *
  *** 
 *****
 
Sample Input 2 :
4
Sample Output 2 :
    *
   *** 
  *****
 *******
 
 Code: 
 
import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
	      for ( int i = 1; i <= n; i++)
	      {
	          for(int k = 1; k <= n-i; k++)
	          {
	             System.out.print(" ");
	          }
	          for (int j = 1; j <= 2*i-1; j++)
	          {
	            
	              System.out.print("*"); 
	          }
	          System.out.println();
	      }
	}
}
