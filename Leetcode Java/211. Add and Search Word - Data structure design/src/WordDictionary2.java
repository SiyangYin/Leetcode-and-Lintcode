public class WordDictionary2 {
    
    class Node {
        boolean isWord;
        Node[] next;
        Node() {
            next = new Node[26];
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary2() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    
    private boolean dfs(Node node, String word, int start) {
        if (start == word.length()) {
            return node.isWord;
        }
        
        char c = word.charAt(start);
        if (c != '.') {
            if (node.next[c - 'a'] == null) {
                return false;
            } else {
                return dfs(node.next[c - 'a'], word, start + 1);
            }
        } else {
            for (int i = 0; i < node.next.length; i++) {
                if (node.next[i] != null && dfs(node.next[i], word, start + 1)) {
                    return true;
                }
            }
            
            return false;
        }
    }
    
    public static void main(String[] args) {
        WordDictionary2 dic = new WordDictionary2();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        System.out.println(dic.search("pad"));
        System.out.println(dic.search("bad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("b.."));
    }
}
