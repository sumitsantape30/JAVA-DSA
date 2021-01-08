Code: Edit Distance(Memoization and DP)

You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character

Note :
Strings don't contain spaces in between.
 Input format :
The first line of input contains the string S of length M.
The second line of the input contains the String T of length N.
Output format :
Print the minimum 'Edit Distance' between the strings.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".
And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 
Hence, the minimum distance.

Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9

Code:


public class EditDistanceDP {
	
	public static int editDistanceDP( String s, String t) { //intput will be two strings
		
		//strorage array chahiye so create storage array
		int m= s.length();
		int n= t.length();
		int storage[][]= new int[m+1][n+1];
		
		//handling basecase= first column and first row correspond to basecase. Coz dono mese koi ek string ki length 0 rhi to storage array mai hum dusri string ki length dalte the.
		//Basecase ke corresponding entries dalenge
		
		//first row keliye
		for( int j=0 ;j <= n ; j++) {
			storage[0][j]= j; //0th row jth column mai jo bhi dusre string ki length bachi woh hai edit distance hoga.
		}
		
		//first column keliye 
		for( int i=0; i<= m; i++) {
			storage[i][0]= i; //oth column ith row mai dalenge
		}
		
		//storage[i][j] fill karna hai
		for( int i=1; i<= m; i++) {
			for( int j=1; j<=n ;j++) {
				//storage[i][j] fill karne ka decision depend karega dono string ke corresponding characters pe.
				if(s.charAt( m - i ) == t.charAt( n - j )) { //last se 'ith' and last se 'jth' character compare hoga.
					//if they match to muje remaining string ka edit distance nikalna hai so,
					storage[i][j]= storage[i - 1][j - 1];
				}else {
					//agar match nhi hua to teeno options mese jo best hai woh aur +1
					storage[i][j]= 1 + Math.min(storage[i][j-1], Math.min( storage[i - 1][j], storage[i - 1][j - 1]));
				}
			}
		}
		return storage[m][n];
	}

	public static void main(String[] args) {

		String s= "adjfjfd";
		String t= "riengf";
		System.out.println(editDistanceDP(s,t));
		
	}

}
