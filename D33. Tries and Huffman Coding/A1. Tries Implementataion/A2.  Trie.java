package CountWordInTrie;

//agar muje Trie implement karna hai to Tree implement karna hai, to TrieClass ko apne pas pura tree rakhna hai, muje tree rakhna hai so muje tree ka root mil jaye to pura tree bhi mil jayega that mean Trie Class ke andar hum pure trie ka root rakhne wale hai. Trie ka root Trienode hai jiske chidren mai saare alphabets ke corresponding data store hoga
//Root ka khudka data kuch nhi hai so root ko null character(\0) se initialise karenge
//Study in this order: 1.add 2.search 3.remove
public class Trie {

	//in data memeber ko private karenge aur inke getter setter de denge.
	private TrieNode root;

	public Trie() { //jab bhi koi Trie banayega to root bhi create hojana chahiye 
		root = new TrieNode('\0');
	}
	
	//Trie ke teen important function 1.add 2.search 3.remove yeh banane hai

	public void remove(String word){ //input will be the word we have to delete
		remove(root, word); //recursively krenge to I need to pass these two value
	}
	
	public void remove(TrieNode root, String word) {

		//agar word length zero hogyi hai to jo last jo root hai woh terminating nhi hona chahiye
		if (word.length() == 0) { //jo last wala word hai usko non terminating karna padega
			root.isTerminating = false; 
			return;
		}
		
		//ab pehle child index nikalo aur uss index pe jake check karo
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if (child == null) { // agar hai hi nhi woh word to null rahega so return kardo
			return;
		}

		// agar child null nhi hai to hume word delete bhi karna hai so child ko bolenge jo word reh gya hai usko delete karde
		remove(child, word.substring(1));

		//remove call krne ke bad bhi woh memory store rahega isliye waha se bhi delete karenge
		//remove call karane ke bad, jab child apne andar remove call karke hojayega tab parent ko child ko remove karna hai
		// Sirf terminating true ya false nhi words kobhi remove karna h woh word exist hi nhi karna chahiye, we can remove child only if child is non terminating and its number of children is also zero
		if (!child.isTerminating && child.childCount == 0) {
			root.children[childIndex] = null; // root ke pas children array hoga usme childIndex wale index pe null kar denge
			child = null; //i should make child null as well
			root.childCount--; // child remove hora to childCount ghatega.
		}
	}

	public boolean search(String word) { //jo word search karna hai woh input rahega
		// search pe recursively banana hai to har bar root change hoga isliye aur ek search ka varient banana hoga jo muje root lake dega,so woh jo answer return karega hum woh return kar denge
		return search(root, word); //isme hum root pass kar rhe hai and jo word search krna hai woh pass kr rhe h

	}

	private boolean search(TrieNode root, String word) { 

		//*basecase sabse last mai study karna*
		if (word.length() == 0) { //humko word mil gya hai ab aage kuch nhi h dhundne keliye and hum directly true return nhi kr skte, Jab last letter terminating hoga tabhi true hona chahiye so jis root pe aaye woh check karna chahiye ki woh terminating hai ki nhi 

			return root.isTerminating;
		}

		//Basic kam muje same hi krna hai ya pe bhi, childIndex nikalna hai aur woh index null ho skta hai ya not null ho skta hai uske corresponding kam karenge.
		int childIndex = word.charAt(0) - 'a'; 
		TrieNode child = root.children[childIndex]; // root ko woh word ke corresponding child mil jayega

		if (child == null) { // agar woh child null hua to hume yaha koi nya node banake add nhi karna, hume simply false return karna hai
			return false; //false means ki nhi exist krta woh word
		}
		
		// yahape aaye means child(oth character) null nhi hai means at least pehla character mil gya so agega search karenge
		return search(child, word.substring(1)); // jo remaining words hai unko dhundke laake dede aur pura word milgya to true return karega else false.
	}
	
	
	//add karne ke kam hum recursively karenge 
	//add karna hai to user se sirf word milega hume 
	public void add(String word) {
		//hume word insert karna hai so word ke corresponding hume check karna hai, suppose mai "NOTE" word insert kr rha hu, to root pe dhundunga "N" ke corresponding koi child hai ya nhi, root pe N ke corresponding koi child hai ya nhi yeh hume pta kaise chalega? Root ke pas apne children ka ek array hoga, usme N wale index pe(N ke corresponding jo index hai) wahape null pda hai ya not null hai, agar not null hai to child hai and null hai to child nhi hai
		//to isse pta chal jayega N ke corresponding koi child hai ya nhi
		add(root, word);// *yeh alag se add function kyu banaya iska reason niche hai*
	}

	private void add(TrieNode root, String word) {
		
		//*yeh basecase sabse end mai study karna pehle niche wala part study karo*
		//hum har step pe word chota krte ja rhe hai, finally last character pe word khatam ho jayega, empty hojayega
		if (word.length() == 0) { //agar word ki length hogyi hai means hum sara insertion kar chuke hai
			root.isTerminating = true; //root ke last letter ka isTerminating true kar dena chahiye
			return ;
		}
	
		int childIndex = word.charAt(0) - 'a'; //muje 0th wale(N) character ke corresponding array mai dhundna hai ki child exist krta hai ya nhi isliye childIndex lere
		TrieNode child = root.children[childIndex]; //childIndex ke corresponding array mai jo child hai woh nikal rhe, so root ke array mai (array ka nam children hai) childIndex pe pda hua milega woh
		//jo child mila woh null bhi ho skta hai, not null bhi ho skta hai
		if (child == null) { //agar child null hai( maltab array mai us index pe null pda hua hai) matlab 'N' nam ka node abhitak nhi bana tha so abhi hume node banana chahiye
			child = new TrieNode(word.charAt(0)); //chidIndex (N) ke corresponding Node bana rhe
			//so child ban chuka hai ab iss child ko root mai jo array hai usme childIndex pe dalenge.
			root.children[childIndex] = child; 
			//humne root ka child add kiya isliye root ke child count ko increase krna padega
			root.childCount++; 
		}
		
		// hume "NOTE" insert karna tha to humne check kiya root ka koi 'N' nam ka child hai ya nhi then N ke corresponding Node banaya and root ke array mai use add kardiya yahatk humne 'N' insert kardiya ab 'N' ko apne andar "OTE" inn characters pe kam karna hai so hum recurion call karenge.
		//yeh hone ke bad hume recursively call karna hai aage ke character add karne keliye and aage ke character hume main root node pe nhi dalne wale hum child(N) mai dalne hai so ab mera main root jo child tha woh banega. isliye as a root child ko pass karre taki woh main root ban ske that's why add(child, word.substring(1)) karenge and not add(word.substring(1)). And isiliye alag add function banaya hai with argument root and word taki mai next time root change kr pau
	     add(child, word.substring(1)); //recursion call on add 0th index ke aage se means 1 se and uske aage ka kam recursion karega.
	}

}
