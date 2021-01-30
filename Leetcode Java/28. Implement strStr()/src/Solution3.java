public class Solution3 {
    public int strStr(String s, String p) {
        if (s.length() < p.length()) {
            return -1;
        }
        
        long hash = 0, P = 131L, hashP = 0, pow = 1;
        for (int i = 0; i < p.length(); i++) {
            hashP = hashP * P + p.charAt(i);
            pow *= P;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (i < p.length()) {
                hash = hash * P + s.charAt(i);
            } else {
                if (hash == hashP) {
                    return i - p.length();
                }
                
                hash = hash * P + s.charAt(i);
                hash -= s.charAt(i - p.length()) * pow;
            }
        }
        
        return hash == hashP ? s.length() - p.length() : -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().strStr("hello", "ll"));
    }
}
