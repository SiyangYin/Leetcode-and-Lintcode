import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param n: the length of strobogrammatic number
     * @return: All strobogrammatic numbers
     */
    public List<String> findStrobogrammatic(int n) {
        // write your code here
        return strobog(n, n);
    }
    
    private List<String> strobog(int n, int m) {
        if (n == 0) {
            return new ArrayList<>(Arrays.asList(""));
        }
        if (n == 1) {
            return new ArrayList<>(Arrays.asList("0", "1", "8"));
        }
    
        List<String> shorter = strobog(n - 2, n), res = new ArrayList<>();
        for (int i = 0; i < shorter.size(); i++) {
            String s = shorter.get(i);
            if (n < m) {
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
        System.out.println(new Solution().findStrobogrammatic(20));
    }
}
