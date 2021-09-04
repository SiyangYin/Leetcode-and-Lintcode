public class Solution {
    
    class Node {
        Node[] next;
        
        public Node() {
            next = new Node[2];
        }
    }
    
    Node root;
    
    int insert(int x) {
        int res = 0;
        Node cur = root, node = root;
        for (int i = 0; i < 32; i++) {
            int bit = x >> 31 - i & 1;
            if (node.next[bit] == null) {
                node.next[bit] = new Node();
            }
            node = node.next[bit];
            
            if (cur.next[bit ^ 1] != null) {
                cur = cur.next[bit ^ 1];
                res += 1 << 31 - i;
            } else {
                cur = cur.next[bit];
            }
        }
        
        return res;
    }
    
    /**
     * @param nums: the array
     * @return: the max xor sum of the subarray in a given array
     */
    public int maxXorSubarray(int[] nums) {
        // write code here
        root = new Node();
        int pre = 0, res = 0;
        insert(0);
        for (int x : nums) {
            pre ^= x;
            res = Math.max(res, insert(pre));
        }
        
        return res;
    }
}
