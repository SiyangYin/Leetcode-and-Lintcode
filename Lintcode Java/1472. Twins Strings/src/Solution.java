public class Solution {
    /**
     * @param s: the first string
     * @param t: the second string
     * @return: If they are twin strings
     */
    public String isTwin(String s, String t) {
        // Write your code here
        if (s.length() != t.length()) {
            return "No";
        }
        
        return check(s, t, 0) && check(s, t, 1) ? "Yes" : "No";
    }
    
    private boolean check(String s, String t, int start) {
        int[] count = new int[256];
        for (int i = start; i < s.length(); i += 2) {
            char c = s.charAt(i);
            count[c]++;
        }
        for (int i = start; i < t.length(); i += 2) {
            char c = t.charAt(i);
            if (count[c] == 0) {
                return false;
            }
            
            count[c]--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().isTwin("abcd", "cdab"));
    }
}
