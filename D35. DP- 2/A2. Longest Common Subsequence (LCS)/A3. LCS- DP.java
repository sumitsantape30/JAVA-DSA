
public class LCSDP {

	public static int lcsDP( String s, String t) { // input will be two strings
		
		//hume storage array banana hoga
		int m= s.length();
		int n= t.length();
		
		int storage[][]= new int[m+1][n+1];
		
		//iss storage array mai basecase ke corresponding entries fill karete hai, basecase ke corresponding hume first row and first column hai woh zero rahega, coz our basecase says koi bhi ek string ki length zero rhi to LCS zero hoga. 
		for( int i=0; i<= m; i++) {
			//first column ki saari rows fill kr dete hai with zero
			storage[i][0]= 0; //humare first column mai row ka index zero hi hoga isliye pure row mai zero dalenge
		}
		
		//similarly first row mai zero dal denge as basecase
		for( int i=0; i<n; i++) {
			//first row ko fill karenge with zero
			storage[0][i]= 0; // humare first row mai column ka index zero hi rahega
		}
		//first row and column mai zero aagya ab remaining cells ko fill karenge, hum form left to right fill karenge.
		//abhi remaining cells ko fill karna hai so i=1 hoga
		for( int i=1; i<=m ; i++) {
			for( int j=1; j<=n ; j++) {
				//storage i,j wale ko fill karne keliye we need to check ki do characters match krte hai ya nhi
			
				// char at which index of both the strings should be compared
				//mai last se ith aur last jth character compare karra hunga( last se first character ko compare karna hoga)
				if( s.charAt(m-i) == t.charAt(n-j)) { //hum last se first character ko compare karenge
					// *memoization wale code mai dekho first character same rha to kaise first wale ko chhodke baki ka answer late*
				storage[i][j]=  1 + storage[i-1][j-1]; //agar i,j length bachi hai to i-1 and j-1 pe result pda hoga
				
			  }else { //agar first chracter match nhi krte to storage i,j fill karne keliye max nikalna hoga
				  storage[i][j]= Math.max(storage[i][i-1], storage[i-1][j]); // *memoization wale code mai dekho first character match nhi hua to kaise solve krte the*
				  
			  }
		   }
		}
		   //jab dono ki string ki length full hai to woh dono string ka LCS kya hai woh return karenge
		   return storage[m][n];
	}
	
	public static void main(String[] args) {

		String s= "dgei";
		String t= "begi";
		System.out.println(lcsDP(s,t));
		
	}

}

Output:2
