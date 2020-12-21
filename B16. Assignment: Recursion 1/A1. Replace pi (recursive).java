Replace pi (recursive)

Given a string, compute recursively a new string where all appearances of "pi" have been replaced by "3.14".

Sample Input 1 :
xpix
Sample Output :
x3.14x

Sample Input 2 :
pipi
Sample Output :
3.143.14

Sample Input 3 :
pip
Sample Output :
3.14p

Code:

public class solution {

	// Return the changed string
	public static String replace(String input){
        if (input == null || input.length() <= 1 ) {
    		return input;
    	}
    	return input.replace("pi", "3.14");                        
       
	}
}
