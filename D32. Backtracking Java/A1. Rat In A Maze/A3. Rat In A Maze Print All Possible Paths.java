Code: Rat In a Maze All Paths (There are two codes below code1 and code2)

You are given a N*N maze with a rat placed at maze[0][0]. Find and print all paths that rat can follow to reach its destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion ( left, right, up and down).
Value of every cell in the maze can either be 0 or 1. Cells with value 0 are blocked means rat can­not enter into those cells and those with value 1 are open.

Input Format
The first line of input contains an integer 'N' representing 
the dimension of the maze.
The next N lines of input contain N space-separated 
integers representing the type of the cell.
Output Format :
For each test case, print the path from start position to destination position and only cells that are part of the solution path should be 1, rest all cells should be 0.
Output for every test case will be printed in a separate line.

Note:
You do not need to print anything, it has already been taken care of. Just implement the given function.
Constraints:
0 < N < 11 0 <= Maze[i][j] <=1

Time Limit: 1sec

Sample Input 1 :
3
1 0 1
1 0 1
1 1 1
Sample Output 1 :
1 0 0 1 0 0 1 1 1 
Sample Output 1 Explanation :
Only 1 path is possible

1 0 0
1 0 0
1 1 1
Which is printed from left to right and then top to bottom in one line.

Sample Input 2 :
3
1 0 1
1 1 1
1 1 1
Sample Output 2 :
1 0 0 1 1 1 1 1 1 
1 0 0 1 0 0 1 1 1 
1 0 0 1 1 0 0 1 1 
1 0 0 1 1 1 0 0 1 
Sample Output 2 Explanation :
4 paths are possible which are printed in the required format.

Code 1: (This code print complete 2D array of all the paths)


public class Solution {
	
	public static void ratInAMaze(int maze[][]){
		
	/* Your class should be named Solution.
	 * Don't write main() function.
	 * Don't read input, it is passed as function argument.
	 * Print output as specified in the question
	 */
		int n = maze.length;
		int path[][] = new int[n][n];
        solveMaze( maze, 0, 0, path);
	}

	public static void solveMaze(int maze[][], int i, int j, int path[][]) {
		//Check if i,j cell is valid or not
		int n = maze.length;
		if( i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1 ) {
			
			return;
		}
		  
		//Include the cell in current path 
		path[i][j] = 1;
		
		//Destination Cell
		if( i == n-1 && j == n-1 ) {
			for(int k = 0; k < n; k++ ) {
				for( int l = 0; l < n; l++ ) {
					System.out.print(path[k][l]+" ");
				}
			}
			System.out.println();
            path[i][j] = 0;
			return;
		}
	   	
		//Explore further in all direction
		//top
      	solveMaze( maze, i - 1, j, path );
		//right
		solveMaze( maze, i, j + 1, path );
		//down
		solveMaze( maze, i + 1, j, path );
		//left
		solveMaze( maze, i, j - 1, path );
        path[i][j] = 0;
		return;
	}
	
	
}

Code 2:


public class ratInAMazePrintAllPath {

	public static void ratInMaze( int maze[][]) {

		 int n = maze.length;
			int path[][] = new int[n][n];
			printAllPaths( maze, 0, 0, path);
		}
	    
	    //print kar rhe hai to return type boolean ki jarurat nhi hogi ab.
	    //it's void function so obviously hume true false nhi chahiye so hume return likhna hoga
	    public static void printAllPaths(int maze[][], int i, int j, int path[][]) {
			//Check if i,j cell is valid or not
			int n = maze.length;
			if( i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1 ) {
				
				return;
			}
			
			//Include the cell in current path 
			path[i][j] = 1;
			
			//Destination Cell
			if( i == n-1 && j == n-1 ) {
				for(int r=0; r< n; r++) {
					for(int c=0; c< n; c++) {
						System.out.print( path[r][c]+" ");
					}
					System.out.println();
				}
				System.out.println();
				
				//ek path milne ke bad we used to return true but we have to get back may be there's possibility ki aur path ho and iss destination cell pe dubara uss path se aau. humne path matrix mai path=1 mark kardiya coz current path ke through yeh milgya but agar mai aur bhi path explore karra hu to yeh destination cell wapas muje 0 mark kar dena chahiye. kyu zero mark kar dena chahiye? kyuki humne upar condition laga rakha hai ki agar path=1 hai to return false  
				//ek path print hone ke bad we should reset it to zero.
				path[i][j]=0; 
				
				return ;
			}
		   	
			//If I get true in one direction then I should not stop, Is should actually explore other directions as well, so woh call humne if condtion ke andar kiye the but ab muje koi condition nhi lagani coz 4 calls honge honge for sure
			//kyuki muje all possible paths chahiye to ek direction se answer milta bhi hai tobhi we have to explore other directions
			//top
			printAllPaths( maze, i - 1, j, path ); //agar path hogi to woh print kardega agar nhi hai to it will come back without printing anything.
	      
			//right
			printAllPaths( maze, i, j + 1, path );
			
			//down
			printAllPaths( maze, i + 1, j, path );
			
			//left
			printAllPaths( maze, i, j - 1, path );
			
			//we used to return false here also but we should make sure that after I have explored one cell for all possible directions I should reset it to zero kyuki ho skta hai woh cell kisi aur path kabhi part ho
			//har ek cell explore karne ke bad usko zero se reset kar denge taki woh agar dusri path mai aya to consider hona chahiye
			path[i][j]=0; //reseted the destination to the zero
		
			return;
		}

	public static void main(String[] args) {

		int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
	   
		ratInMaze(maze);
	}
}

Output Of Code 2:

1 1 0 
0 1 0 
0 1 1 

1 1 0 
1 1 0 
1 1 1 

1 0 0 
1 1 0 
0 1 1 

1 0 0 
1 0 0 
1 1 1 

