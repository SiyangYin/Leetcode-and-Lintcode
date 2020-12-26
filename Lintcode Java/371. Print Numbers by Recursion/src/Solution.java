import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class Solution {
    /**
     * @param n: An integer
     * @return: An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        
        for (int i = 1; i <= 9; i++) {
            res.add(i);
        }
        
        dfs(n, res, 0);
        return res;
    }
    
    private void dfs(int n, List<Integer> res, int start) {
        if (n == 1) {
            return;
        }
    
        int size = res.size();
        for (int i = start; i < size; i++) {
            for (int j = 0; j <= 9; j++) {
                res.add(res.get(i) * 10 + j);
            }
        }
        
        dfs(n - 1, res, start * 10 + 9);
    }
    
    public static void main(String[] args) {
        List<Integer> list = new Solution().numbersByRecursion(3);
        System.out.println(list.size());
    
        System.out.println(list);
    }
}
