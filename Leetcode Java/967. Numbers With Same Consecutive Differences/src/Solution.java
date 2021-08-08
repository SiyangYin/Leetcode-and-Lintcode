import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            dfs(1, i, n, k, list);
        }
        
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    void dfs(int u, int x, int n, int k, List<Integer> list) {
        if (u == n) {
            list.add(x);
            return;
        }
        
        int a = x % 10;
        if (a - k >= 0) {
            dfs(u + 1, x * 10 + a - k, n, k, list);
        }
        
        if (k == 0) {
            return;
        }
        
        if (a + k < 10) {
            dfs(u + 1, x * 10 + a + k, n, k, list);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numsSameConsecDiff(2, 1)));
    }
}
