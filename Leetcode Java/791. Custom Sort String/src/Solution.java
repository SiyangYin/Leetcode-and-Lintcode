public class Solution {
    public String customSortString(String S, String T) {
        if (S == null || S.isEmpty() || T == null || T.isEmpty()) {
            return T;
        }
        
        int[] letters = new int[26];
        for (int i = 0; i < T.length(); i++) {
            letters[T.charAt(i) - 'a']++;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (letters[S.charAt(i) - 'a'] > 0) {
                while (letters[S.charAt(i) - 'a'] > 0) {
                    sb.append(S.charAt(i));
                    letters[S.charAt(i) - 'a']--;
                }
            }
        }
        
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] > 0) {
                while (letters[i] > 0) {
                    sb.append((char) ('a' + i));
                    letters[i]--;
                }
            }
        }
        
        return sb.toString();
    }
}
