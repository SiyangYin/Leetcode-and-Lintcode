import java.util.HashMap;
import java.util.Map;

public class WordDictionary {
    
    class Node {
        boolean isWord;
        Map<Character, Node> next;
        
        Node() {
            next = new HashMap<>();
        }
    }
    
    private Node root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
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
            if (!node.next.containsKey(c)) {
                return false;
            } else {
                return dfs(node.next.get(c), word, start + 1);
            }
        } else {
            for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                if (dfs(entry.getValue(), word, start + 1)) {
                    return true;
                }
            }
            
            return false;
        }
    }
    
    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("bad");
        dic.addWord("dad");
        dic.addWord("mad");
        System.out.println(dic.search("pad"));
        System.out.println(dic.search("bad"));
        System.out.println(dic.search(".ad"));
        System.out.println(dic.search("b.."));
    }
}
