import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

public class TrieService {
    
    private TrieNode root = null;
    
    public TrieService() {
        root = new TrieNode();
    }
    
    public TrieNode getRoot() {
        // Return root of trie root, and
        // lintcode will print the tree struct.
        return root;
    }
    
    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        // Write your cod here
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!cur.children.containsKey(ch)) {
                cur.children.put(ch, new TrieNode());
            }
            
            cur = cur.children.get(ch);
            List<Integer> top10 = cur.top10;
            int pos = binarySearch(top10, frequency);
            top10.add(pos, frequency);
            if (top10.size() > 10) {
                top10.remove(9);
            }
        }
    }
    
    private int binarySearch(List<Integer> list, int num) {
        if (list.isEmpty()) {
            return 0;
        }
        
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (list.get(m) > num) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        return list.get(l) <= num ? l : l + 1;
    }
}

class TrieNode {
    NavigableMap<Character, TrieNode> children;
    List<Integer> top10;
    
    public TrieNode() {
        children = new TreeMap<>();
        top10 = new ArrayList<>();
    }
}