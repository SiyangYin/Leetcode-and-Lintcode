import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        int cur = n;
        Set<Integer> set = new HashSet<>();
        while ((cur = squareSum(cur)) != 1) {
            if (!set.add(cur)) {
                return false;
            }
        }
        
        return true;
    }
    
    private int squareSum(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }
        
        return sum;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isHappy(19));
    }
}
