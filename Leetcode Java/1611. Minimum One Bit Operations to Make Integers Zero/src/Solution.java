public class Solution {
    public int minimumOneBitOperations(int n) {
        return dfs(n);
    }
    
    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        
        int k = 1;
        while (k << 1 <= n) {
            k <<= 1;
        }
        
        return dfs(k ^ (k >> 1) ^ n) + k;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minimumOneBitOperations(3));
    }
}
