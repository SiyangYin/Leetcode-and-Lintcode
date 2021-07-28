public class Solution {
    public boolean areOccurrencesEqual(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        
        int x = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && x == 0) {
                x = cnt[i];
            }
            
            if (x > 0 && cnt[i] != 0 && cnt[i] != x) {
                return false;
            }
        }
        
        return true;
    }
}
