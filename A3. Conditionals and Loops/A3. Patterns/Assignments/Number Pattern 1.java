Number Pattern 1

Print the following pattern
Pattern for N = 4
1
23
345
4567

Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines

Sample Input 1 :
3
Sample Output 1 :
1
23
345

Code: 

import java.util.*;
public class Solution
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int k = 0;
		for (int i = 1; i <= n; i++)
		{
		    k = i;
		    for(int j = 1; j <= i; j++)
		    {
		        
		        System.out.print(k);
		        k++;
		    }
		    System.out.println();
        }
		
	}

}
