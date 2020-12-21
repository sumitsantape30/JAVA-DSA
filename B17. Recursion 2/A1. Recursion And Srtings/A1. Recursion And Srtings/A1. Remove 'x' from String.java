package Restart;

import java.util.Scanner;


public class Recursion {

	public static String removeX( String str) {
		
		if( str.length()==0) { //simplest problem jisme hume kuch complicated recursionlogic nhi lagana, agar string empty rhi to hume koi kam nhi karna we can directly return it
			return str;
		}
		
		String ans= ""; //answer nhi pta so empty hai
		//first character ko check karna humara kam hai
		if( str.charAt(0) != 'x') { //agar first character 'x' nhi hai to woh answer ka part hona chahiye.
			ans= ans+ str.charAt(0);
		}
		
		//hum recusion ko bolenge baki string ke upar kam krke humko answer lade.
		// removeX hume saare 'x' remove hone ke badki jo corrected string hai woh dega, woh corrected string hum smallAns mai collect karre
		String smallAns= removeX(str.substring(1)); //0th index ka kam hum kar chuke hai so 1st se recusion karega
		return ans + smallAns; //jo corrected string hogi smallAns ke pas usko empty string mai add kr dena hai

	}
	
	public static void main(String[] args) {

		String str= "abcxbxxbrx";
		System.out.println(removeX(str));
	}

}
