package Restart;

import java.util.Scanner;

public class Practice {

	
	public static void main(String[] args) {

		String str= "abcdefghi";
		str= "abc"; //str ab "abc" ko refer karra
		System.out.println(str); 
		
		//way to concat
		str= str+ "def"; // str ab inko conactanet karega and usko refer karega.
		System.out.println(str); //Output: abcdef
		
		//There is concat function as well jo concat krke new string return karta hai
		str= "abc";
		str= str + "def";
		System.out.println(str.concat("ghi")); //Output: abcdefghi
		
		//concat function purane string mai koi change nhi krta so str ki value wahi rahegi jo concatenation se pehle thi.
		System.out.println(str); // Output: abcdef
		
		
	}
}
