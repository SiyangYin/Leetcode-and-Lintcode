public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            res = res * 26 + (ch - 'A' + 1);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().titleToNumber("AB"));
    }
}
