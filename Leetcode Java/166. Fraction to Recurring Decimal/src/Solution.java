import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int x, int y) {
        StringBuilder sb = new StringBuilder();
        if (x < 0 && y > 0 || x > 0 && y < 0) {
            sb.append('-');
        }
        
        long n = Math.abs((long) x), d = Math.abs((long) y);
        sb.append(n / d);
        n %= d;
        if (n == 0) {
            return sb.toString();
        }
        
        sb.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (n != 0 && !map.containsKey(n)) {
            map.put(n, sb.length());
            sb.append(n * 10 / d);
            n = n * 10 % d;
        }
        
        if (n != 0) {
            sb.insert(map.get(n), "(");
            sb.append(')');
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 49));
//        System.out.println(new Solution().fractionToDecimal(-1, Integer.MIN_VALUE));
    }
}
