public class Solution {
    /*
     * @param source: A source string
     * @param target: A target string
     * @return: An integer as index
     */
    public int strStr2(String source, String target) {
        // write your code here
        if (source == null || target == null) {
            return -1;
        }
        if (target.isEmpty()) {
            return 0;
        }
        
        int[] next = buildNext(target);
        int i = 0, j = 0;
        while (i < source.length() && j < target.length()) {
            if (j < 0 || source.charAt(i) == target.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        
        return j == target.length() ? i - j : -1;
    }
    
    private int[] buildNext(String target) {
        int[] next = new int[target.length()];
        int t = next[0] = -1;
        int j = 0;
        while (j < target.length() - 1) {
            if (t < 0 || target.charAt(j) == target.charAt(t)) {
                j++;
                t++;
                next[j] = target.charAt(j) != target.charAt(t) ? t : next[t];
            } else {
                t = next[t];
            }
        }
        
        return next;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().strStr2("abcdef", "bcd"));
        System.out.println(new Solution().strStr2("", ""));
    }
}
