public class Solution {
    
    class Node {
        Node[] next;
    
        public Node() {
            next = new Node[2];
        }
    }
    
    private Node root;
    
    /**
     * @param nums:
     * @return: the maximum result of ai XOR aj, where 0 ≤ i, j < n
     */
    public int findMaximumXOR(int[] nums) {
        // Write your code here
        root = new Node();
        int res = 0;
        
        insert(getBin(nums[0]));
        for (int i = 1; i < nums.length; i++) {
            String bin = getBin(nums[i]);
            res = Math.max(res, findMaxXor(bin));
            insert(bin);
        }
        
        return res;
    }
    
    private int findMaxXor(String s) {
        Node cur = root;
        int res = 0;
    
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - '0';
            res <<= 1;
            
            if (cur.next[val ^ 1] != null) {
                res++;
                cur = cur.next[val ^ 1];
            } else {
                cur = cur.next[val];
            }
        }
        
        return res;
    }
    
    private void insert(String s) {
        Node cur = root;
    
        for (int i = 0; i < s.length(); i++) {
            int dig = s.charAt(i) - '0';
            if (cur.next[dig] == null) {
                cur.next[dig] = new Node();
            }
            
            cur = cur.next[dig];
        }
    }
    
    private String getBin(int x) {
        String s = Integer.toBinaryString(x);
        StringBuilder sb = new StringBuilder();
        for (int i = s.length(); i < 31; i++) {
            sb.append('0');
        }
        
        return sb.append(s).toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
