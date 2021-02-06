Code: Min Steps to One using DP

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If n is divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If n is divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  

Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.

Constraints :
1 <= n <= 10 ^ 6

Time Limit: 1 sec
Sample Input 1 :
4
Sample Output 1 :
2 
Explanation of Sample Output 1 :
For n = 4
Step 1 :  n = 4 / 2  = 2
Step 2 : n = 2 / 2  =  1 

Sample Input 2 :
7
Sample Output 2 :
3
Explanation of Sample Output 2 :
For n = 7
Step 1 :  n = 7 ­- 1 = 6
Step 2 : n = 6  / 3 = 2 
Step 3 : n = 2 / 2 = 1 

Code:


public class TakeNumberToOneDP {
	
	//humara target firse yeh array fill karna hai
	//ek cell(basecase, 1th index) ka answer humare as hoga to hum 2nd cell ka answer nikal payenge and so on hum aage proceed kar payenge, so hume bottom up approach follow karna hai niche se jake har entry ko fill krte jayenge
	public static int countStepsDP(int n) {
		int storage[]=  new int[n+1]; //although n calls honge, but n+1 size ka lere coz indexing 0 se start hogi ( suppose n=10 hai to 10th index pe number of steps store honge 10 ko 1 tak le jane keliye so 10 as an index chahiye but indexing 0 se start hoti hai so 11(0 to 10) elements hone chahiye tabhi mai 10 ko as an index kar paunga.)
		//pehle basecase ke corresponding array mai dal denge tabhi next cell ka nikal payenge
		storage[1]= 0; //storage 1 wala basecase
		
		// ab hume i=2 se i<=n tak har cell ko ek ek karke calculate karna hai, ki uske andar kya value stored hai
		 for( int i=2; i<=n ; i++) {
			 
			 int min= storage[i-1]; // op1 (-1)
			 
			 if( i % 3==0) { //op2 : 
				 // hum isime compare karenge ki min bada hai i/3 se? agar nhi hai to min ko update kardena chahiye
				 if( min > storage[i/3]) { // i/2 ka jo answer hai usse min bada hai to min ko update kar dena chahiye
					 min= storage[i/3];
				 }
			 }
			 
			 if( i % 2==0) {
				 // hum isime compare karenge ki min bada hai i/2 se? agar nhi hai to update it
				 if( min > storage[i/2]) { // i/2 ka jo answer hai usse min bada hai to min ko update kar dena chahiye
					 min= storage[i/2];
				 }
			 }
			 
			 //iss line pe storagr[i] keliye jo best answer hai woh aa chuka hai
			 storage[i]= 1 + min;
			 // storage ke woh index pe kitne steps hume lage uss index ko 1 tak pohochne mai woh store hoga, means har index pe uske corresponding number of steps store hongi
		 }
		 //humara target n ko kitne steps lagte 1 tak pohochne mai yeh tha, so storage array ke n index pe jo value hogi woh humara answer hai
		 return storage[n]; 
	}

	public static void main(String[] args) {
		int n= 100;
		System.out.println(countStepsDP(n));
	}

}
