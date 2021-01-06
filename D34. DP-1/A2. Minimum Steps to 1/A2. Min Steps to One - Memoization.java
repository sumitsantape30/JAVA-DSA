public class TakeNumberToOne {
	
	public static int countStepsM( int n) {
		//we'll need a strorage array
		int storage[]= new int[n+1]; //although n calls honge, but n+1 size ka lere coz indexing 0 se start hogi ( suppose n=10 hai to 10th index pe number of steps store honge 10 ko 1 tak le jane keliye so 10 as an index chahiye but indexing 0 se start hoti hai so 11(0 to 10) elements hone chahiye tabhi mai 10 ko as an index kar paunga.)
		//storage array mai hume results store karne hai so woh array bhi pass karna padega isliye helper function bana rhe h
		return countStepsM(n, storage);
	}
	
	private static int countStepsM( int n, int storage[]) {
		
		if( n== 1) { // agar n==1 rha to koi steps nhi h perform karne keliye
			storage[n]= 0; //zero steps hai isliye storage mai n index pe zero dal denge
			return storage[n];
		}
		
		//jo storage array humne banaya hai usme initially by default sabme zero rahega, calculated nhi hai isliye zero hai, agar zero nhi hai means humne answer calculate kar liya hai
		if( storage[0] != 0) { //checking if answer is already calculated or not (by default sabme zero rehta hai)
			return storage[0]; //agar calculate karli hai to hume recursion ki koi jarurat nhi hai we should straightly return calculated value
		}
		
		//agar calculated nhi hai to teeno cases ke answers nikalne padenge
		//countStepsM call karenge jisme n-1 and storage array bhi pass karenge
		int op1= countStepsM(n-1, storage); //(substract karne ka option humesha rahega) n-1 ko 1 tak lane mai jitne bhi steps lagenge
		int minSteps= op1;
		
		//Option2
		if( n % 3 == 0) {
			int op2= countStepsM( n/3, storage ); //Number of steps to make n/3 to 1
			if( op2 < minSteps) {
				minSteps= op2; // agar op2 mai kam steps lage hai than minSteps to minSteps ko update kr dete h	
			}
		}
		
		//option3
		if( n % 2 == 0) {
			int op3= countStepsM( n/2, storage );// number of steps to take n/2 to one
			if ( op3 < minSteps ) {
				minSteps= op3; // agar op3 better hai minSteps se to minSteps ko update krdo	
			}
		}
		
		// kyuki humne memoization karke answer nikala hai so usko storage n mai store karlena chahiye sirf blindly return nhi karna chahiye
		storage[n]= 1+ minSteps;// 1+ isliye kiya coz, jo step humne op1 mai peroform kiya usko bhi total number of steps mai consider karna padega.
		return storage[n]; //apne storage array ko return kardenge kyuki isko humne calculate karke rakha apne pas
	}

	public static void main(String[] args) {
 
		int n=10;
		System.out.println(countStepsM(n));
		
	}
}

Output: 3

