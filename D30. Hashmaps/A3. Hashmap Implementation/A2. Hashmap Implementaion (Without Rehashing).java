import java.util.ArrayList;

//Study in this order: 1. insert 2.size 3.getValue 4.removeKey

//Our map class is going to be generic on two thing key and value, so that user can store any kind of key and value he want to store
//Bucket Array mai store karne keliye : mai linkedlist ki ek node banaunga mai, yeh node key and value store kr rhi hogi (Node<k,v>) so isko generic rakhna padega hume and mera array bhi isi type ka hoga but java mai generic type ka array nhi bana skte. So hum arraylist use karenge and arraylist mai dal skte hai yeh nodes ko jo generic nodes hai
//Iss arraylist ko array ki tarah hi treat karenge, shuru mai humne decide kiya tha ki array ka size 20 hoga so arraylist mai hum shuru sehi 20 entries(buckets) rakh lenge so that array jaise behave kare, means koi particular index pe value dalni ho to dal ske. and Har ek ko null kar denge
//Basically ek Arraylist hai uss arraylist ke har bucket mai linkedlist hai jiske har node ke andar key, value and next node ka address hai
public class Map <K, V> {

	//Hum ek arraylist mai key values store kre honge, so hume ek Arraylist chahiye jiske har bucket mai  head ka address hoga so MapNode(linked list ka head)) hogi k,v type ki
	ArrayList <MapNode<K, V>> buckets;// arraylist ka nam buckets hai
	//size function rahega isliye size kobhi maintain krte hai, taki size nikalne ke time puri linkedlist traverse karke size na nikalna pde
	int size; // It is not the number of the buckets, it is number of entries that you put into map
	int numBuckets; //Total number of buckets in my Arraylist. Matlab it is length of my arraylist ki arraylist mai mai itni entries dal skta hu
	
	public Map() { //Constructor
		numBuckets= 20; //Number of buckets
		// abhitak Arraylist bani nhi hai isliye new ArrayList krte hai
		buckets= new ArrayList<>(); 
		//buckets ke andar 20 null dal dete hai abhi keliye, means khali linked list dal dete h
		for(int i=0; i< numBuckets ; i++) {
			buckets.add(null); 
		}
		//ab humare pas ek arraylist ban gyi hai, jisme 20 entries hai and un 20 entries ke andar 20 khali linked list hai
		//and size by default zero hi hogi coz object banne ke bad humare linkedlist mai zero entries rahegi
	}
	
	// konse bucket mai dalna hai (We can also call it HashFucntion coz that's what it does)
	private int getBucketIndex(K key) { //iss function ko input mai key milegi coz uss key ko konse index pe dalna hai yeh nikalna hai
		//ab step hai pehle iss key ko use krke hascode nikalnege then usko compression function ke throught leke Compress karke return kardenge
		
		int hashCode= key.hashCode(); //Har generic object class ka kahi na kahi subclass hoti hai (Every Object in java is basically inherited from the object class somehow, and object class ke andar HashCode implemented hai isliye generic bhi hai to problem nhi)
		return hashCode % numBuckets; // Compression function	
	}
	
	public int size() {
		return size;
	}
	
	public V removeKey(K key) { // input will be the key which we have to delete and will be returning the value we have deleted		
	// pehle bucketIndex nikal lenge fir muje linked list travrse karni hai and jaisehi koi node match kar jaye muje usko delete kar dena hai. 
	// So ek node ke delete karne keliye hume uske previous ko jo node delete karre uske next ko point karana hoga
		
    int bucketIndex= getBucketIndex(key); //firstly we'll get the bucket index corresponding to that key which we've input
		
        MapNode<K, V> head= buckets.get(bucketIndex); // head of linked list in that bucket, now I'm going to traverse this linked list
        MapNode<K, V> prev= null; //hume previous bhi rakhna hai shuru mai jab head pe hu to uska previous null hona chahiye so prev= null
		
		while(head != null) { 
			
			if(head.key.equals(key)) { //jaisehi woh key match kar jaye mai previous ke next mai head ka next dal dunga (previous ka next should become head ka next)
				size--;
				if( prev == null) { //agar prev null hi hai means hume key head pehi mila to prev.next== head.next nhi kr skte as prev shuru mai null hai. means hume head kohi delete karna hai isliye head ke next mai jo hoga usko head bana denge
         		buckets.set(bucketIndex, head.next);
					
				}else {
					
				  prev.next= head.next; //agar prev null nhi hai means hume list mai aage kahi key mil gyi hai so head ke next mai value hogi usko prev ke next mai point karwayenge
				
				}
				  return head.value;
			}
			//agar jo key dhund rhe hai woh nhi mila to next pe jayenge
			// traverse krte time previous becomes head and head goes to the next one
				prev= head; 
			    head= head.next;
		     }
		//hum puri linkedlist traverse kar chuke hai hume kahi kuch nhi mila so hum null return karenge.
		return null;
	}
	
