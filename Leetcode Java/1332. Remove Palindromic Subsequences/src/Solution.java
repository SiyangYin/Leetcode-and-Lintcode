public class Solution {
    public int removePalindromeSub(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        boolean isPalin = true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                isPalin = false;
                break;
            }
        }
        
        return isPalin ? 1 : 2;
    }
}
