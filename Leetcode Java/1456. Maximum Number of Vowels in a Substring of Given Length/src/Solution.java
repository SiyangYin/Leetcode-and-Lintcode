

public class Solution {
    public int maxVowels(String s, int k) {
        int res = 0, count = 0;
        for (int i = 0; i < Math.min(s.length(), k); i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        
        res = Math.max(res, count);
    
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                count--;
            }
            if (isVowel(s.charAt(i))) {
                count++;
            }
            
            res = Math.max(res, count);
        }
        
        return res;
    }
    
    private boolean isVowel(char c) {
        return (c == 'a' || c =='e' || c == 'i' || c == 'o' || c == 'u');
    }
}
