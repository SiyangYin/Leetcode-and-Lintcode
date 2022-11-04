import java.util.HashMap;
import java.util.Map;

public class MapSum1 {
    private TrieNode root;
    private Map<String, Integer> map;
    public MapSum1() {
        root = new TrieNode();
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int prev = 0;
        if (map.containsKey(key)) {
            prev = map.get(key);
        }
        map.put(key, val);
        TrieNode node = root;
        for (int i = 0; i < key.length(); i++) {
            if (node.children[key.charAt(i) - 'a'] == null) {
                node.children[key.charAt(i) - 'a'] = new TrieNode();
            }
            node = node.children[key.charAt(i) - 'a'];
            node.sum += val - prev;
        }
        node.isWordEnd = true;
    }

    public int sum(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.children[prefix.charAt(i) - 'a'] == null) {
                return 0;
            }
            node = node.children[prefix.charAt(i) - 'a'];
        }
        return node.sum;
    }

    public static void main(String[] args) {
        MapSum1 mp = new MapSum1();
        mp.insert("a", 3);
        System.out.println(mp.sum("ap"));
        mp.insert("b", 2);
        System.out.println(mp.sum("a"));
    }
}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
    int sum;
}
