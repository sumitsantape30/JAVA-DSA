Extract Unique characters

Given a string S, you need to remove all the duplicates. That means, the output string should contain each character only once. The respective order of characters should remain same, as in the input string.
Input format:
The first and only line of input contains a string, that denotes the value of S.
Output format :
The first and only line of output contains the updated string, as described in the task.

Constraints :
0 <= Length of S <= 10^8
Time Limit: 1 sec

Sample Input 1 :
ababacd
Sample Output 1 :
abcd
Sample Input 2 :
abcde
Sample Output 2 :
abcde

Code:

import java.util.HashMap;
public class solution {

	public static String uniqueChar(String str){
		
        String output = "";
		HashMap<Character, Integer> exist = new HashMap<>();
		
		for( int i = 0;i < str.length(); i++ ) {
			
			if( exist.containsKey( str.charAt(i) )) {
				
				continue;
			}
			output += str.charAt(i) ;
			exist.put( str.charAt(i), 1);
		}
		
		return output;
	}
}
