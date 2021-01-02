
// yeh node bhi generic hoga and yeh apne pas ek key store kr rha hoga and value store kr rha hoga
// Arraylist mai ek bucket mai hum jo arraylist rakhenge uske ek Node ko MapNode bolte hai, us MapNode mai key, value and obviously next node kabhi Address rahega hi
public class MapNode<K, V> { 
	
	K key;
	V value;
	MapNode<K, V> next;//yeh linkedlist ka node hai map ka so next wale kabhi address hume rakhna hi hoga
	//yeh sab friendly hi hai coz hume map class kohi use karna hai
	
	public MapNode(K key, V value) {
		this.key= key;
		this.value= value;
		// by default next null hi rahega
	}
}
