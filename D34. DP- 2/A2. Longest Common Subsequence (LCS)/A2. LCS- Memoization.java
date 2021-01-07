
public class LCSM {
	
	public static int lcsM(String s, String t) { //input will be two strings
		
		//storage chahiye coz hume length store karni hai coz length hi return karni hai
		int storage[][]= new int[s.length() + 1][t.length() + 1];
		
		//storage array ko -1 se intialise kardete h to indicate ki humne value calculate nhi kari hai
		for( int i=0; i< s.length() +1; i++) {
			for( int j=0; j< t.length() + 1 ; j++) {
				storage[i][j] = -1;
			}
		}
		
		//hum storage array bhi pass karenge so lcs ke corresponding aur ek function bana lena chahiye
		return lcsM(  s,  t, storage);
	}
	
	
	public static int lcsM(String s, String t, int[][] storage) {
          int m= s.length();
          int n= t.length();
         
          
          // m length and n length ka result storage[m][n] pe store hoga so we should check ki waha already result calculated hai ya nhi
		 if( storage[m][n] != -1) {
			 return storage[m][n]; //agar waha -1 nhi hai(means calculated h) to storage array mai m*n index pe jo length hogi usko return kar denge.
		 }
		 
		 //basecase ke corresponding jo entries hongi unko storage array mai dal denge
		 if(m == 0 || n == 0) { //agar dono mese kisiki length 0 hai to lcs(length) bhi zero so storage array mai m*n index pe zero dal denge and wahi index pe rakhi hui length return kar denge
			 	 storage[m][n]=0;
			 	 return storage[m][n];
		 }
		 
		 //yaha tak aye means already calculated bhi nhi hai aur basecase bhi nhi so hume calculate karna hoga
		 
		 //dono string ka first character equal hai ya nhi uske basis pe decide karenge ki hume kam kya karna hai
		 if( s.charAt(0) == t.charAt(0)) { //agar dono string ka first character same rha
			storage[m][n] = 1 + lcsM(s.substring(1), t.substring(1), storage); //dono string ko ek ek character se chota kar denge and iska jo bhi answer ayega usme +1 kardenge overall lcs nikalne keliye.(coz 0th character bhi include rahega overall mai isliye +1 kiye)
		    return storage[m][n];
		
		 }else { 
			 
			 //aagar pehle character match nhi krta to hume apne options explore karna chahiye
			 int op1= lcsM(s, t.substring(1), storage); //pehli string ko as it is rakho dusre string ka ek character reduce karo and sathme storage array bhi pass karenge
			 int op2= lcsM(s.substring(1), t, storage); //pehli string ko ek character se reduce karo aur dusri string ko as it is rakho.
			 
			 //dono mese jiski max length hogi woh storage karke return karna chahiye
			 storage[m][n]= Math.max( op1, op2);  
		 }
		   return storage[m][n]; // humare storage array mai m*n index pe longest length aagyi hai so hum us length ko return karenge.
	}
//isme hum (m+1)(n+1) maximum calls karre
// we compromised space here as extra array use kr rhe hai but hum time ko boht save kr pa rhe hai, recursive wale ka time complexity exponential tha to exponential se (m+1)(n+1) pe la pa rhe hai


	public static void main(String[] args) {

		String s= "dgei";
		String t= "begi";
		System.out.println(lcsM(s,t));
	}

}
