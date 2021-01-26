public class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        int sign = 1;
        if (s.charAt(0) == '+' || s.charAt(0) == '-') {
            sign = s.charAt(0) == '+' ? 1 : -1;
            s = s.substring(1);
        }
        
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            
            int x = sign * (s.charAt(i) - '0');
            if (sign == 1 && res > (Integer.MAX_VALUE - x) / 10) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res < (Integer.MIN_VALUE - x) / 10) {
                return Integer.MIN_VALUE;
            }
            
            res = res * 10 + x;
        }
        
        return res;
    }
}
