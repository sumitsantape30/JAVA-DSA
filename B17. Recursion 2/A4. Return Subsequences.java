
public class ReturnSubsequences {

	//saare subsequences return karega and as a array return karega so String[]
	public static String[] findSubsequences(String str) {

		if (str.length() == 0) { //simplest string jiska subsequence nikalne keliye humejada kam nhi krna padega is empty string, empty string ka ek hi substring hoga that is ""(Empty string)
			String ans[] = { "" };
			return ans;
		}
		
		String smallans[] = findSubsequences(str.substring(1)); // suppose 'xyz' hai to pehle saare 'yx' ke subsequences mangwa lenga smallans mai.
		String ans[] = new String[2 * smallans.length];//yeh final array hai jisme humara answer hoga. Jitni length hai smallans ki us length ka double kam karre pehla kam usko copy karna and dusra kam un sabke aage first character append karna.
                int k=0; //k ans array ka index hai
		//smallans ke jobhi subsequences the unko copy karre ans(final) array mai as it it copy karenge.
		for (int i = 0; i < smallans.length; i++) {
			ans[k] = smallans[i]; //humare ans array ke kth index pe smallans ke ith elements exactly copy karna hai
		    k++;
		}

		//ans array mai smallans ki har subsequence ke aage first character append karna hai
		for (int i = 0; i < smallans.length; i++) {
			//ans[i + smallAns.length] bhi likh skte the
			ans[k] = str.charAt(0) + smallans[i]; //jaha 'k' pehle chhoda hai wahise continue karenge
		    k++;
		}
		return ans;
	}

	public static void main(String[] args) {

		String str = ("xyz");
		String ans[] = findSubsequences(str); //array return karra to array mai store karna chahiye.
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}

	}

}

Output:
  (Empty String -"")
z
y
yz
x
xz
xy
xyz
