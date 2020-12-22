
public class print_Subsequences {

	//bas print karna hai kuch return nhi karna so void
	public static void printSubsequences(String input, String outputSoFar) { //outputSofar means abhitak kitna output hum construct kar chuke hai woh
		
		if (input.length() == 0) { //har level pe input ka har character ke corresponding ek ek karke hum decision le rhe finally jab input string empty hojayegi, iska matlab hum har character ka decision le chuke hai and jo decision le rhe woh store outputSofar mai ho rha. iska matlab outputSofar mai jab input empty hojayega to final decision aa chuka hoga
			//agar input khali ho chuka hai, input ke saare characters decision le chuke hai to outputSoFar mai result hoga use print karenge.
			System.out.println(outputSoFar);
			return;
		}
		
		//agar input khali nhi hua hai means koi characters reh gye hai, so unke decision lene padenge.
		
		// We chose not to include the first char
		//agar mai xyz mese x ko include nhi krta to output mai koi change nhi hona chahiye.
		printSubsequences(input.substring(1), outputSoFar); //hum 'x' ka decision le chuke hai to jo remaining string reh gyi hai, jiska decision lena baki hai woh 1 se aage ki hai
		
		// We chose to include the first char
		// humne decide kiya hai ki x(first character) ko inlclude karna hai to hum first character ko output ke andar add kardete hai
		printSubsequences(input.substring(1), outputSoFar + input.charAt(0));

	}

	
	public static void printSubsequences(String input) {

		//hume output store karne keliye bhi ek string chahiye jisme hum apna output store karre honge.
		//woh output string(jisme hum apna output rakhenge) user nhi dega hume apne signature ke according chahiye so create other function. 
		printSubsequences(input, "");

	}

	public static void main(String[] args) {
		printSubsequences("xyz");

	}

}

Output:
   (Empty String)
z
y
yz
x
xz
xy
xyz
