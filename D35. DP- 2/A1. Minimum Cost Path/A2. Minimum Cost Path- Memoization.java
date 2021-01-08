
public class MinimumCostPathM {

	public static int minCostPathM(int arr[][]) { // input will be 2D array.

		// path nikalne keliye muje i and j bhi chahiye honge isliye ek aur function banate
        
		int m= arr.length;
		int n= arr[0].length;
		int storage[][]= new int[m][n];	//har i and j ke different value keliye diffrent cost ane wala hai so, i and j ke sath cost vary karne wala hai so jo storage array hoga woh m x n size ka hoga.( 2D matrix hoga)
        //cost to travel from i,j to end will be stored in storage array

		for( int i=0; i<m ; i++) {
			for( int j=0; i<n; j++) {
				storage[i][j]= -1; //just to indicate ki storage i,j pe abhi koi value stored nhi hai so storage i,j pe -1 dal dete hai just to tell ki humne abhi kuch store nhi kara hai
			}
		}
		return minCostPathM(arr, 0, 0, storage); // initially i and j (0,0) pe rahega, muje (0,0) se end tak ka path chahiye and store karne keliye muje storage bhi chahiye isliye storage bhi pass karenge.

	}

	//Memoization ke simple funda: as soon as you calculate a value just memorize it, aur agar already storage array mai stored hai to dubara nikalni na pde
	private static int minCostPathM(int[][] arr, int i, int j, int[][] storage) {
		
		
		int m= arr.length; //Number of rows
		int n= arr[0].length; //Number of Columns
		
		
		if( i >=m || j>= n) { //agar dono mese koi ek range ke bahar gya matlab grid se bahar chale gye hai aur wahase end tak ki path nikal rhe but koi path nhi hai, so path nhi hai to uski cost +infinity kardete.
			return Integer.MAX_VALUE;
		}
		
		//jaise recursion mai basecase waise yahape bhi dal dete hai
		if( i== m-1 && j== n-1) { //This basecase means jaha tumhara destination hai, tum wahi ho, last cell pe hai hum
			storage[m-1][n-1]= arr[i][j];// storage array mai i,j ki value dal dete hai coz hum last cell pe hai
			return storage[i][j];  //last cell se last cell tak reach karneki cost will be usi cell ki value
		}
		
		//yaha pahuche tab teeno options pe recursion call krne se pehle hume check karna chahiye jo value hume chahiye woh already calculated hai ya nhi
		if( storage[i][j] != -1) { //storage array mai iss index pe rakhi hui value agar not equal to -1 hai means woh already calculated hai, calculated hai so ab hume recursion ki bhi jarurat nhi hai humare pas answer stored pda hai wahi answer return kardenge 
			return storage[i][j];//agar calculate kar chuka hai to answers return kardena chahiye.
		}
		
		//agar calculated nhi hai to hume teeno option nikalna padega
		int op1= minCostPathM(arr, i, j+1, storage); //Right
		int op2= minCostPathM(arr, i+1, j+1, storage); // Daigonally
		int op3= minCostPathM(arr, i+1, j, storage); // Downside
		
		//finally in teeno mese jo jiski sabse minimum cost hogi hum use apne pas rakhenge storage mai
		storage[i][j]= arr[i][j]+ Math.min( op1, Math.min(op2, op3));
		return storage[i][j];
	}
 
	public static void main(String[] args) {

		int arr[][] = {{1,1,1}, {4,5,2},{7,8,9}};
		System.out.println(minCostPathM(arr));
		
	}

}

Output:
13
