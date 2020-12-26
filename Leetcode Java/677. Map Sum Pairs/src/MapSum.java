public class MapSum {
    class Node {
        int val;
        Node[] next;
        Node() {
            next = new Node[26];
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
            if (cur.next[c - 'a'] == null) {
                cur.next[c - 'a'] = new Node();
            }
            cur = cur.next[c - 'a'];
        }
        
        cur.val = val;
    }
    
    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return 0;
            }
            cur = cur.next[c - 'a'];
        }
        
        return summation(cur);
    }
    
    private int summation(Node cur) {
        if (cur == null) {
            return 0;
        }
        
        int res = cur.val;
        for (int i = 0; i < cur.next.length; i++) {
            res += summation(cur.next[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        MapSum mp = new MapSum();
        mp.insert("a", 3);
        System.out.println(mp.sum("ap"));
        mp.insert("b", 2);
        System.out.println(mp.sum("a"));
        
    }
}
