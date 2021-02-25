public class Solution {
    
    class Node {
        Node next[];
    
        public Node() {
            next = new Node[2];
        }
    }
    
    Node root;
    
    private void insert(int x) {
        Node cur = root;
        for (int i = 31; i >= 0; i--) {
            int idx = x >> i & 1;
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node();
            }
            
            cur = cur.next[idx];
        }
    }
    
    private int query(int x) {
        int res = 0;
        Node cur = root;
        for (int i = 31; i >= 0; i--) {
            int idx = x >> i & 1;
            res <<= 1;
            if (cur.next[idx ^ 1] != null) {
                cur = cur.next[idx ^ 1];
                res++;
            } else {
                cur = cur.next[idx];
            }
        }
        
        return res;
    }
    
    public int findMaximumXOR(int[] nums) {
        root = new Node();
        int res = 0;
        for (int num : nums) {
            insert(num);
            res = Math.max(res, query(num));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
