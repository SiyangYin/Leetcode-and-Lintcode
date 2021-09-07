public class Solution {
    /**
     * @param licensePlate: a string
     * @param words: List[str]
     * @return: return a string
     */
    public String shortestCompletingWord(String licensePlate, String[] words) {
        // write your code here
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); i++) {
            char ch = licensePlate.charAt(i);
            if (Character.isLetter(ch)) {
                cnt[Character.toLowerCase(ch) - 'a']++;
            }
        }
        
        String res = null;
        for (String s : words) {
            int[] cntS = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cntS[s.charAt(i) - 'a']++;
            }
            
            boolean success = true;
            for (int i = 0; i < 26; i++) {
                if (cnt[i] > cntS[i]) {
                    success = false;
                    break;
                }
            }
            
            if (success && (res == null || res.length() > s.length())) {
                res = s;
            }
        }
        
        return res;
    }
}
