public class Trie {
    
    class Node {
        boolean isWord;
        Node[] nexts;
        Node() {
            nexts = new Node[26];
        }
    }
    
    Node root;
    
    public Trie() {
        // do intialization if necessary
        root = new Node();
    }
    
    /*
     * @param word: a word
     * @return: nothing
     */
    public void insert(String word) {
        // write your code here
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.nexts[c - 'a'] == null) {
                cur.nexts[c - 'a'] = new Node();
            }
            cur = cur.nexts[c - 'a'];
        }
        
        cur.isWord = true;
    }
    
    /*
     * @param word: A string
     * @return: if the word is in the trie.
     */
    public boolean search(String word) {
        // write your code here
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.nexts[c - 'a'] == null) {
                return false;
            }
            cur = cur.nexts[c - 'a'];
        }
        
        return cur.isWord;
    }
    
    /*
     * @param prefix: A string
     * @return: if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        // write your code here
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.nexts[c - 'a'] == null) {
                return false;
            }
            cur = cur.nexts[c - 'a'];
        }
    
        return true;
    }
}