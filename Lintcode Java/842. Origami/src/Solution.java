public class Solution {
    /**
     * @param n: The folding times
     * @return: the 01 string
     */
    public String getString(int n) {
        // Write your code here
        return dfs(1, n, true);
    }
    
    private String dfs(int i, int n, boolean down) {
        if (i > n) {
            return "";
        }
    
        return dfs(i + 1, n, true) + (down ? '0' : '1') + dfs(i + 1, n, false);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getString(2));
    }
}
