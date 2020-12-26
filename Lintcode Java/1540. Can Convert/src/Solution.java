public class Solution {
    /**
     * @param s: string S
     * @param t: string T
     * @return: whether S can convert to T
     */
    public boolean canConvert(String s, String t) {
        // Write your code here
        if (s == null) {
            return false;
        }
        
        int j = 0;
        for (int i = 0; i < s.length() && j < t.length(); i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;
            }
        }
        
        return j == t.length();
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canConvert("lintcode", "lint"));
    }
}
