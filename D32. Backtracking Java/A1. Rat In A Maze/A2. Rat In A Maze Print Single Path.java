public class ratInAMazePrintPath {
	
	public static boolean ratInMaze( int maze[][]) {

		 int n = maze.length;
			int path[][] = new int[n][n];
	        return solveMaze( maze, 0, 0, path);
		}
	    
	    public static boolean solveMaze(int maze[][], int i, int j, int path[][]) {
			//Check if i,j cell is valid or not
			int n = maze.length;
			if( i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1 ) {
				
				return false;
			}
			
			//Include the cell in current path 
			path[i][j] = 1;
			
			//There exist a path, this information we are able to get at this if statement. Yahase pta lag gya tha hume ki path milgya so we were returning true, means hum destination cell pe pohoch gye that means hume humara target mil chuka hai
			//so agar hume path print bhi karana hai jo path hum path matrix mai maintain krte hue chal rhe hai, to woh printing ka kam bhi hum isi if statement mai karre honge jab hum destination tak pohoch chuke hai
			//that means agar humara question hai print the path as so niche wala kam karenge
			//Destination Cell
			if( i == n-1 && j == n-1 ) {
				//I'm printing it the way I print a 2D matrix
				for(int r=0; r< n; r++) {
					for(int c=0; c< n; c++) {
						System.out.print( path[r][c]+" ");
					}
					System.out.println();
				}
				return true;
			}
		   	
			//Explore further in all direction
			//top
	      	if(solveMaze( maze, i - 1, j, path )) {
	      		return true;
	      		}
	      
			//right
			if(solveMaze( maze, i, j + 1, path )) {
				return true;
				}
			
			//down
			if(solveMaze( maze, i + 1, j, path )) {
				return true;
				}
			
			//left
			if(solveMaze( maze, i, j - 1, path )) {
				return true; 
				}
		
			return false;
		}

	public static void main(String[] args) {

		int maze[][]= {{1,1,0},{1,1,0},{1,1,1}};
		boolean pathPossible= ratInMaze(maze);
		System.out.println(pathPossible);
	}
}

Output:
1 1 0 
0 1 0 
0 1 1 
true
