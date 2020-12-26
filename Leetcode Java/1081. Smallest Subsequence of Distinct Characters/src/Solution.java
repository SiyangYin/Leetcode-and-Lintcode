public class Solution {
    public String smallestSubsequence(String s) {
        int[] pos = new int[26];
        for (int i = 0; i < s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        
        boolean[] used = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (used[s.charAt(i) - 'a']) {
                continue;
            }
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) > s.charAt(i) && pos[sb.charAt(sb.length() - 1) - 'a'] > i) {
                used[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.setLength(sb.length() - 1);
            }
            
            sb.append(s.charAt(i));
            used[s.charAt(i) - 'a'] = true;
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().smallestSubsequence("bcabc"));
        System.out.println(new Solution().smallestSubsequence("abcacb"));
    }
}
