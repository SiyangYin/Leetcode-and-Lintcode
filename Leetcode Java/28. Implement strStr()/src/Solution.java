public class Solution {
    public int strStr(String s, String p) {
        if (s.length() < p.length()) {
            return -1;
        }
        
        long hash = 0, P = 131, hashP = 0, pow = 1;
        for (int i = 0; i < p.length(); i++) {
            hashP = hashP * P + p.charAt(i);
            pow *= P;
        }
        
        for (int i = 0; i < p.length(); i++) {
            hash = hash * P + s.charAt(i);
        }
        
        if (hash == hashP) {
            return 0;
        }
        
        for (int i = p.length(); i < s.length(); i++) {
            hash = hash * P + s.charAt(i);
            hash -= s.charAt(i - p.length()) * pow;
            
            if (hash == hashP) {
                return i - p.length() + 1;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}
