public class Solution {
    /**
     * @param s: A string
     * @return: An integer
     */
    public int atoi(String s) {
        // write your code here
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }
        
        long res = 0;
        int sign = 1;
        if (!Character.isDigit(s.charAt(0))) {
            sign = s.charAt(0) == '+' ? 1 : -1;
            s = s.substring(1);
        }
    
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            
            res = res * 10 + s.charAt(i) - '0';
            if (res > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }
        
        return (int) (sign * res);
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println((1L <<31)-1);
    }
}
