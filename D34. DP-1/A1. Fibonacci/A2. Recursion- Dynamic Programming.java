
public class fibonacci2 {
	
	public static int fib(int n) {
		if( n==0 || n== 1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibM( int n) {
		// Sabke unique result store karne keliye we need array of size n+1
		int storage[]= new int[ n+1 ];
		
		//initially storage array mai koi value nhi dali humne, result calculated nhi hai yeh signify karne keliye hum storage array ki har entry pe -1 dal dete hai
		for( int i=0 ;i<= n ;i++) {
			storage[i]= -1;
		}
		
		 return fibM(n ,storage) ;
	}

	private static int fibM(int n, int storage[]) {
		if( n==0 || n== 1) {
			storage[n]=n;
			return storage[n];
		}     
    // sabse pehle check karna padega ki result already pda hua h ya nhi
		if( storage[n] != -1) { // agar -1 nhi hai matlab result aa chuka hai isliye return karna padega
			return storage[n];
		}
		
		// agar result nhi aya hua hai to recursion call karna padega and usko array mai store karna padega
		 storage[n]=  fibM( n-1, storage) + fibM( n-2, storage);
		 return storage[n];
	}

	public static int fibDP(int n) {
		
		int storage[]= new int[n+1]; // n+1 size ka (coz n+1 unique calls the) Storage array chahiye, jisme hum apna result store kar paye.
        
		//basecase ke corresponding entries kar rhe 
		storage[0]= 0;
		storage[1]= 1;
		// ab hume pehle do index fill kardiye ab array mai baki sab mai by default 0 rahega(initially calculated nhi h)
		
		// fibonacci series ka 0th 1th agya hai 2th calculate kr skte then 3 4..uss direction mai move karna hai isliye for loop lagayenge
		for(int i = 2; i <= n ; i++) {
			storage[i]= storage[i-1]+ storage[i-2];  //storage array ka ith cell ka result nikalna hai isliye storage array ke do cell piche walo ko add kar dena chahiye
	    //array mai i-1 index pe i-1 fibonacci number and i-2 fibonacci number hoga so unko add krke next wala nikal rhe
		}
		
		//jab pura kam hojaye to hum storage array mai n index pe jo value hai usko return kr denge means storage[n] return kardenge.
		return storage[n];
		
	}
	
	public static void main(String[] args) {
     //nth fibonacci number nikalna hai
		int n =44;
		System.out.println(fibDP(n));
		System.out.println( fibM(n)); // O(n)-- Fast
		System.out.println( fib(n) ); // O(2^n)-- slow
		
	}

}

Output:

701408733
701408733
701408733

