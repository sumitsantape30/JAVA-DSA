package CountWordInTrie;

public class TrieUse {

	public static void main(String[] args) {

		Trie t= new Trie(); //ek trie bana rhe means trie class ka ek object bana rhe hai
		//trie mai words dalenge and ek search karenge and again ek delete krke usko search karenge
		t.add("This");
		t.add("News");
		System.out.println(t.search("news"));
		t.remove("news");
		System.out.println(t.search("news"));
	}

}
