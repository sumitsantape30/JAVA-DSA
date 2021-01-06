
public class Fibonacci {
	
	//We want nth Fibonacci number
	public static int fib(int n) {
		if( n==0 || n== 1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
//fib(int n) wale function mai hum bohot sara repetitive kam kr rhe hai uske wajah se time complexity badh rhi hai so ab hum repetitive kam nhi karenge, jaisehi kuch pehli bar humne calculate kara hum uss result ko store krke rakh lenge taki next time muje uss result ki jarurat pade to i should not do that calculation part again
//kitne unique results ho skte hai ? let's say agar fibo(4) nikalna hai to fib(4) fib(3) fib(2) fib(1) fib(0) nikalna hoga means n=4 hai to 5 results ho skte hai so yeh unique result muje apne store karke rakhne hai, so woh store karne keliye ek array lete of size jitne unique calls hai means n+1 size ka. Aur array ke ith index pe fibonacci series ka ith element store karenge
	public static int fibM( int n) {
		// Sabke unique result store karne keliye ek array banayenge array of size n+1
		int storage[]= new int[ n+1 ];
		
		//initially storage array mai koi value nhi dali humne, result calculated nhi hai yeh signify karne keliye hum storage array ki har entry pe -1 dal dete hai
		for( int i=0 ;i<= n ;i++) {
			storage[i]= -1; 
		}
		
		//hume apne unique result array mai store karne hai isliye alag helper function banayenge
		 return fibM(n ,storage) ;
	}

	//this is Memoization technique, means hum memorise karre hai chizo ko
	private static int fibM(int n, int storage[]) { //yahape jaise pehle recursively krte the bulikul waisehi karenge
		if( n==0 || n== 1) {
			storage[n]=n; //basecase ke corresponding hum storage array mai n ki index pe n ki value store karenge and array return kar denge
			return storage[n];
		}     
      // fibo n-1 and n-2 pe call karne se pehle hume check karna padega ki answer already calculated hai ya nhi. agar calculated hai to recursion call karneki jarurat nhi hai. initially -1 hai agar mai calculate krte jaunga to mai array mai store krte jaunga
		if( storage[n] != -1) { // agar -1 nhi hai matlab answer already calculate kr liye hai result aa chuka hai, answer aya hua hai so we don't need to use recursion now we can simple return our array.
			return storage[n];
		}
		
		// agar result nhi aya hua hai to recursion call karna padega and uske result ko array mai store karna padega and then array return karenge
		 storage[n]=  fibM( n-1, storage) + fibM( n-2, storage);
		 return storage[n];

//isme hum kam(less) calls kr rhe hai, jada redundant calls nhi kr rhe to time complexity improve hoke became O(n).
	}

	public static void main(String[] args) {
 
		int n =40;
		System.out.println( fibM(n)); // O(n)-- Fast
		System.out.println( fib(n) ); // O(2^n)-- slow
		
	}

}
