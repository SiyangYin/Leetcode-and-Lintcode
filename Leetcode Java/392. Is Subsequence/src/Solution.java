class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
    
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j < s.length() && s.charAt(j) == t.charAt(i)) {
                j++;
            }
        }
        
        return j == s.length();
    }
    
    
    public static void main(String[] args) {
        System.out.println(new Solution().isSubsequence("abd", "ahbgdc"));
    }
}