import java.util.*;

public class Solution {
    long P = 131;
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<Long> set = new HashSet<>();
        for (String s : words) {
            long ha = 0;
            for (int i = 0; i < s.length(); i++) {
                ha = ha * P + s.charAt(i);
            }
            set.add(ha);
        }
        
        for (String word : words) {
            if (check(word, set)) {
                res.add(word);
            }
        }
        
        return res;
    }
    
    private boolean check(String s, Set<Long> set) {
        int n = s.length();
        int[] f = new int[n + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (f[i] == -1) {
                continue;
            }
            
            long ha = 0;
            for (int j = i + 1; j <= n; j++) {
                ha = ha * P + s.charAt(j - 1);
                if (set.contains(ha)) {
                    f[j] = Math.max(f[j], f[i] + 1);
                }
                if (f[n] > 1) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String[] ss = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        // String[] ss = {"cat", "dog", "catdog"};
        // String[] ss = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa"};
        System.out.println(new Solution().findAllConcatenatedWordsInADict(ss));
    }
}
