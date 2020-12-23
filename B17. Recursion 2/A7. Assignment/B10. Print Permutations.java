Print Permutations

Given an input string (STR), find and return all possible permutations of the input string.

Note:
The input string may contain the same characters, so there will also be the same permutations.
The order of permutations doesn’t matter.

Input Format:
The only input line contains a string (STR) of alphabets in lower case
Output Format:
Print each permutations in a new line

Note:
You do not need to print anything, it has already been taken care of. Just implement the function.  

Constraint:
1<=length of STR<=8
Time Limit: 1sec

Sample Input 1:
cba
Sample Output 1:
abc
acb
bac
bca
cab
cba

Code:

public class solution {

	public static void permutations(String input){
		String output = "";
        permutation(input, output);

	}
    private static void permutation(String input, String output) {
        if(input == null || input.length() <= 0 )
        {
            System.out.println(output);
            return;
        }   
        
        for(int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            String ans = input.substring(0,i) + input.substring(i+1);
            permutation(ans, ch + output);
        }
    }
}
