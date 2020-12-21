Pair star

Given a string S, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*".

Input format :
String S
Output format :
Modified string

Constraints :
0 <= |S| <= 1000
where |S| represents length of string S.

Sample Input 1 :
hello
Sample Output 1:
hel*lo

Sample Input 2 :
aaaa
Sample Output 2 :
a*a*a*a

Code:

public class solution {

	// Return the updated string
	public static String addStars(String s) {
		// Write your code here
        return addString(s, 0, 1);
	}
    private static String addString(String s, int start, int end) {
		
		if(end == s.length())
		{
			return s;
		}
		if(s.charAt(start) == s.charAt(end)) {
			
			s = s.substring(0, end) + "*"+ s.substring(end , s.length());
			
		}
		return addString(s, start + 1, end + 1);
	}
}
