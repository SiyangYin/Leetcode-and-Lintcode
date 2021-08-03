public class Solution {
    
    private StringBuilder sb;
    
    /**
     * @param n: The folding times
     * @return: the 01 string
     */
    public String getString(int n) {
        // Write your code here
        sb = new StringBuilder();
        dfs(1, n, true);
        return sb.toString();
    }
    
    private void dfs(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
    
        dfs(i + 1, n, true);
        sb.append(down ? '0' : '1');
        dfs(i + 1, n, false);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getString(4));
    }
}
