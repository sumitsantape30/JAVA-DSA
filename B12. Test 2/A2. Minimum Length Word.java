Minimum Length Word

Given a string S (that can contain multiple words), you need to find the word which has minimum length.

Note : If multiple words are of same length, then answer will be first minimum length word in the string.
Words are seperated by single space only.

Input Format :
String S
Output Format :
Minimum length word

Constraints :
1 <= Length of String S <= 10^5

Sample Input 1 :
this is test string
Sample Output 1 :
is

Sample Input 2 :
abc de ghihjk a uvw h j
Sample Output 2 :
a

Code:


public class Solution {
	
	public static String minLengthWord(String input){
		
		String minWord = "";
        int length = input.length();
        int s = 0, e = 0,  minlength = length, minStartIndex = 0;
        while(e <= length)
        {
            if (e < length && input.charAt(e) != ' ')
            {
                e++;
            } else {
                int currlength = e - s;
                if(currlength < minlength)
                {
                    minlength = currlength;
                    minStartIndex = s;
                }
                e++;
                s = e;
            }
        }
        minWord = input.substring(minStartIndex, minStartIndex + minlength);
        return minWord;

	}
}
