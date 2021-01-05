Pattern Matching

Given a list of n words and a pattern p that we want to search. Check if the pattern p is present the given words or not. Return true if the pattern is present and false otherwise.
Input Format :
The first line of input contains an integer, that denotes the value of n.
The following line contains n space separated words.
The following line contains a string, that denotes the value of the pattern p.

Output Format :
The first and only line of output contains true if the pattern is present and false otherwise.

Constraints:
Time Limit: 1 sec

Sample Input 1 :
4
abc def ghi cba
de
Sample Output 2 :
true
Sample Input 2 :
4
abc def ghi hg
hi
Sample Output 2 :
true

Sample Input 3 :
4
abc def ghi hg
hif
Sample Output 3 :
false

Code:

import java.util.ArrayList;

class TrieNode{

	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;

	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
		children = new TrieNode[26];
		childCount = 0;
	}
}


public class Trie {

	private TrieNode root;
	public int count;
	public Trie() {
		root = new TrieNode('\0');
	}

	public boolean search(String word){
		return search(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
	}

    public void add( String word ) {
		
		if(add( root, word)) {
			this.count++;
		}
	}

	private boolean add(TrieNode root, String word) { // word = note
		
		if( word.length() == 0 ) {
			
			if (!root.isTerminating) {
				root.isTerminating = true;
				return true;
			
			} else {
			
				return false;
			}
		}
		
		int childIndex = word.charAt(0) - 'a'; // 'n' - 'a' = 14
		TrieNode child = root.children[childIndex]; 
		if( child == null ) {
			child = new TrieNode( word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}
		
	    return	add( child, word.substring(1));
	}

	public boolean patternMatching(ArrayList<String> vect, String pattern) {
        for( int i = 0; i < vect.size(); i++ ) {
			   
			   //take string from vect 
			   String str = vect.get(i);
			   Trie suffixeTrie = new Trie();
			   for( int j = 0; j < str.length(); j++ ) {
				  
				   suffixeTrie.add( str.substring(j));
			   }
			   if( suffixeTrie.search(pattern)) {
				   return true;
			   }
		   }
		   
		   return false;
	}

}
