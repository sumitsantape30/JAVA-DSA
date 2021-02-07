import java.util.Scanner;

public class GraphDFS {

	public static void printHelper( int edges[][], int sv, boolean visited[]) { //input mai 2d array denge means usko pura graph hi mil jayega, usko pura graph mil jayega aur size array se nikal skta hai if needed. Aur hum usko starting vertex denge by defaut sv could be zero but I'm specifically giving ki Zero se start karo coz badme kabhi jarurat padegi ki muje 0 se nhi 5 se start karna hai that's why we are giving a starting vertex that basically means we want to start treversing graph from where do we start from (kaha se shure krke jaye). And ek array pass krenge jo visited values store karega.
		
		//aatehi starting vertex ko print karre
		System.out.println(sv);
		
		//initially visited pura false hoga, jaisehi kuch bhi(upar wala print(sv)) print kiya we will mark that as visited
		visited[sv]= true;
		
		//ab muje dekhna hai jo yeh starting vertex hai isme se konse konse edges ja rhe hai bahar. 2d array mai Starting vertex ke corresponding jo puri row hai usme traverse karunga kis jagah pe 1 hai and kis jagah pe 0 hai
		 int n= edges.length; //this is number of edges
		for( int i=0 ; i<n; i++) { // sv ke adjacent mai traverse kr rhe h
			if( edges[sv][i] == 1 && !visited[i]) { //agar aise hua means yeh dono ke bich mai edge hai and just because i adjacent hai doesn't mean mai i pe call karunga agar woh already visited hai to mai call nhi karunga so i visited bhi nhi hona chahiye
				printHelper(edges, i, visited); //sv hogya ab uske adjacent pe call kr rhe, now our starting vertex will be i
			}
		}
	}
	
	public static void print( int edges[][]) { //user se sirf edges lenge
		//here we are creating a boolean array jisme visited values store rahegi and visited values pe firse call nhi hoga
		boolean visited[]= new boolean[edges.length];
		
		//let's loop over this visited array
		for( int i=0; i< edges.length; i++) {
			if( ! visited[i]) { //sabse pehle i ki value 0 hogi, 0 visited nhi hai to zero ke corresponding call hojayegi, manlo 0 1 2 3 4 5 connected the means ek component mai the. jab iss component ke sare visited hojayenge to pta chalega ki dusre component ke visited nhi hai to unke corresponding start hojayega, this way print honga sabhi components ke
				printHelper(edges, i, visited);
			}  
		} //agar yeh loop nhi lagaye to woh bas ek hi component ka print karega dusra component ignore kardega coz woh alag connected component hai
         //now our priting will work for disconnected graph as well
	}
	
	public static void main(String[] args) {
		
		int n;
		int e;
		Scanner s= new Scanner(System.in);
		n= s.nextInt(); //user se puchenge kitne vertices hai
		e= s.nextInt(); //fir puchenge kitne edges hai
		
		//usne bola n vertices hai ab hum 2D array banayenge n*n ka. Arrayka type boolean bhi rakh skte hai but hum int rakhenge kyuki uski jarurat padegi
		int edges[][]= new int[n][n]; //(agar 10 vertices hai to we are numbering from 0 to 9.) By default mere 2D array mai abhi zero hoga so jaha jaha edge hai waha 1 rakhenge
		
		//ek ek karke har ek edge ka starting index aur ending index input lere. jaha jaha edge waha 1 rakh rha hu abhikeliye (just like boolean 1 as true)
		for( int i=0; i< e; i++) {
			int fv= s.nextInt(); //first vertex/starting vertex of edge input lere
			int sv= s.nextInt(); //second vertex/ending vertex of edge input lere
			//and hum bolenge first vertex se second vertex ke bich mai edge hai
			edges[fv][sv]= 1;
			//and also we'll say ki second vertex se first vertex ke bich mai bhi egde hai
			edges[sv][fv]=1;
		}//input lene keliye bas itna hi karna tha
		
		print(edges); //hum apna 2D array denge, means usko pura graph mil jayega 
	}
}

Input:
5
4
0 1
1 2
0 2
3 4

Output:
0
1
2
3
4
