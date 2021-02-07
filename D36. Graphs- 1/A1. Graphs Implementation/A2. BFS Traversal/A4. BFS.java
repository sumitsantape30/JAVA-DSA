import java.util.Scanner;

public class GraphBFS {
	
//BFS is similar to level order traversal in case of tree but hum recursion use nhi karenge , recusrion mai agar ek chiz pe call hui to woh pura apna kam khatam karke aata hai (recursion by default is depth first)	
// we'll be using Queue
	public static void printHelper( int edges[][], int sv, boolean visited[]) {
		 //Queue ka object banate hai and usme hum vertice means Integer store karne wale hai
		QueueUsingLL<Integer> q= new QueueUsingLL<Integer>();
		
		//sabse pehle hum apni queue mai Starting Vertex ko dalenge, jo bhi starting vertex hoga usko enqueue kar denge
		q.enqueue(sv);
		
		int n= edges.length;
		
		//starting vertex ko qeueue mai dalne ke bad starting vertex ko visited mark kar dete hai
		visited[sv]= true; //as soon as something is going inside the queue hum usko visited mark kar denge
		
		//now we will do our work
		while(! q.isEmpty()) { //jabtak queue empty nhi hai hum apna kam krte rahenge
			//queue mese front pe jo element hai usko dequeue karenge
			int front;
			
			try {
				front = q.dequeue();
			} catch (QueueEmptyException e) {
             //just in case exception aajati hai, waise ayegi nhi coz hum pehlehi check karre nhi empty na ho, aur empty nhi hai tabhi queue ka rhe hai, so aisehi return kar rhe hai
				return;
			}
			
			//jab front element queue ke bahar nikalenge to hum usko print karenge and uske jo bhi adjacent hai unko qeueue mai dalenge
			System.out.println(front);
			
			//har ek ko check krt hai kya woh humare front wale element se adjacent hai ya nhi hai
			for( int i=0; i< n; i++) {
				if(edges[front][i] == 1 && !visited[i]) { //agar edge hai to adjacent hai warna nhi hai. So agar front se i ke bich mai edge ho aur i already visited nhi hai to use queue mai dalna hai and i ko visited mark kardena hai
					q.enqueue(i);
					visited[i]= true;
				}
			}
		}
	}
	
	public static void BFS( int edges[][]) {
		
		//hum apna visited array banayenge
		boolean visited[]= new boolean[edges.length];
		
		for (int i = 0; i < edges.length; i++) {
			if (!visited[i]) {
				printHelper(edges, 0, visited); 
			}
		}
		//agar yeh loop nhi lagaye to woh bas ek hi component ka print karega dusra component ignore kardega coz woh alag connected component hai
        //now our priting will work for disconnected graph as well
	}
	
	public static void main(String[] args) {

		int n;
		int e;
		Scanner s= new Scanner(System.in);
		n= s.nextInt(); //user se puchenge kitne vertices hai
		e= s.nextInt(); //fir puchenge kitne edges hai
		
		//usne bola n vertices hai ab hum 2D array banayenge n*n ka. Arrayka type boolean bhi rakh skte hai but hum int rakhenge kyuki uski jarurat padegi
		int edges[][]= new int[n][n]; //(agar 10 vertices hai to numbering 0 to 9 h.) By default mere 2D array mai abhi zero hoga
		
		//ek ek karke har ek edge ka input lere. jaha jaha edge waha 1 rakh rha hu abhikeliye (just like boolean 1 as true)
		for( int i=0; i< e; i++) {
			int fv= s.nextInt();
			int sv= s.nextInt();
			//and hum bolenge first vertex se second vertex ke bich mai edge hai
			edges[fv][sv]= 1;
			// and also we'll say ki second vertex se first verted ke bich mai bhi egde hai
			edges[sv][fv]=1;
		}
		
		BFS(edges);
	}

}
