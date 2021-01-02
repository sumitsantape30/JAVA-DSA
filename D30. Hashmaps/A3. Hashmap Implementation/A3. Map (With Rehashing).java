import java.util.ArrayList;

//Study in this order: 1. insert 2.size 3.getValue 4.removeKey 5.Rehash

//Our map class is going to be generic on two thing key and value, so that user can store any kind of key and value he want to store
//Bucket Array mai store karne keliye : mai linkedlist ki ek node banaunga mai, yeh node key and value store kr rhi hogi (Node<k,v>) so isko generic rakhna padega hume and mera array bhi isi type ka hoga but java mai generic type ka array nhi bana skte. So hum arraylist use karenge and arraylist mai dal skte hai yeh nodes ko jo generic nodes hai
//Iss arraylist ko array ki tarah hi treat karenge, shuru mai humne decide kiya tha ki array ka size 20 hoga so arraylist mai hum shuru sehi 20 entries(buckets) rakh lenge so that array jaise behave kare, means koi particular index pe value dalni ho to dal ske. and Har ek ko null kar denge
//Basically ek Arraylist hai uss arraylist ke har bucket mai linkedlist hai jiske andar key, value and next node ka address hai
public class Map <K, V> {

	//Hum ek arraylist mai key values store kre honge, so hume ek Arraylist chahiye jiske har bucket mai  head ka address hoga so MapNode(linked list ka head)) hogi k,v type ki
	ArrayList <MapNode<K, V>> buckets;// arraylist ka nam buckets hai
	//size function rahega isliye size kobhi maintain krte hai, taki size nikalne ke time puri linkedlist traverse karke size na nikalna pde
	int size; // It is not the number of the buckets, it is number of entries that you put into map
	int numBuckets; //Total number of buckets in my Arraylist
	
	public Map() { //Constructor
		numBuckets= 5; //Number of buckets. *Read this after complete program: 20 tha pehle but to just to visualise ki actually refactoring(rehashinf) ho rhi hai bar bar maine numBuckets ko 5 kardiya 20 ki jagah. So ab 4th entry dalte hi rehash hogi. 10 hojayegi buckets
		// abhitak Arraylist banai nhi hai isliye new ArrayList create krte hai
		buckets= new ArrayList<>(); 
		//buckets ke andar 20 null dal dete hai abhi keliye, means khali linked list dal dete h
		for(int i=0; i< numBuckets ; i++) {
			buckets.add(null); 
		}
		//ab humare pas ek arraylist ban gyi hai, jisme 20 entries hai and un 20 entries ke andar 20 khali linked list hai
		//and size by default zero hi hogi coz object banne ke bad humare linkedlist mai zero entries rahegi
	}
	
