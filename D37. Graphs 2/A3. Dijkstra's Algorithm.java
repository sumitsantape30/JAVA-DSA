Code : Dijkstra's Algorithm

Given an undirected, connected and weighted graph G(V, E) with V number of vertices (which are numbered from 0 to V-1) and E number of edges.
Find and print the shortest distance from the source vertex (i.e. Vertex 0) to all other vertices (including source vertex also) using Dijkstra's Algorithm.

Input Format :
Line 1: Two Integers V and E (separated by space)
Next E lines : Three integers ei, ej and wi, denoting that there exists an edge between vertex ei and vertex ej with weight wi (separated by space)

Output Format :
For each vertex, print its vertex number and its distance from source, in a separate line. The vertex number and its distance needs to be separated by a single space.
Note : Order of vertices in output doesn't matter.

Constraints :
2 <= V, E <= 10^5
Time Limit: 1 sec

Sample Input 1 :
4 4
0 1 3
0 3 5
1 2 1
2 3 8
Sample Output 1 :
0 0
1 3
2 4
3 5

Code:

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

        int adjacencyMatrix[][] = new int[V][V];
        for( int i = 0; i < E ; i++ ) {
        	int v1 = s.nextInt();
        	int v2 = s.nextInt();
        	int weight = s.nextInt();
        	adjacencyMatrix[v1][v2] = weight;
        	adjacencyMatrix[v2][v1] = weight;
        	
        }
        
        dijkstra( adjacencyMatrix );
        s.close();
	}

	private static void dijkstra(int[][] adjacencyMatrix) {
		  int v = adjacencyMatrix.length;
		  boolean visited[] = new boolean[v];
		  int distances[] = new int[v];
		  distances[0] = 0;
		  for( int i = 1; i < v; i++ ) {
				distances[i] = Integer.MAX_VALUE;
		  }
		  
		  for( int i = 0; i < v-1 ; i++ ) {
			  //find vertex with min Distance
			 int minVertex = findMinVertex( distances, visited );
			 visited[ minVertex ] = true;
			 //Explore neighbours of minDist
			 for( int j = 0; j < v; j++ ) {
				 if( adjacencyMatrix[minVertex][j] != 0 && !visited[j] && distances[minVertex] != Integer.MAX_VALUE ) {
				    int newDist = distances[minVertex] + adjacencyMatrix[minVertex][j];
				    if( newDist < distances[j] ) {
				    	distances[j] = newDist;
				    }
				 }
			 }
		  }
		  
		  //Print
		  for( int i = 0; i < v; i++ ) {
			  System.out.println(i +" " + distances[i] );
		  }
		  
	}

	private static int findMinVertex(int[] distances, boolean[] visited) {
		int minVertex = -1;
		for( int i = 0; i < distances.length; i++ ) {
			if( !visited[i] && ( minVertex == -1 || distances[i] < distances[minVertex] )) {
				minVertex = i;
			}
		}
		
		return minVertex;
	}
}
