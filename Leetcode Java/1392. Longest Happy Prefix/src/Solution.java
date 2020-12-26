public class Solution {
    public String longestPrefix(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        
        int[] next = new int[s.length() + 1];
        
        int i = 0, j = next[0] = -1;
        while (i < s.length()) {
            while (j != -1 && s.charAt(i) != s.charAt(j)) {
                j = next[j];
            }
            i++;
            j++;
            next[i] = j;
        }
        
        int l = next[s.length()];
        return s.substring(0, l);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestPrefix("ababab"));
    }
}
