import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n, 2, new ArrayList<>(), res);
        return res;
    }
    
    private void dfs(int n, int last, List<Integer> list, List<List<Integer>> res) {
        if (n == 1) {
            if (list.size() > 1) {
                res.add(new ArrayList<>(list));
            }
            
            return;
        }
        
        for (int i = last; i <= n / i; i++) {
            if (n % i == 0) {
                list.add(i);
                dfs(n / i, i, list, res);
                list.remove(list.size() - 1);
            }
        }
        
        list.add(n);
        dfs(1, n, list, res);
        list.remove(list.size() - 1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getFactors(8));
    }
}