	// konse bucket mai dalna hai (We can aslo call it HashFucntion coz that's what it does)
	private int getBucketIndex(K key) { //iss function ko input mai key milegi coz uss key ko konse index pe dalna hai yeh nikalna hai
		//ab step hai pehle iss key ko use krke hascode nikalnege then usko compression function ke throught leke Copmress karke return kard denge
		
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
				size--; // jab jo delete karna hai woh mil gya to size ko update (size--) karna padega, aur agar nhi mila tab kuch nhi karna
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
	
	public double loadFactor() { //this is just a temporary function and this is going to help me to visualize what exactly is going inside the map
		return (1.0*size)/numBuckets;
		//mai jaise jaise elements insert kar rha hounga, i'll see ki kya mera load factor kuch change ho rha hai ya nhi hora
	}
	
	private void rehash() {
		//hum ek temp arraylist banayenge and jo current buckets hai usko yaha rakh lenge and buckets ke andar ek nayi arralist banayenge jo double size ki hogi
		
		System.out.println("Rehashing : buckets : " + numBuckets + " size : "+ size); //woh print karega buckets kitni hai aur size kitni hai
		ArrayList<MapNode<K,V>> temp = buckets; // jo current buckets hai usko temp mai dalenge
		buckets= new ArrayList<>(); // humne humare buckets ko temp mai dal diya ab humara buckets khali hai to uske andar nayi arraylist banayenge and fir buckets new arraylist ko point karega.
		
		//numBuckets pehle 20 tha to 2*numBuckets size ka banayenge
		for(int i=0; i< 2*numBuckets; i++) { // jo arraylist banayi of double size usme hume initially 40 entries mai null dalna hoga coz previous arraylist 20 size ki thi
			buckets.add(null); //humare new arraylist mai 40 entries ho chuki hai ab uun 40 bhi entries mai nul dal denge
		}
		//After this we'll make size to be zero, coz humare new Arraylist mai ek bhi element nhi hai, woh pura null hai so size ko zero karna padega.
		size=0;
		numBuckets *= 2; // number of buckets 2 times hogyi h new wale arraylist mai to woh bhi update kar denge
		
		//jaisehi maine yeh teeno kam kardiye (new buckets mai sare null kardiya, size ko zero kardiya and number of buckets ko double kardiya) iske bad humara jo map hai that has become an empty map, so meri jo purani entries thi I'll traverse through these entries, i'll go to each bucket within each bucket i'll go to each node of my linked list and I'm going to inser that key value into the new buckets arraylist
		//old buckets ke har bucket pe traverse krke uske node pe jake usko new wale mai dalenge
		//ek ek karke jo mera temp hai which is previous bucket array 
		for(int i= 0; i< temp.size();i++) {
			
			//head nikal lete hai
			MapNode<K,V>head= temp.get(i); 
			
			//and ab iss linked list ko traverse karenge and har node(head) mese key and value nikalke 
			while(head != null) { 
				K key= head.key;
				V value= head.value;
				insert(key, value); //yeh naye wale mai insert karega coz woh buckets mai add krta hai and now buckets is pointing towards the new Arraylist
				//new arraylist mai insert karne ke ad next node pe jayenge
				head= head.next;
			}
		}
	}
	
	//inbuilt mai put hota hai
	public void insert(K key, V value) { //user se ek key ayegi and value ayegi to insert inside map
		//sabse pehle iss key ke corresponding nikalna padega ki yeh konse bucket mai jayega means hume arraylist ka index chahiye jiske andar iss key ko add karenge. So will make a private function to get the bucket index
		//then linkedlist ka head nikalte hai uss linked list andar traverse karke dekhte hai ki kahipar same key rakhi hui hai kya, if we have the same key somewhere to hum sirf value update kardenge warna hum ek new entry create kar denge.
		int bucketIndex= getBucketIndex(key); // konsi bucket mai bhejna hai
		
		MapNode<K, V> head= buckets.get(bucketIndex); // yeh bucket index jis bucket ka hai uski linked list ka head get karre
		
		//ab linked list ke head pe traverse krte hai, hum har point pe yeh check karenge ki kya woh node wahi key contain krta hai jo hume insert karni hai
		while(head != null) { 
		
			if(head.key.equals(key)) { //head change hote ja rha hai so har head pe check karre ki kya woh key(jo insert krni hai) already head mai hai. Agar equal hui to hum usi key use karenge bass value ko update kar denge and return karenge
				head.value = value; // == se address compare hota hai but .equals se exact content compare hota hai
				return;
				//if we found it that doesnt means humne kuch insert kiya, humne bas update kiya so iss loop ke andar size++ nhi hoga, jab hum actually new Node bana rhe hai insert karne keliye tab size++ krna chahiye
			}
			head= head.next;
		}
		
		//iss line pe pahuche means woh key linkedlist mai already exist nhi krta, to muje ek nayi node banake isko linked list ke starting mai insert kar dunga and bucket uss bucket mai head ko mere insert kiya hue Node(key) ko point karwaunga means usko head banaunga
		head= buckets.get(bucketIndex); // jis index pe hume insert karna hai waha pe jo linkedlist hai uska head, original wala head.
		MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);// New node banaya of key jo hume insert karna hai and iss node ke next hum head dal denge 
		size++; //humne insert karne keliye ek new node banaye hai so tabhi size++ karenge.
		newElementNode.next= head; 
		buckets.set(bucketIndex, newElementNode);
		
		//Rehashing
		//Insert karne ke turant bad basically we need to calculate load factor. it's data type is going to be Double and not an integer.
		double loadFactor= (1.0*size)/numBuckets; // (number of elements(n)/ number of buckets(b))
		//only size/ numBucets will give an integer/integer so that means agar size 10 hai aur numBuckets 12 hai that's more than 0.7 but humar answer 0 ayega so we should put 1.0*size
		
		if( loadFactor > 0.7) { //agar mera load factor grater than 0.7 hua to mai rehash karunga, i'll make a private fuction jisma mai rehash karunga 
			rehash(); 
		}
		
		
	}

}
