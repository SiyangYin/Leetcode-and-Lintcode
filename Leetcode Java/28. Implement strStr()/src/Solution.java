public class Solution {
    public int strStr(String s, String p) {
        if (s == null || p == null) {
            return -1;
        }
        
        if (p.isEmpty()) {
            return 0;
        }
    
        for (int i = 0; i + p.length() - 1 < s.length(); i++) {
            int idx = 0;
            while (idx < p.length()) {
                if (s.charAt(i + idx) != p.charAt(idx)) {
                    break;
                }
                idx++;
            }
            
            if (idx == p.length()) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("hello", "ll"));
    }
}
