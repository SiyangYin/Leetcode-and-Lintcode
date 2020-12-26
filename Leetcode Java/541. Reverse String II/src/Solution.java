public class Solution {
    public String reverseStr(String s, int k) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        char[] str = s.toCharArray();
        int idx = 0;
        while (true) {
            if (idx + 2 * k <= str.length) {
                flip(str, idx, idx + k - 1);
                idx = idx + 2 * k;
            } else if (idx + k > str.length) {
                flip(str, idx, str.length - 1);
                break;
            } else {
                flip(str, idx, idx + k - 1);
                break;
            }
        }
        
        return new String(str);
    }
    
    private void flip(char[] str, int l, int r) {
        while (l < r) {
            char tmp = str[l];
            str[l] = str[r];
            str[r] = tmp;
            l++;
            r--;
        }
    }
}
