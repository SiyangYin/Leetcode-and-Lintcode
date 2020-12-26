public class MapSum {
    
    class Node {
        boolean isWord;
        int val;
        Node[] nexts;
        Node() {
            nexts = new Node[26];
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }
    
    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.nexts[c - 'a'] == null) {
                cur.nexts[c - 'a'] = new Node();
            }
            cur = cur.nexts[c - 'a'];
        }
        
        cur.isWord = true;
        cur.val = val;
    }
    
    public int sum(String prefix) {
        if (prefix == null || prefix.isEmpty()) {
            return 0;
        }
        
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.nexts[c - 'a'] == null) {
                return 0;
            }
            cur = cur.nexts[c - 'a'];
        }
        
        return dfs(cur);
    }
    
    private int dfs(Node root) {
        if (root == null) {
            return 0;
        }
        
        int sum = root.val;
        for (int i = 0; i < root.nexts.length; i++) {
            sum += dfs(root.nexts[i]);
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */