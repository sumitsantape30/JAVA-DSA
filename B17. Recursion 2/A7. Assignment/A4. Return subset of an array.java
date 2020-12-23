Return subset of an array

Given an integer array (of length n), find and return all the subsets of input array.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.

Note : The order of subsets are not important.

Input format :
Line 1 : Size of array
Line 2 : Array elements (separated by space)

Sample Input:
3
15 20 12
Sample Output:
[] (this just represents an empty array, don't worry about the square brackets)
12 
20 
20 12 
15 
15 12 
15 20 
15 20 12 

Code:
public class solution {

	// Return a 2D array that contains all the subsets
	public static int[][] subsets(int input[]) {
		return subsets(input, 0);

	}
     private static int[][] subsets(int input[], int start) {
    	if(start >= input.length) {
    		int ans[][] = new int[1][0];
    		return ans;
    	}
    	
    	int smallOutput[][] = subsets(input, start + 1);
    	
    	
    	// Jagged Array - Rows are fixed but columns are not
    	int output[][] = new int[smallOutput.length * 2][]; //Total Number of rows in Outputarray = 2 * size Of smallArray
    	
    	int k = 0; // Assume it is the value of column
    	int len = smallOutput.length; // Row length of small Output array
    	
    	//Copy the first run of smallOutputArray into Output array
    	for(int i = 0; i < len; i++ ) {// iterating row of output array
    		
    		//set the Total number of columns in OutputArray = Total Number of Columns in 1st row  
    		output[k] = new int[smallOutput[i].length];
    		
    		for(int j = 0; j < smallOutput[i].length; j++ )//iterating columns of output array
    		{
    			output[k][j] = smallOutput[i][j]; // copying values of column smallOutput into columns of Output Array
    		}
    		
    		k++; // incrementing the rows of output array
    	}
    	// k = 
    	for(int i = 0; i < len; i++) {
    		
    		//create same number of columns as it is the columns in smallOutput array w.r.t number of that row
    		output[k] = new int[smallOutput[i].length + 1];
    		
    		output[k][0] = input[start]; 
    		
    		for(int j = 1; j <= smallOutput[i].length; j++) 
    		{
    			output[k][j] = smallOutput[i][j - 1];
    		}
    		k++;
    		
    	}
    	
    	return output;
    }
}
