public class Solution {
    /**
     * @param s: string s
     * @param t: string t
     * @return: Given two strings s and t, write a function to determine if t is an anagram of s.
     */
    public boolean isAnagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        
        int len = s.length();
        int[] count = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c]++;
        }
    
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (count[c] == 0) {
                return false;
            }
            
            count[c]--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isAnagram("anagram", "nagaram"));
    }
}
