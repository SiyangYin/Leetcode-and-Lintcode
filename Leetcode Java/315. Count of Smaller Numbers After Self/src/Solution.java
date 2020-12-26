import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    
    class FenwickTree {
        int[] tree;
        
        public FenwickTree(int n) {
            tree = new int[n + 1];
        }
        
        public void add(int i, int x) {
            while (i < tree.length) {
                tree[i] += x;
                i += lowbit(i);
            }
        }
        
        public int sum(int i) {
            int res = 0;
            while (i > 0) {
                res += tree[i];
                i -= lowbit(i);
            }
            
            return res;
        }
        
        private int lowbit(int x) {
            return x & -x;
        }
    }
    
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }
        
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            nums[i] -= min;
            max = Math.max(max, nums[i]);
        }
        
        FenwickTree tree = new FenwickTree(max + 1);
        for (int i = nums.length - 1; i >= 0; i--) {
            res.add(tree.sum(nums[i]));
            tree.add(nums[i] + 1, 1);
        }
        
        Collections.reverse(res);
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().countSmaller(new int[]{5, 2, 6, 1}));
    }
}
