public class Solution {
    
    class Node {
        Node[] nexts;
        boolean isWord;
        
        public Node() {
            nexts = new Node[2];
        }
    }
    
    private Node root;
    
    private void add(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cur.nexts[ch - '0'] == null) {
                cur.nexts[ch - '0'] = new Node();
            }
            
            cur = cur.nexts[ch - '0'];
        }
        
        cur.isWord = true;
    }
    
    private int res;
    
    /**
     * @param s: the list of binary string
     * @return: the max distance
     */
    public int getAns(String[] s) {
        // Write your code here
        root = new Node();
        for (String str : s) {
            add(str);
        }
        
        dfs(root);
        return res;
    }
    
    private int dfs(Node cur) {
        if (cur == null) {
            return 0;
        }
        
        int l = dfs(cur.nexts[0]), r = dfs(cur.nexts[1]);
        if (l > 0 && r > 0) {
            res = Math.max(res, l + r);
        }
        if (cur.isWord) {
            res = Math.max(res, Math.max(l, r));
        }
        
        return 1 + Math.max(l, r);
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().getAns(new String[]{"011000", "0111010", "01101010"}));
        System.out.println(new Solution().getAns(new String[]{"01", "10", "0", "1", "1001010"}));
    }
}
