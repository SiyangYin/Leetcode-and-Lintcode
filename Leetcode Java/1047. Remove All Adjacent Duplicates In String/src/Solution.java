public class Solution {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < S.length(); j++) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == S.charAt(j)) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(S.charAt(j));
            }
        }
        
        return new String(sb);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abbaca"));
    }
}
