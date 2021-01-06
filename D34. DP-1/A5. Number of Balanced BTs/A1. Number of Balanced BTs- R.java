Code: Number of Balanced BTs

Given an integer h, find the possible number of balanced binary trees of height h. You just need to return the count of possible binary trees which are balanced.
This number can be huge, so, return output modulus 10^9 + 7.
Write a simple recursive solution.

Input Format :
The first and only line of input contains an integer, that denotes the value of h. Here, h is the height of the tree.
Output Format :
The first and only line of output contains the count of balanced binary trees modulus 10^9 + 7.

Constraints :
1 <= h <= 24
Time Limit: 1 sec

Sample Input 1:
3
Sample Output 1:
15

Sample Input 2:
4
Sample Output 2:
315

Code:


public class NumberOfBalancedBTs {
	
	//  you can use long datatype coz value goes out of range(integer ke range ke bahar but long ki range ke andar) when h=6, it gives -1006181013 for int datatype, the count cannot be negative so use long
    // But agar return type integer hi hai to we will take modulo, we will take modulo of 10^9+7, modulo lene ke bad value isi range mai ayegi

	//modulo kyu lere iske niche wala function study karo
	public static int countBalancedBTs(int h) { // input will be height h

		int mod= (int)Math.pow(10, 9) + 7; //it returns double value so typecast in int
		
		 return countBalancedBTs(h, mod); //humne alag function banaya taki bar bar mode na nikalna pde
	}
	
	public static int countBalancedBTs(int h, int mod) { // input will be height h

		if (h == 0 || h == 1) { // height zero(height zero matlab empty tree, null hai) or 1 hai hum uska ek hi binary tree bana skte hai so return 1
			return 1;
		}

		// agar height zero ya one nhi hai to muje teeno configurations ko consider karna padega, aur teeno configurations ko consider karne keliye let's say (h-1) height ke x trees hai aur (h-2) height ke y trees hai, and yeh muje recursion se milega

		int x = countBalancedBTs(h - 1); // h-1 height ke kitne balanced binary trees hai yeh muje recursion se milega and mai use x mai store kr rha hu
		int y = countBalancedBTs(h - 2);// h-2 height ke kitne balanced binary trees hai yeh muje recusrsion se milega and mai use y mai store kr rha hu

		// total combination(possible number of balanced binary trees) is the sum of all three configurations
		// hum chahte hai jo answers aye integer ki range mai ho so iss pure ka mod lenge
		
		// return x*x + 2*x*y; == if we use this, the result we will be getting for h= 7,8 etc. kaafi bada hoga to store into an integer, integer mai maximum number hum 2^31-1 store kr skte hai so range full hone ke bad woh first starting se negative se start hota hai isliye hum modulo lenge taki humara result integer hi rhe
	    //return x*x + 2*x*y aise directly calculate nhi karna chahiye, separately calculate karke unko long mai store karenge *kyu long mai karre iske liye niche wali line padho*
		// (x*x means we're doing int*int so it results in integer, but x*x ka result integer ki range se bada hai isliye usko typecaste karenge, x*x's result is very big aur uss big number ko hum int mai nhi dal skte nhito woh -ve number dega )
        // x*x integer mai store nhi ho pa rha hai so first store this(x*x) result into a long and then convert that long into integer
		long res1= (long)x * x; // convert one of them(x ko kiya) into long then long*int will be long
		long res2= (long)x * y * 2;
		 
		//hum chahte hai jo answers aye integer ki range mai ho isliye res1 and res2 ko modulo lenge, and modulo ke bad jo answer ayega that will be an integer. agar maine (x*x + 2*x*y) % mod kiya hota to problem hoti coz x*x ka jo answer ara hai woh bada ho integer ki range se bahar ho aur shayd negative hora ho aur negative number ka mod nhi le skte. isliye humne break kara pehle x*x pe kam kiya then 2*x*y pe kam kiya fir add karne ke bad firse modulo liya
		int value1= (int)(res1 % mod);
		int value2= (int)(res2 % mod);
		return (value1 + value2) % mod; 
		
	}
	
	public static void main(String[] args) {

		int h=6;
		int ans= countBalancedBTs(h);
		System.out.println(ans);
		
	}

}
