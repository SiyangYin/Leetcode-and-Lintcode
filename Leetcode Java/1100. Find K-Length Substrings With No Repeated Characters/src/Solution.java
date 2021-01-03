public class Solution {
    public int numKLenSubstrNoRepeats(String S, int K) {
        if (S.length() < K) {
            return 0;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < K; i++) {
            count[S.charAt(i) - 'a']++;
        }
        
        int res = check(count) ? 1 : 0;
        for (int i = K; i < S.length(); i++) {
            count[S.charAt(i - K) - 'a']--;
            count[S.charAt(i) - 'a']++;
            if (check(count)) {
                res++;
            }
        }
        
        return res;
    }
    
    private boolean check(int[] count){
        for (int i = 0; i < 26; i++) {
            if (count[i] >= 2) {
                return false;
            }
        }
        
        return true;
    }
}
