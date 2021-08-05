import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> findStrobogrammatic(int n) {
        return dfs(n, n);
    }
    
    private List<String> dfs(int k, int n) {
        if (k == 0) {
            return Arrays.asList("");
        }
        if (k == 1) {
            return Arrays.asList("0", "1", "8");
        }
    
        List<String> list = dfs(k - 2, n), res = new ArrayList<>();
        for (String s : list) {
            if (k < n) {
                res.add("0" + s + "0");
            }
            
            res.add("1" + s + "1");
            res.add("6" + s + "9");
            res.add("8" + s + "8");
            res.add("9" + s + "6");
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findStrobogrammatic(4));
    }
}
