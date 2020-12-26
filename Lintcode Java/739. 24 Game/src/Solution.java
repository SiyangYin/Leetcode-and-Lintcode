import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param nums: 4 cards
     * @return: whether they could get the value of 24
     */
    public boolean compute24(double[] nums) {
        // write your code here
        List<Double> cur = new ArrayList<>();
        for (double num : nums) {
            cur.add(num);
        }
        
        return dfs(cur);
    }
    
    private boolean dfs(List<Double> cur) {
        if (cur.size() == 1) {
            return isZero(cur.get(0) - 24);
        }
    
        for (int i = 0; i < cur.size(); i++) {
            for (int j = i + 1; j < cur.size(); j++) {
                double y = cur.remove(j), x = cur.remove(i);
                
                cur.add(x + y);
                if (dfs(cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
                
                cur.add(x - y);
                if (dfs(cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
    
                cur.add(y - x);
                if (dfs(cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
                
                cur.add(x * y);
                if (dfs(cur)) {
                    return true;
                }
                cur.remove(cur.size() - 1);
                
                if (!isZero(y)) {
                    cur.add(x / y);
                    if (dfs(cur)) {
                        return true;
                    }
                    cur.remove(cur.size() - 1);
                }
                
                if (!isZero(x)) {
                    cur.add(y / x);
                    if (dfs(cur)) {
                        return true;
                    }
                    cur.remove(cur.size() - 1);
                }
                
                cur.add(i, x);
                cur.add(j, y);
            }
        }
        
        return false;
    }
    
    private boolean isZero(double num) {
        return Math.abs(num) < 1E-10;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().compute24(new double[]{1, 4, 8, 7}));
        System.out.println(new Solution().compute24(new double[]{1, 1, 1, 2}));
        System.out.println(new Solution().compute24(new double[]{3, 3, 8, 8}));
    }
}
