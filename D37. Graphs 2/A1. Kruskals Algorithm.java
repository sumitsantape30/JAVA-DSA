import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

           //6. I need to implement the interface comparable, hume comparable interface ko implement karna hoga and implement ke bad ek function ko override karna hoga
class Edge implements Comparator<Edge> { //3.we created a class named Edge and iss class mai humari teen properties hongi source, destination and weight coz har humari har egde ke pas yahi teen properties hai
	
	int source;
	int dest; //destination
	int weight;
	
	//7. ek method ko oveeride karenge
	@Override
	public int compareTo( Edge o) { //yeh edge type kahi argument input lega, kyuki hum ek edge class ke object ko dusre edge class ke hi object se compare krna chahte hai
		return this.weight - o.weight; //hum aisa statement likhte hai jab hume array ko increasing order mai sort krna hota hai
	} // aisa karne se humara array sort hojayega
	
}


public class KruskalsAlgorithm {
	
	//11.
	public static int findParent( int v, int parent[]) { //input mai hume v vertex milega jiska parent nikalna hai and the parent array jiski help se hum uska parent figure out karne wale hai, yeh hum using kar skte hai
		if( parent[v]== v) {
			return v;
		}
		
		return findParent( parent[v], parent);
	}

	
	//5. return type void rakhte hai abhikeliye kyuki hume sirf apne MST ko print karna hai kuch return karne ki jarurat nhi hai
	public static void kruskals( Edge input[], int n) { //input mai hume ek array mil rha hai and total number of vertices mil rhe hai
		
		//our second step was, ki hume apne array ko sort krdena hai, apni edges ko sort karna hai based on their weights, we will use inbuilt function for sorting
		Arrays.sort(input);
		
		//now the concern is jo yeh humara input array hai yeh edge type ka array hai and iss edge type ke array ko kis basis pe sort karna hai yeh hum hi specify karenge for that i need to implement interface comparable
		
		//7. now create the output array kyuki hume finally apni MST ko ek output mai bhi to store karna hai and woh bhi edge type kahi hoga.
		Edge output[]= new Edge[n-1]; //why n-1? kyuki humare MST mai n-1 hi edges hongi
		
		//9. cycle kaise detect kare? with the help of union find algorithm, so agar union find ki help leni hai to I need to have a parent array jo hume bta rha hoga ki humare do vertices jinke bichmai edge hai un dono ka final parent kon hai 
		int parent[]= new int[n]; //it should be an array of size of size n, kyuki har vertex keliye hume uska parent store karna hai, 	
		//and initially I should initialize ki har vertex ka parent woh khud hai
		for( int i=0; i< n; i++) {
			parent[i]= i;
		}//humne ith index pe i value place krdi
		
		//8.ab ek ek krke edges pick karni hai aur apne output array mai add krte jana hai, so let's have count variable which will represent abhitak humare MST mai kitne edges aa chuki hai
		int count=0;
		int i=0; //yeh 'i' variable hume bta rha hoga ki currently hum apne input array ke konse edge pe kam kr rhe hai, or you can say 'i' will represent jo current edge pe hum kam krne wale hai
		
		while( count != n-1) { //jabtak humara count not equal to n-1 hai tabtak kam karenge, tabtak hume edges ko pick krte jana hai aur apni MST mai add krte jana hai, jaisehi count == n-1 hojayega matlab humara MST mai edges aa chuke hai hume bahar nikalke bas use print karna hai and we're done
			Edge currentEdge= input[i]; 
			//ab humene iss current edge ko pick karlena chahiye but hum isse direct blindly apne is MST mai add nhi kr skte, hume pehle check karna hoga ki kya iss edge ko introduce karne se koi cycle to add nhi hojayegi apni MST mai, ab cycle kaise detect kare? with the help of union find algorithm, so agar union find ki help leni hai to I need to have a parent array jo hume bta rha hoga ki humare do vertices jinke bichmai edge hai un dono ka final parent kon hai
			
			//10. current edge MSP mai add kr skte ki nhi kr skte yeh bat pta chalegi hume apne iss currentEdge ke dono vertices ke parent ko figure out karne ke bad, so we can say i want to figure out sourse parent
			
			int sourceParent= findParent( currentEdge.source , parent );  //humare current edge ke source ka parent kaun hai, so we created a function jisme hume apni current edge ka source and obviously the parent array pass karenge
			//similarly destination parent bhi figure out kar lete hai, jisme hume pass karna hoga current edge ka destination and the parent array
			int destParent= findParent( currentEdge.dest, parent);
			//humari jo current edge this let's say 'e' uske do vertices the v1 and v2 , v1 is source and v2 is destination, and abhi humne v1 and v2 ka parent mangwa liya. v1 ka parent sourceParent mai store kardiya and v2 ka parent destinationParent mai store kardiya
			//ab humara next step hona chahiye to check inn dono ke values same hai ya different hai, agar same hai that means iss edge ko hum apni MST mai add nhi kr skte but agar different hai to kr skte hai
			if( sourceParent != destParent) { //agar dono equal nhi hai to inko add karne se koi cycle introduce nhi hogi
				//output ke count index pe karenge add, coz count is maintaining ki kitne edges humari utput mai jaa chuki hai, and add karne ke bad obviously we should increase count
				output[count]= currentEdge;
				count++;
				//source parent and destination parent ki values aagyi and usko apne output mai jake add kardiya. jo source and dest parent ki values aayi ab inn dono mese kisi ek ko parent and kisi ek ko parent bananahi padega, indono ko connect karna padega
				parent[sourceParent]= destParent; //aisa karne se sourceParent ki jo value aayi thi woh parent ban chuka hai
					
			}
			//ab hume bahar aake i++ karna hai, if condition ke bahar kyu? kyuki humne apni iss current edge ko MST mai add kiya ya nhi kiya irrespective of that hume i ko update karna hi hai. (i represents ab hum konsi edge pe kam kr rhe hai)
			i++;
		}
		
		//12. printing our MST
		for( int j=0; j< n-1; j++) { //n-1 coz humare MST mai n-1 hi edges hai
			if( output[i].source < output[j].dest) {	
				System.out.println(output[j].source+ " " + output[j].dest+ " " + output[j].weight);
			}else {
				System.out.println(output[j].dest+ " " + output[j].source+ " " + output[j].weight);
			}
		}
	}
	
	
	public static void main(String[] args) {

		Scanner s= new Scanner(System.in);
		
		//1.humara first step is to take input, so hum sabse pehle total number of vertexes lenge input, after that total number of edges
		int n= s.nextInt(); //total number of vertexes
		int E= s.nextInt(); //total number of edges
		
		//2.ab hume inn sari edges ko somehow store karna hai so we had decide that we'll create a class jiska nam hum Edge rakhenge.
		
		//4. now we'll create an array of type edge jiska size hoga 'E' aur uska andar hum apni har edge ko jake store kar denge.
		Edge input[]= new Edge[E]; //yeh line likhte hi humare liye memory mai ek E size ka array ban gya and right now har index pe null pda hua hai, every index is pointing to null so index pe value rakhne se pehle muje apne object ko initialize karna padega or you can say constructor call karna paddega for that object 
		//now let;s run the loop and take every edge as input
		for( int i=0; i< E; i++) {
			//first I need to create edge class object, so hum har har index pe jake object banana hoga aur uske bad uski value set krni hogi
			input[i]= new Edge(); //iss line ke help se I'm basically creating a new object
		 //value set karne ke bad muje ab har property ka input lena hai
			input[i].source = s.nextInt();
			input[i].dest= s.nextInt();
			input[i].weight= s.nextInt();
		}
		
		//ab jab hum iss for loop se bahar ayenge humara input array create ho chuka hoga jisme humne apni saari edges ko store kardiya hai
		//input leliya ab kruskal's algorithm implement karni hai, for that let's create a function jisme i need to pass this input array and total number of vertices, total number of edges to nikal skte hai hum iss input ke length ki help se.
		kruskals(input, n);
		 	
	}

}
