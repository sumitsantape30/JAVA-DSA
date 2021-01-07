
public class LCS {
	
	public static int lcs( String s, String t) { //Input will be two strings, hume s or t ke 0th character ke basis pe kam karna hai
		
		//Basecase will be, agar input mai dono mese ek bhi string ki length zero hai to inka LCS hum calculate hi nhi kr skte coz kuch common hi nhi hai so return 0
		if( s.length()==0 || t.length()==0 ) { //dono mese ek bhi string ki length 0 hai to uska LCS zero hi hoga
			return 0;
		}
		
		//agar s and t non zero hai, exist krte hai to hume unke first character ko compare karna chahiye
		//agar 0th char match hua to LCS ki length at least 1 hogi, means our LCS will be 1 + remaining string ka jobhi LCS hai woh. so first character ko chodke remaining string ka LCS mangwate hai using recursion
		if( s.charAt(0) == t.charAt(0)) {
			return 1+ lcs(s.substring(1), t.substring(1)); //pehla character match hogya to usko chhodo aur baki characters ka LCS nikalo aur jo first character hai usko add karo for overall LCS
		}else { 
			
			//agar pehla char match nhi kara to humare pas teen options hai
	
			int op1= lcs(s, t.substring(1)); //pehli wali string ko pura rakhenge aur dusri wali string ka first character ignore karke LCS nikalenge
			int op2= lcs(s.substring(1),t); //pehli string ka first character ignore karenge and dusri wali string ko pura rakhe LCS nikalenge
			//int op3= lcs(s.substring(1), t.substring(1)); no need to consider option3 *explanation keliye, open book*
			
			//teeno mese jiska bhi max LCS hoga wahi humara answer hai 
			//return Math.max(op1, Math.max(op2,op3)); 
			return Math.max(op1, op2);
					
		}
		
	}

	public static void main(String[] args) {

		String s= "adgei";
		String t= "abegi";
		System.out.println(lcs(s,t));
	}

}

Output:
3
