Code: 0 1 Knapsack

A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?

Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.
The second line of input contains the N number of weights separated by a single space.
The third line of input contains the N number of values separated by a single space.
The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.

Output Format :
Print the maximum value of V that the thief can steal.

Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec

Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13

Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51

Code:


public class Zero1Knapsack {
	
	//yeh function maximum value jo thief apne sath carry kr skta hai woh value return karra so return type int
	//agar item ka wieght bag se jada hoga to hum use pick hi nhi karenge but agar item ka weight mere baglimit ke andar hai to humare pas do options hai, hum us item ko pick kar bhi skte hai aur nhi bhi pick kr skte , so dono scenario se mangwa lete hai kya profit hoga dono scenarios mese jo better hoga usko apne pas rakhne wale hai
	public static  int knapSach(int weights[], int values[], int maxWeight) { //input will be weights and array for values, and max weight jo hum carry kr skte hai bag mai
		
		//ek ek item pe hum travel karre honge isliye ek aur function banane hai to give input from us ki konse item se humne pick karna start kara, so starting mai hum 0th item se pick karna start karre
		return knapSach(weights, values, maxWeight, 0);
	
	}

	private static int knapSach(int weights[], int values[], int maxWeight, int i) {
		//har item ke corresponding hume decision lena hai ki iss ith item ko pick karna hai ya nhi karna
		
		if( i == weights.length || maxWeight == 0) { //basecase= agar mai sare items ko scan kar chuka hu to means 'i' array se bahar pohoch jayega, to agar 'i' array size ke equal hogya hai means hum sare items ko scan kar chuke hai and other condition is, jo mera maxWeight hai, jo bag mai space hai woh zero hogya hai koi aur item dalneki jagah hi nhi bachi hai to hum obviously kuch add nhi kr payenge we in this case also we should stop aage jake calculate karke fayda nhi hai
			return 0; //so the value of items that you can carry will be zero. (koi items carry nhi kr payenge to value hai hi nhi) 
		}
		
		//otherwise hume check karna chahiye jo current item hai us current item ka weight kya hai, so iss ith(current) item ka weight mxWeight se jada hai to hum iss ith item ko to include hi ni kr skte(bag mai aaneka space hi nhi hai coz iss item ka baglimit se jada weight hai), to fir remaning jo items bachi hai unko bolenge tum batado tum mese maximum value wali  jo hum pick kr skte hai woh item konsi hai
		if( weights[i] > maxWeight ) {
			return knapSach(weights, values, maxWeight, i+1); 
		}else { 
		 //else pe aye means hum iss item ko include kar bhi skte aur nhi bhi kar skte so firse do options
			
			//op1- inlcuding this ith item
			int op1= values[i] + knapSach( weights, values, maxWeight - weights[i], i+1); //coz humne iss item ko include karliya hai to maxWeight  iss item ke weight se substract karna hoga and hum ramining items ka knapsach mangwayenge isliye i+1 kiya. Yeh fucntion muje i+1 ke aage ki item ka maximum value lage dega usme muje current item ko value bhi add karna hai kyuki humne iss current(ith) item kobhi include krliya hai
			 
			//Op2: don't include this ith item
			int op2= knapSach( weights, values, maxWeight, i+1); //agar hum iss item no nhi include krre to i+1 se aage ki item ka knapsach mangwayenge, and bag ka utna hi weight rahega jitne pehle tha coz humne uss item ko include nhi kiya
			
			//and we'll return the once jo hume better profit de, out of these two jisse bhi hume better profit milega woh hum return karenge.
			return Math.max(op1, op2);
		}
	}

	public static void main(String[] args) {

		int weights[] = {6,1,2,4,5}; //weight it items
		int values[] = {10,5,4,8,6}; //har weight ki value
		int maxWeight= 5; // max weight jo mai bag mai carry kr skta hu
		System.out.println(knapSach(weights, values, maxWeight));
	}

}
