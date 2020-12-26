import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param s: a string only contains `a-f`
     * @return: The longest length that satisfies the condition
     */
    public int conditionString(String s) {
        // write your code here
        return LIS(s, new char[s.length()], Arrays.asList('a', 'c', 'e')) + LIS(s, new char[s.length()], Arrays.asList('b', 'd', 'f'));
    }
    
    private int LIS(String s, char[] f, List<Character> chars) {
        int idx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!chars.contains(ch)) {
                continue;
            }
        
            int pos = binarySearch(f, idx - 1, ch);
            if (pos == -1) {
                f[idx++] = ch;
            } else {
                f[pos] = ch;
            }
        }
        
        return idx;
    }
    
    private int binarySearch(char[] f, int r, char target) {
        int l = 0;
        if (l > r) {
            return -1;
        }
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (f[m] > target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        return f[l] > target ? l : -1;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().conditionString("abcdef"));
        // System.out.println(new Solution().conditionString("fedcba"));
        System.out.println(new Solution().conditionString("abacfecbbd"));
    }
}
