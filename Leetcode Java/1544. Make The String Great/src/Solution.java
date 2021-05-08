public class Solution {
    public String makeGood(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (Math.abs(s.charAt(i) - s.charAt(i + 1)) == 'a' - 'A') {
                return makeGood(s.substring(0, i) + s.substring(i + 2));
            }
        }
        
        return s;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().makeGood("leEeetcode"));
    }
}
