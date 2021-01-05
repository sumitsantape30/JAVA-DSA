package CountWordInTrie;

//TrieNode is going to tell us how one node of trie is going to look like
class TrieNode {
	
	char data; //ek node ke pas uska khudka data hoga
	boolean isTerminating; //koi word terminating(bold) ho rha hai ya nhi
	TrieNode children[]; //Node ke pas ek array hoga jisme mai us node ke sare childrens ko store karega 
	int childCount; //hum ek child count bhi maintain karenge that will tell ki iss node ke kitne children hai *yeh hume remove function mai help karega isliye rakh rhe hai*

	//Constructor
	public TrieNode(char data) { //jab bhi koi Trie node bana rha hoga, to trie node banate time usko data specify karna padega. And TrieNode bante hi hum 26 size ka array bana lenge
		this.data = data; //data ko initialise karenge
		isTerminating = false; //isTerminating initially false rakhenge ki yeh node terminating nhi hai
		children = new TrieNode[26]; //Trie Node ke corresponding array banayenge of size 26, and iss array ki har entry by default null hogi initially
		childCount = 0; //initially child count will be zero, ek bhi child nhi hai, jab bhi hum koi node ka child add karenge to hume childCount increase karna hoga
	}
}
