public class WordDictionary {
    
    class Node {
        boolean isWord;
        Node[] nexts;
        
        Node() {
            nexts = new Node[26];
        }
    }
    
    private Node root = new Node();
    
    /*
     * @param word: Adds a word into the data structure.
     * @return: nothing
     */
    public void addWord(String word) {
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
     * @param word: A word could contain the dot character '.' to represent any one letter.
     * @return: if the word is in the data structure.
     */
    public boolean search(String word) {
        // write your code here
        return dfs(root, word, 0);
    }
    
    private boolean dfs(Node cur, String word, int start) {
        if (start == word.length()) {
            return cur.isWord;
        }
        
        char c = word.charAt(start);
        if (c != '.') {
            if (cur.nexts[c - 'a'] == null) {
                return false;
            } else {
                return dfs(cur.nexts[c - 'a'], word, start + 1);
            }
        } else {
            for (int i = 0; i < cur.nexts.length; i++) {
                if (cur.nexts[i] != null && dfs(cur.nexts[i], word, start + 1)) {
                    return true;
                }
            }
            
            return false;
        }
    }
}