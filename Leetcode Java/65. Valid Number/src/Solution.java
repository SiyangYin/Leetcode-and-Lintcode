public class Solution {
    public boolean isNumber(String s) {
        s = s.strip();
        if (s.isEmpty()) {
            return false;
        }
        
        int len = s.length();
        if (s.charAt(len - 1) != '.' && (s.charAt(len - 1) < '0' || s.charAt(len - 1) > '9')) {
            return false;
        }
        
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("0.1"));
    }
}
