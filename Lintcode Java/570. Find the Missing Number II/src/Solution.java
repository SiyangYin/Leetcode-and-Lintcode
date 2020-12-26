public class Solution {
    /**
     * @param n: An integer
     * @param str: a string with number from 1-n in random order and miss one number
     * @return: An integer
     */
    public int findMissing2(int n, String str) {
        // write your code here
        boolean[] visited = new boolean[n + 1];
        dfs(str, n, 0, visited);
    
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                return i;
            }
        }
        
        return -1;
    }
    
    private boolean dfs(String s, int n, int pos, boolean[] visited) {
        if (pos == s.length()) {
            return true;
        }
        
        if (s.charAt(pos) == '0') {
            return false;
        }
        
        for (int i = pos + 1; i <= Math.min(pos + 2, s.length()); i++) {
            int num = Integer.parseInt(s.substring(pos, i));
            if (0 < num && num <= n && !visited[num]) {
                visited[num] = true;
                if (dfs(s, n, i, visited)) {
                    return true;
                }
                visited[num] = false;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findMissing2(20, "19201234567891011121314151618"));
        System.out.println(new Solution().findMissing2(11, "111098765432"));
        System.out.println(new Solution().findMissing2(13, "1110987654321213"));
    }
}
