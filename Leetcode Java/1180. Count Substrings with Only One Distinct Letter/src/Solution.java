public class Solution {
    public int countLetters(String S) {
        int res = 0;
        for (int i = 0; i < S.length(); i++) {
            int j = i;
            while (j < S.length() && S.charAt(j) == S.charAt(i)) {
                j++;
            }
            res += (1 + j - i) * (j - i) / 2;
            
            i = j - 1;
        }
        
        return res;
    }
}
