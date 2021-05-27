import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n - 1; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (gcd(i, j) == 1) {
                    res.add(i + "/" + j);
                }
            }
        }
        
        return res;
    }
    
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().simplifiedFractions(4));
    }
}
