import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    class FenwickTree {
        private int[] tree;
        private int n;
        
        public FenwickTree(int n) {
            tree = new int[n + 1];
        }
        
        public int query(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            
            return res;
        }
        
        public void add(int i, int x) {
            while (i < tree.length) {
                tree[i] += x;
                i += lowbit(i);
            }
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    /**
     * @param nums: a list of integers
     * @return: return a list of integers
     */
    public List<Integer> countSmaller(int[] nums) {
        // write your code here
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        
        FenwickTree tree = new FenwickTree(max - min + 1);
        List<Integer> res = new ArrayList<>();
        
        for (int i = nums.length - 1; i >= 0; i--) {
            tree.add(nums[i] - min + 1, 1);
            res.add(tree.query(nums[i] - min));
        }
    
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
        System.out.println(new Solution().countSmaller(new int[]{1, 2, 3, 4}));
    }
}
