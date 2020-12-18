Check Permutation

For a given two strings, 'str1' and 'str2', check whether they are a permutation of each other or not.
Permutations of each other
Two strings are said to be a permutation of each other when either of the string's characters can be rearranged so that it becomes identical to the other one.

Example: 
str1= "sinrtg" 
str2 = "string"

The character of the first string(str1) can be rearranged to form str2 and hence we can say that the given strings are a permutation of each other.

Input Format:
The first line of input contains a string without any leading and trailing spaces, representing the first string 'str1'.
The second line of input contains a string without any leading and trailing spaces, representing the second string 'str2'.

Note:
All the characters in the input strings would be in lower case.

Output Format:
The only line of output prints either 'true' or 'false', denoting whether the two strings are a permutation of each other or not.
You are not required to print anything. It has already been taken care of. Just implement the function. 

Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second
Sample Input 1:
abcde
baedc
Sample Output 1:
true
Sample Input 2:
abc
cbd
Sample Output 2:
false

Code: 

import java.util.*;
public class solution {

	public static boolean isPermutation(String input1, String input2) {
	    // Write your code here
        int n = input1.length(), m = input2.length();
	    if(n != m)
	    {
	    	return false;
	    }
	    char []c1 = input1.toCharArray();
	    char []c2 = input2.toCharArray();
	    
	    Arrays.sort(c1);
	    Arrays.sort(c2);
	    
	    for(int i = 0; i < n; i++)
	    {
	    	if(c1[i] != c2[i]) {
	    		return false;
	    	}
	    }
        return true ;
	}
}

