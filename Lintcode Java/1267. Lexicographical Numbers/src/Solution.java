import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param n: an integer
     * @return: 1 - n in lexicographical order
     */
    public List<Integer> lexicalOrder(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        dfs(0, n, true, res);
        return res;
    }
    
    private void dfs(int cur, int n, boolean start, List<Integer> res) {
        if (cur > n) {
            return;
        }
        
        if (cur > 0) {
            res.add(cur);
        }
        
        for (int i = start ? 1 : 0; i <= 9; i++) {
            dfs(cur * 10 + i, n, false, res);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lexicalOrder(13));
        System.out.println(new Solution().lexicalOrder(10));
    }
}
