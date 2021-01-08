Code: Edit Distance

Given two strings s and t of lengths m and n respectively, find the edit distance between the strings.

Edit Distance
Edit Distance of two strings is minimum number of operations required to make one string equal to other. In order to do so you can perform any of the following three operations only :
1. Delete a character
2. Replace a character with another one
3. Insert a character

Note
Strings don't contain spaces

Input Format :
The first line of input contains a string, that denotes the value of s. The following line contains a string, that denotes the value of t.
Output Format :
The first and only line of output contains the edit distance value between the given strings.

Constraints :
1<= m,n <= 10
Time Limit: 1 second

Sample Input 1 :
abc
dc
Sample Output 1 :
2

Code:


public class EditDistanceR {

	public static int editDistance(String s, String t) { //dono strings input honge.
		// first character ka kam hum karenge and baki recursion.
		 
		 // Basecase: Donomese koi ek string ki length zero hai to edit distance durse string ki length rahegi coz hum dusre string ke length jitne operations perform karenge dono string ko equal ko karne keliye.
		if( s.length() == 0) {
			return t.length();
		}
		
		if( t.length() ==0) {
			return s.length();
		}
		
		//agar dono ki kuch kuch length hai to hume check karna chahiye ki unka first character same hai ya nhi
		if( s.charAt(0) == t.charAt(0)) {
			// agar pehla character same hai to first ko character ko equal banane keliye koi operation perform krne ki jarurat nhi hai so hum ab remaining string ka edit distance nikalenge, ki remaining string ko equal banane mai kitne operation lagenge
			return editDistance(s.substring(1), t.substring(1));
		}else {
			//agar first character match nhi krta to humare pas teen options hai insert,delete,substitute, teeno options ke answers mangwate hai.
			
			//assume ki humne ek operation pehlehi perform karliya hai ab baki bachi string ke upar perform karre
			//insert
			int op1= editDistance(s, t.substring(1)); //humne first string mai insert kiya to make both same so t ka pehla character chodke baki string ka edit distance nikalenge
			
			//delete
			int op2= editDistance(s.substring(1), t); //pehle string ka ek character delete kiya hai so first ka substring and second string as it is.
			
			//substitue
			int op3= editDistance(s.substring(1), t.substring(1)); //humne substitue kiya hai so donoke pehle character match hogye hai isliye dono string ka pehle character chodke bachi hui string ka edit distance nikalenge
			
			//finally we have to return 1+ minimum edit distance of these options
			return 1+ Math.min(op1, Math.min(op2, op3)); // 1+ karre coz humne ek operation pakka kara hi hoga, insertion ka ya fir deletion ka ya fir substitue ka opertion humne pehle kiya hi hoga 
				
		}
		
	}
	
	public static void main(String[] args) {

		String s= "ade";
		String t= "gbe";
		System.out.println(editDistance(s,t));
		
	}

}
