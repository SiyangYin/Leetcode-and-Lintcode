public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return "";
        }
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        int l1 = str1.length(), l2 = str2.length();
        return str1.substring(0, gcd(l1, l2));
    }
    
    private int gcd(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        while (y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABC"));
        System.out.println(new Solution().gcdOfStrings("ABCABC", "ABCABCD"));
        
    }
}
