Number Star pattern 1

Print the following pattern for given number of rows.

Input format :
Integer N (Total number of rows)
Output Format :
Pattern in N lines

Sample Input :
   5
Sample Output :
 5432*
 543*1
 54*21
 5*321
 *4321
 
 Code:
 
import java.util.Scanner;

class Solution {

	public static void main(String[] args) 
    {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for(int i = 1; i <= n; i++)
        {
    	  for(int j = n; j > i ; j--)
    	  {
    		 System.out.print(j);
    	  }
    	  System.out.print("*");
    	  for(int j = i-1; j >= 1; j-- )
    	  {
    		  System.out.print(j);
    	  }
    		  System.out.println();
        }
        s.close();
	}

}
