Compress the String

Write a program to do basic string compression. For a character which is consecutively repeated more than once, replace consecutive duplicate occurrences with the count of repetitions.

Exmple:
If a string has 'x' repeated 5 times, replace this "xxxxx" with "x5".
The string is compressed only when the repeated character count is more than 1.

Note :
Consecutive count of every character in the input string is less than or equal to 9.

Input Format:
The first and only line of input contains a string without any leading and trailing spaces.

Output Format:
The only line of output prints the updated string.

Note:
You are not required to print anything. It has already been taken care of.

Constraints:
0 <= N <= 10^6
Where N is the length of the input string.

Time Limit: 1 second

Sample Input 1:
aaabbccdsa
Sample Output 1:
a3b2c2dsa
Sample Input 2:
aaabbcddeeeee
Sample Output 2:
a3b2cd2e5

Code:

// highest occurring character in the String.
public class solution {

	public static char highestOccuringCharacter(String inputString) {
		int noOfChars = 256;
		int a[] = new int[noOfChars];
		char c = 0;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < inputString.length(); i++)
		{
			int ch = (int) inputString.charAt(i);
			//System.out.print(ch +" ");
			//System.out.println((++a[ch]) + " ");
			if((++a[ch]) > max)
			{
				max = a[ch];
				c = (char) ch;
			}
			
		}

		return c;

	}
}
