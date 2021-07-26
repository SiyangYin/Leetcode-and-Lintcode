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
            // 长在前，枚举分界点k，并且考虑s[k:]是回文串的情况，找s[0:k-1]镜像
            for (int k = 0; k <= s.length(); k++) {
                if (k >= 1) {
                    hash += s.charAt(k - 1) * pow;
                    pow *= P;
                }
                
                if (isPalin(s, k, s.length() - 1)) {
                    int idx = map.getOrDefault(hash, -1);
                    if (idx != -1 && idx != i) {
                        res.add(Arrays.asList(i, idx));
                    }
                }
            }
            
            hash = 0;
            // 长在后，枚举分界点k，并且考虑s[0:k-1]是回文串的情况，找s[k:]的镜像
            for (int k = s.length(); k >= 0; k--) {
                if (k < s.length()) {
                    hash = hash * P + s.charAt(k);
                }
                
                if (isPalin(s, 0, k - 1)) {
                    int idx = map.getOrDefault(hash, -1);
                    if (idx != -1 && idx != i) {
                        if (words[idx].length() == s.length()) {
                            continue;
                        }
                        
                        res.add(Arrays.asList(idx, i));
                    }
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
        // String[] ss = {"a", ""};
        System.out.println(new Solution().palindromePairs(ss));
    }
}
