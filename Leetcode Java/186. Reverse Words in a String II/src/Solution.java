public class Solution {
    public void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        
        int l = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                flip(s, l, i - 1);
                l = i + 1;
            }
        }
        
        flip(s, l, s.length - 1);
        flip(s, 0, s.length - 1);
    }
    
    private void flip(char[] s, int l, int r) {
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
