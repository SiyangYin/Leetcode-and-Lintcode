import java.util.Arrays;

public class Solution2 {
    public int strStr(String s, String p) {
        if (s.length() < p.length()) {
            return -1;
        }
        
        if (p.isEmpty()) {
            return 0;
        }
        
        int i = 0, j = 0;
        int[] next = buildNext(p);
        while (i < s.length() && j < p.length()) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        
        return j == p.length() ? i - j : -1;
    }
    
    private int[] buildNext(String p) {
        int[] next = new int[p.length()];
        int t = next[0] = -1, j = 0;
        while (j < p.length() - 1) {
            if (t < 0 || p.charAt(j) == p.charAt(t)) {
                j++;
                t++;
                next[j] = p.charAt(j) != p.charAt(t) ? t : next[t];
            } else {
                t = next[t];
            }
        }
        
        return next;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution2().buildNext("aaaab")));
    }
}
