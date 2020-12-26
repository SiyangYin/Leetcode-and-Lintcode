public class Solution {
    /**
     * @param source:
     * @param target:
     * @return: return the index
     */
    public int strStr(String source, String target) {
        // Write your code here
        if (target.length() == 0) {
            return 0;
        }
        if (target.length() > source.length()) {
            return -1;
        }
        int[] next = buildNext(target);
        char[] t = source.toCharArray();
        char[] p = target.toCharArray();
        int i = 0, j = 0;
        while (j < p.length && i < t.length) {  // k = 2i-j, O(n)
            if (0 > j || t[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (i - j > t.length - p.length)
            return -1;
        else
            return i - j;
    }
    
    public static int[] buildNext(String s) {
        char[] p = s.toCharArray();
        int[] next = new int[p.length];
        int t = next[0] = -1, j = 0;
        while (j < p.length - 1) {
            if (0 > t || p[j] == p[t]) {
                next[++j] = ++t;
                next[j] = (p[j] != p[t]) ? t : next[t]; // greedy
            }
            else {
                t = next[t];
            }
        }
        return next;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().strStr("a", "a"));
    }
}