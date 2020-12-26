public class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) >= 2 || s.equals(t)) {
            return false;
        }
        
        int i = 0, j = 0;
        while (i < s.length() && j < t.length() && s.charAt(i) == t.charAt(j)) {
            i++;
            j++;
        }
        
        if (s.length() < t.length()) {
            return s.substring(i).equals(t.substring(j + 1));
        } else if (s.length() > t.length()) {
            return s.substring(i + 1).equals(t.substring(j));
        } else {
            return s.substring(i + 1).equals(t.substring(j + 1));
        }
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().isOneEditDistance("ab", "acb"));
        System.out.println(new Solution().isOneEditDistance("a", "ab"));
        // System.out.println("".substring(1));
        System.out.println(new Solution().isOneEditDistance("cab", "ad"));
    }
}
