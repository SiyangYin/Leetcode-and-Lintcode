public class Solution {
    
    private int idx;
    
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        
        dfs(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return idx == preorder.length;
    }
    
    private void dfs(int[] preorder, int min, int max) {
        if (idx == preorder.length) {
            return;
        }
        
        int val = preorder[idx];
        if (min < preorder[idx] && preorder[idx] < max) {
            idx++;
            dfs(preorder, min, val);
            dfs(preorder, val, max);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().verifyPreorder(new int[]{5, 2, 1, 3, 6}));
    }
}

