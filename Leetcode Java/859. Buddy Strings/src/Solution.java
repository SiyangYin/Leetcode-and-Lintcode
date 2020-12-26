public class Solution {
    public boolean buddyStrings(String A, String B) {
        if (A.length() != B.length() || A.length() < 2) {
            return false;
        }
        
        int[] count = new int[26];
        boolean hasDup = false;
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            count[ch - 'a']++;
            if (count[ch - 'a'] >= 2) {
                hasDup = true;
            }
        }
        
        for (int i = 0; i < B.length(); i++) {
            char ch = B.charAt(i);
            if (count[ch - 'a'] == 0) {
                return false;
            }
            count[ch - 'a']--;
        }
        
        int diff = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff++;
            }
        }
        
        return diff == 2 || (diff == 0 && hasDup);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().buddyStrings("ab", "ba"));
    }
}
