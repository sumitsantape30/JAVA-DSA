Code: Rat In A Maze

You are given a N*N maze with a rat placed at maze[0][0]. Find whether any path exist that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Input Format
Line 1: Integer N
Next N Lines: Each line will contain ith row elements (separated by space)
Output Format :
The output line contains true if any path exists for the rat to reach its destination otherwise print false.

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
true

Sample Input 2 :
3
1 0 1
1 0 1
0 1 1
Sample Output 2 :
 false
 
 Code:
 
 import java.util.Scanner;

//I have to maintain the path that I'm travelling, the cells that I'm visiting so that I don't end up visiting the same cell again. So if i have reached a particular cell from left then I won't go in left again and go back to the previous cell. that way we are mainting the path(path matrix)
//from any cell there are four directions to explore, we will explore all four directions one by one
//we will be solving this using backtracking approach which simple means we'll pick a direction, explore that direction if it doesn't work we'll come back and explore the next direction
public class RatInAMazeQuestion {
	
	public static boolean ratInMaze( int maze[][]) {
      //ratInMaze function will do two things for us
		
		 int n = maze.length;
		 //firstly we'll create a path matrix of n*n
			int path[][] = new int[n][n]; // n*n path, initialized by zero, initial value all zeros rahegi
	       //then we'll call solveMaze function and initial value of i and j should be zero
			return solveMaze( maze, 0, 0, path); //this fucntion will return a boolean so we are returning that value straight away
		}
	    
	    //solveMaze function will help us to find path from any cell to the end and that is something done using recursion, so hum current location denge iss function ke input mai
	    //the purpose of this function is to solve maze, to this function i'll pass the maze and I'll also pass where am I currently in this maze. So i'll pas the i,j coordinates of the cell that I'm currently at (i,j represent where are you currently in the maze) and we'll pas path as well, it will keep track of the cells that you are visiting so that you don't end up visiting the same cell again and again 
	    // we'll be writing the actual recursive logic and backtracking logic in this solveMaze function
	public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
			// currently I am at i,j cell. so first thing i should do is to Check if i,j cell is valid or not
			int n = maze.length;
			//if I take a top from (0,0) i'll reach to (-1,0) ,i'll go out of the grid that means if my 'i' is less than zero or 'i' is greater than grid(i>=n, shouldn't cross the row number) same with j, so these are not valid cells so how can we find a with this so return false. what if the dimensions of the cell are absolutely valid but the cell in itself is not valid iska matlab it is a blocked cell. So agar humare maze ka (i,j) th cell agar zero hai means woh blocked hai. Aur aisa bhi ho skta hai ki humne koi cell visit kardiya hai ab usko dubar visit nhi karna so agar path matrix mai koi cell pe 1 aya means woh already visited hai
			if( i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1 ) {
				
				return false;
			}
			
			//Include the cell in current path, koi cell visit karne ke bad hum usko 1 mark kar denge which means visited
			path[i][j] = 1;
			
			//What if the cell that you have reached is a Destination Cell, then you don't have to travel anymore so we can striaght away return true.
			if( i == n-1 && j == n-1 ) { //i zero se start hora means sabse last wala n-1 rahega. so i==n-1 hogya means woh sabse end pe destination pe pahuch gya
				return true;
			}
		   	
			//but if that cell is not a destination cell we need to explore further in all directions
			
			//Explore further in all direction
			//the first direction we'll explore is top, then row number becomes i-1 and column number remains j.
	      	if(solveMaze( maze, i - 1, j, path )) { return true; } //calling solveMaze will give me the answer whether path exists or not
			//if this is false means path does not exist from top then you should explore next direction
	      	//right: if you take a right then row number will remain same and column number will increase by one
			if(solveMaze( maze, i, j + 1, path )) { return true; } //if you take a right solveMaze will tell whether there exist a path or not from right
			//down:if path doesnt exist from right then you need to go down, going down means row number will increase by 1 and column number will remain the same
			if(solveMaze( maze, i + 1, j, path )) { return true; }
			//if this is true that means there exist a path, if doesn't that means we should go in left
			//left: row number will reamin same and column number will decrease by 1
			if(solveMaze( maze, i, j - 1, path )) { return true; }
		    //if there exist the path then it's true else answer is false
			return false;
		}

	public static void main(String[] args) {

		//this is maze which is a 2D array
		int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
	    //this fucntion ratInMaze will return a boolean, it will tell whether the path exist or not
		boolean pathPossible= ratInMaze(maze); //if there's path possible it'll return true. And false if the path is not possible
		System.out.println(pathPossible);
	}

}
