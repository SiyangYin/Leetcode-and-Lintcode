import java.util.Arrays;

public class Solution {
    
    class Node {
        int min;
        Node next[];
        
        public Node() {
            min = Integer.MAX_VALUE;
            next = new Node[2];
        }
    }
    
    private void insert(int x) {
        Node cur = root;
        
        for (int i = 31; i >= 0; i--) {
            int idx = x >> i & 1;
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node();
            }
            
            cur = cur.next[idx];
            cur.min = Math.min(cur.min, x);
        }
    }
    
    private int query(int x, int lim) {
        Node cur = root;
        
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int idx = x >> i & 1;
            res <<= 1;
            if (cur.next[idx ^ 1] != null && cur.next[idx ^ 1].min <= lim) {
                cur = cur.next[idx ^ 1];
                res++;
            } else if (cur.next[idx] != null && cur.next[idx].min <= lim) {
                cur = cur.next[idx];
            } else {
                return -1;
            }
        }
        
        return res;
    }
    
    Node root;
    
    public int[] maximizeXor(int[] nums, int[][] queries) {
        root = new Node();
        for (int num : nums) {
            insert(num);
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            int[] query = queries[i];
            res[i] = query(query[0], query[1]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] q = {{3, 1}, {1, 3}, {5, 6}};
        System.out.println(Arrays.toString(new Solution().maximizeXor(nums, q)));
    }
}
