Code: Min Steps to One

Given a positive integer 'n', find and return the minimum number of steps that 'n' has to take to get reduced to 1. You can perform any one of the following 3 steps:
1.) Subtract 1 from it. (n = n - ­1) ,
2.) If its divisible by 2, divide by 2.( if n % 2 == 0, then n = n / 2 ) ,
3.) If its divisible by 3, divide by 3. (if n % 3 == 0, then n = n / 3 ).  
Write brute-force recursive solution for this.

Input format :
The first and the only line of input contains an integer value, 'n'.
Output format :
Print the minimum number of steps.

Constraints :
1 <= n <= 200

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


public class TakeNumberToOne {
	
	//hum teeno options ko bolenge ki apne apne number of steps leke aao jiske steps sabse minimum honge wahi answer
	public static int countSteps(int n) { //To count the number of steps 
		//we are assuming given value will 1 or greater than 1
		
		if( n == 1) { //This is basecase : you can say smallest problem we can solve
			return 0; //agar n=1 hai to 1 ko 1 tak le jane mai hume koi steps perform nhi karne so return number of steps= 0
		}
		
		int op1= countSteps(n-1); //(substract karne ka option humesha rahega) n-1 ko 1 tak lane mai jitne bhi steps lagenge woh 
		int minSteps= op1; //initially op1 mai jitne steps aaye wahi answer hai humara
		
		//explore Option2 : agar 3 se divide hota hai to options 2 bhi nikal lenge
		if( n % 3 == 0) {
			int op2= countSteps( n/3 ); //Number of steps to make n/3 to 1
			if( op2 < minSteps) {
				minSteps= op2; // agar op2 mai kam steps lage hai than minSteps to minSteps ko update kr dete h	
			}
		}
		
		//option3
		if( n % 2 == 0) {
			int op3= countSteps( n/2 ); // number of steps to take n/2 to one
			if ( op3 < minSteps ) {
				minSteps= op3; // agar op3 better hai minSteps se to minSteps ko update krdo	
			}
		}
		
		//finally mere pas minSteps mai sahi answer hoga
		return 1+ minSteps; // 1+ isliye kiya coz, jo step humne op1 mai peroform kiya usko bhi total number of steps mai consider karna padega.
	}
	
  public static void main(String[] args) {
 
		int n=10;
		System.out.println(countSteps(n));
		
	}

}
