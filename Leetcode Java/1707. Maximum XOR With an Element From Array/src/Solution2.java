import java.util.Arrays;

public class Solution2 {
    
    class Node {
        Node next[];
        
        public Node() {
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
        }
    }
    
    private int query(int x) {
        Node cur = root;
        
        int res = 0;
        for (int i = 31; i >= 0; i--) {
            int idx = x >> i & 1;
            res <<= 1;
            if (cur.next[idx ^ 1] != null) {
                cur = cur.next[idx ^ 1];
                res++;
            } else if (cur.next[idx] != null) {
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
        Arrays.sort(nums);
    
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{queries[i][0], queries[i][1], i};
        }
        Arrays.sort(queries, (q1, q2) -> Integer.compare(q1[1], q2[1]));
    
        int[] res = new int[queries.length];
        for (int i = 0, j = 0; j < queries.length; j++) {
            while (i < nums.length && nums[i] <= queries[j][1]) {
                insert(nums[i]);
                i++;
            }
            
            res[queries[j][2]] = query(queries[j][0]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4};
        int[][] q = {{3, 1}, {1, 3}, {5, 6}};
        System.out.println(Arrays.toString(new Solution2().maximizeXor(nums, q)));
    }
}
