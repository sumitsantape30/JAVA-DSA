Code: Edit Distance(Memoization and DP)

You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character

Note :
Strings don't contain spaces in between.

Input format :
The first line of input contains the string S of length M.
The second line of the input contains the String T of length N.

Output format :
Print the minimum 'Edit Distance' between the strings.

Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9

Code:


public class EditDistanceM {

	public static int editDistanceM( String s, String t) { //input will be two strings
		
		//we would need a storage array, storage array ka size jitne unique calls karenge utna rahega
		int m= s.length();
		int n= t.length();
		int storage[][]= new int[m+1][n+1];
		
		//storage array bnake bad uske har cell pe zero hota hai, but ho skta hai ki do strings ka edit distance zero ho so array mai initially aisi value dalni chahiye jo bataye ki abhi value calculate nhi hui hai so hum array mai -1 dal rhe hai which indicates ki value calculate nhi hui hai
		for( int i=0; i<= m; i++) {
			for( int j=0; j<= n; j++) {
				storage[i][j]=-1;
			}
		}
		//ek aur function banayenge jise hum dono strings denge aur edit distance store karne keliye storage array denge
		return editDistanceM(s,t, storage);
	}
	
	//yahape hum apna kam recursively karne wale hai
	private static int editDistanceM(String s, String t, int storage[][]) {

		int m= s.length();
		int n= t.length();
		
		//kuch bhi kam karne se pehle check karlete hai, kya storage[m][n] not equal to -1 hai, agar not equal to -1 hai matlab humne calculate krke rakha hai so, we should return that
		if( storage[m][n] != -1) {
			return storage[m][n];
		}
		
		//agar calculated nhi hai to calculate karenge, sabse pehle check krte hai ki kahi basecase mai to lies nhi kr rhe
		if( m == 0) {
			storage[m][n]= n; // agar pehli wali string(m) ki length zero hui to dusri(n) wali ki length jitne operations karne padegne to make them similar
		    return storage[m][n];
		}
		
		if( n == 0) {
			storage[m][n]= m; //agr dusri wali string(n) ki length zero hai to pehli(m) wali ki length itne operations karne honge to make them similar
		    return storage[m][n];
		}
		
		//agar upar wale sabhi cases mai nhi aya means hume calculate karna padega so hum string ke pehle character ke basis pe decide karenge hume kya karna hai
		
		if( s.charAt(0) == t.charAt(0)) { //agar dono string ka first character same hua to bachi hui string ka eidt distance mangwayenge and storage array mai store karenge taki next time iski jarurat pdi to hum ise use kar paye
			storage[m][n]=  editDistanceM(s.substring(1), t.substring(1), storage);
		}else {
		 //agar first character match nhi krta to humare pas teen options hai insert,delete,substitute, teeno options ke answers mangwate hai and usme se minimum wala rakhenge.
					
			//insert
			int op1= editDistanceM(s, t.substring(1), storage);
					
			//delete
			int op2= editDistanceM(s.substring(1), t, storage);
					
			//substitue
			int op3= editDistanceM(s.substring(1), t.substring(1), storage);
					
			//teeno mese jo minimum hoga usko storage array mai store karenge taki next time iski jarurat pdi to hum ise use kar paye.
			storage[m][n]=  1+ Math.min(op1, Math.min(op2, op3)); // 1+ karre coz humne ek operation pakka kara hi hoga.
						
		}
		//finally jab storage[m][n] ki value aagyi hai to storage ko return kar skte.
		return storage[m][n];
	}

	public static void main(String[] args) {

		String s= "adef";
		String t= "gbde";
		System.out.println(editDistanceM(s,t));
		
	}

}
