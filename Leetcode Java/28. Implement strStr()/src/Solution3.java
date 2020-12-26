public class Solution3 {
    public int strStr(String s, String p) {
        if (s == null || p == null) {
            return -1;
        }
    
        if (p.isEmpty()) {
            return 0;
        }
     
        return 0;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution3().strStr("hello", "ll"));
    }
}
