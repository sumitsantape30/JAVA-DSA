
public class Factorial {
	
	public static int fact(int n) {
		
		if(n==0) { //basecase is where, you want your problem to stop
			return 1;
		}
		int smallAns= fact(n-1); //hume pehle factorial (n-1)! ka niklana padega then usko n ke sath multiply karna padega
		return n*smallAns;
	}

	public static void main(String[] args) {
		int n=5;
		int ans= fact(n);
		System.out.println(ans);

	}

}
