Zeros and Stars Pattern

Print the following pattern

Pattern for N = 4
*000*000*
0*00*00*0
00*0*0*00
000***000

Input Format :
N (Total no. of rows)
Output Format :
Pattern in N lines

Sample Input 1 :
3
Sample Output 1 :
*00*00*
0*0*0*0
00***00

Sample Input 2 :
5
Sample Output 2 :
*0000*0000*
0*000*000*0
00*00*00*00
000*0*0*000
0000***0000

Code:

import java.util.*;
public class Solution {

	public static void main(String[] args) {

		
    	 Scanner s = new Scanner(System.in);
   int n = s.nextInt();

   int i,j;
	for (i=1;i<=n;i++) {
		for (j=1;j<=2*n + 1;j++) {  // 1 < =10 - 1
			if(j==i || j==n+1 || 2*n + 2 - j  == i) // 1 == 1  || 4 ==  2*n - j + 1==i
			        System.out.print("*"); 
			else
			        System.out.print("0");
		}
		System.out.println(" ");
	}
	s.close();

    }
}

