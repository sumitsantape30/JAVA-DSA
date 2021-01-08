Coin Tower

Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower. The person to make the last move wins the game. Can you find out who wins the game?
 
 Input format :
The first and the only line of input contains three integer values separated by a single space. They denote the value of N, X and Y, respectively.
Output format :
Prints the name of the winner, either 'Whis' or 'Beerus' (Without the quotes).

Constraints :
1 <= N <= 10 ^ 6
2 <= X <= Y<= 50

Time Limit: 1 sec

Sample Input 1 :
4 2 3
Sample Output 1 :
Whis

Sample Input 2 :
10 2 4
Sample Output 2 :
Beerus

Code:

import java.util.Arrays;
public class Solution {

	public static String findWinner(int n, int x, int y) {
		String s1 = "Whis";
		String s2 = "Beerus";
		boolean  storage[] = new boolean[n+1];
		Arrays.fill( storage, false );
		storage[0] = false;
		storage[1] = true;
		
		for( int i = 2; i <= n; i++ ) {
			
			if( i - 1 >= 0 && storage[i-1] == false ) {
				storage[i] = true;
			} else if( i-x >= 0 && storage[i-x] == false ) {
				storage[i] = true;
			} else if( i-y >= 0 && storage[i-y] == false ){
				storage[i] = true;
			} else {
				storage[i] = false;
			}
		}
		
		if( storage[n] == false ) {
			return s1;
		} else {
			return s2;
		}
	}

}
