import java.util.*;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(hash(words[i]), i);
        }
        
        long P = 131L;
        // 枚举长的
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            long pow = 1, hash = 0;
            // 长在前
            for (int k = 0; k <= s.length(); k++) {
                if (k == s.length() || isPalin(s, k, s.length() - 1)) {
                    int idx = map.getOrDefault(hash, -1);
                    if (idx != -1 && idx != i) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
                
                if (k < s.length()) {
                    hash += s.charAt(k) * pow;
                    pow *= P;
                }
            }
            
            hash = 0;
            // 长在后
            for (int k = s.length() - 1; k >= -1; k--) {
                if (k == -1 || isPalin(s, 0, k)) {
                    int idx = map.getOrDefault(hash, -1);
                    if (idx != -1 && idx != i) {
                        if (words[idx].length() == s.length()) {
                            continue;
                        }
                        
                        res.add(Arrays.asList(idx, i));
                    }
                }
                
                if (k >= 0) {
                    hash = hash * P + s.charAt(k);
                }
            }
        }
        
        return res;
    }
    
    private boolean isPalin(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        
        return true;
    }
    
    private long hash(String s) {
        long hash = 0, P = 131L;
        for (int i = 0; i < s.length(); i++) {
            hash = hash * P + s.charAt(i);
        }
        
        return hash;
    }
    
    public static void main(String[] args) {
        String[] ss = {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new Solution().palindromePairs(ss));
    }
}