	public V getValue(K key) { // Also called as Search, this will return value corresponding to the key we gave input.
		//iss key ke corresponding index nikalenge, us index pe jayenge and jo bhi uss index pe linked list hai uss linked list ko mai traverse karunga, as soon as I find a key in linkedlist which matches this key(which we have got input) I'm going to return that value. In case I don't find anything(means woh key hai hi nhi mere pas) to mai null return kar dunga as the value
		
		int bucketIndex= getBucketIndex(key); //firstly we'll get the bucket index corresponding to that key which we've given input
		
        MapNode<K, V> head= buckets.get(bucketIndex); // head of linked list in that bucket, now I'm going to traverse this linked list
		
		while(head != null) { // linked List pe traverse karre, ham har point(head) pe check karenge if that head contains a key, as head is changing
			
			if(head.key.equals(key)) { //jaisehi match hogya means jo key muje chahiye woh linked list mil gyi to mai head ki value return kar dunga
				return head.value;
			}
			head= head.next;
		}
		//yahape aaye means we could'nt find any match so hum null return kar denge
		return null;
	}
	
	public double loadFactor() { //To visualize what exactly is going inside the map
		return (1.0*size)/numBuckets;
	}
	
	private void rehash() {
		System.out.println("Rehashing : buckets : " + numBuckets + " size : "+ size);
		ArrayList<MapNode<K,V>> temp = buckets; // jo old buckets hai usko temp mai dalenge
		buckets= new ArrayList<>(); // buckets is pointing towards new arrayList
		for(int i=0; i< 2*numBuckets; i++) { // jo new ArrayList hai usme 10 null entries ho chuki hai
			buckets.add(null);
		}
		size=0;
		numBuckets *= 2; // number of buckets 2 times hogyi h new wale mai arraylist mai
		
		//old buckets ke har bucket pe traverse krke uske node pe jake usko new wale mai dalenge
		for(int i= 0; i< temp.size();i++) {
			MapNode<K,V>head= temp.get(i);
			
			while(head != null) { // linked list ko traverse karke key, value leke firse insert karenge
				K key= head.key;
				V value= head.value;
				insert(key, value);
				head= head.next;
			}
		}
	}
	
	//inbuilt mai put hota hai
	public void insert(K key, V value) { //user se ek key ayegi and value ayegi to insert inside map
		//sabse pehle iss key ke corresponding nikalna padega ki yeh konse bucket mai jayega means hume arraylist ka index chahiye jiske andar iss key ko add karenge. So will make a private function to get the bucket index
		//then linkedlist ka head nikalte hai and uss linked list ke andar traverse karke dekhte hai ki kahipar same key rakhi hui hai kya, if we have the same key somewhere to hum sirf value update kardenge warna hum ek new entry create kar denge.
		int bucketIndex= getBucketIndex(key); // konsi bucket mai bhejna hai
		
		MapNode<K, V> head= buckets.get(bucketIndex); // yeh bucket index jis bucket ka hai uski linked list ka head get karre
		
		//ab linked list ke head pe traverse krte hai, hum har point pe yeh check karenge ki kya woh node wahi key contain krta hai jo hume insert karni hai
		while(head != null) { 
		
			if(head.key.equals(key)) { //head change hote ja rha hai so har head pe check karre ki kya woh key(jo insert krni hai) already head mai hai. Agar equal hui to hum usi key use karenge bass value ko update kar denge and return karenge
				head.value = value; // == se address compare hota hai but .equals se exact content compare hota hai
				return;
			}
			head= head.next;
		}
		
		//iss line pe pahuche means woh key linkedlist mai already exist nhi krta, to muje ek nayi node banake isko linked list ke starting mai insert kar dunga and bucket uss bucket mai head ko mere insert kiya hue Node(key) ko point karwaunga means usko head banaunga
		head= buckets.get(bucketIndex); // jis index pe hume insert karna hai waha pe jo linkedlist hai uska head, original wala head.
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);// New node banaya of key jo hume insert karna hai and iss node ke next hum head dal denge 
		size++;
		newElementNode.next= head; //new mapnode ke next mai head ko attach kar denge
		buckets.set(bucketIndex, newElementNode); // apni arraylist
		
		//Rehashing
		double loadFactor= (1.0*size)/numBuckets; // (number of elements/ numbr of buckets)
		if( loadFactor > 0.7) {
			rehash();
		}
	}
}
