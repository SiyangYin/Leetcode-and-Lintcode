public class Solution {
    /**
     * @param s1: a string
     * @param s2: a string
     * @return: is s1 and s2 are equivalent
     */
    public boolean isEquivalentStrings(String s1, String s2) {
        // Write your code here
        if (s1.length() != s2.length()) {
            return false;
        }
        
        int len = s1.length();
        if (len % 2 != 0) {
            return s1.equals(s2);
        }
        
        if (s1.equals(s2)) {
            return true;
        }
    
        String s1sub1 = s1.substring(0, len / 2), s1sub2 = s1.substring(len / 2, len);
        String s2sub1 = s2.substring(0, len / 2), s2sub2 = s2.substring(len / 2, len);
        return isEquivalentStrings(s1sub1, s2sub1) && isEquivalentStrings(s1sub2, s2sub2) || isEquivalentStrings(s1sub1, s2sub2) && isEquivalentStrings(s1sub2, s2sub1);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isEquivalentStrings("aaba", "abaa"));
        System.out.println(new Solution().isEquivalentStrings("aabb", "abab"));
    }
}
