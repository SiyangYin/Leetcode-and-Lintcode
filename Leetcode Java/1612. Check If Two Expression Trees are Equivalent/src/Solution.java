public class Solution {
    public boolean checkEquivalence(Node root1, Node root2) {
        int[] count = new int[26];
        dfs(root1, count, 1);
        dfs(root2, count, -1);
        
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private void dfs(Node cur, int[] count, int incr) {
        if (cur == null) {
            return;
        }
        
        if (cur.val != '+') {
            count[cur.val - 'a'] += incr;
        }
        
        dfs(cur.left, count, incr);
        dfs(cur.right, count, incr);
    }
}

class Node {
    char val;
    Node left, right;
    
    public Node(char val) {
        this.val = val;
    }
}