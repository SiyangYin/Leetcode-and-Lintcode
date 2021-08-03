import java.util.Arrays;

public class Solution {
    public int kSimilarity(String s1, String s2) {
        char[] chs1 = s1.toCharArray(), chs2 = s2.toCharArray();
        int maxDepth = 0;
        while (!dfs(0, maxDepth, 0, chs1, chs2)) {
            maxDepth++;
        }
        
        return maxDepth;
    }
    
    private boolean dfs(int depth, int maxDepth, int pos, char[] s1, char[] s2) {
        if (depth == maxDepth) {
            return Arrays.equals(s1, s2);
        }
        
        if (depth + h(s1, s2) > maxDepth) {
            return false;
        }
        
        for (int i = pos; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                for (int j = i + 1; j < s1.length; j++) {
                    if (s1[j] == s2[i]) {
                        swap(s1, i, j);
                        if (dfs(depth + 1, maxDepth, i + 1, s1, s2)) {
                            return true;
                        }
                        swap(s1, i, j);
                    }
                }
                
                break;
            }
        }
        
        return false;
    }
    
    private int h(char[] s1, char[] s2) {
        int res = 0;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                res++;
            }
        }
        
        return res + 1 >> 1;
    }
    
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().kSimilarity("aabc", "abca"));
        System.out.println(new Solution().kSimilarity("abac", "baca"));
    }
}
