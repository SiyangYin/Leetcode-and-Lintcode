import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param source: A string
     * @param words:  A list of string
     * @return: return list of words[i] that is a subsequence of source.
     */
    public List<String> MatchingSubsequences(String source, List<String> words) {
        // write your code here
        int[] idx = new int[words.size()];
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < words.size(); j++) {
                // 若已经匹配则跳过
                if (idx[j] == -1) {
                    continue;
                } else if (words.get(j).charAt(idx[j]) == source.charAt(i)) {
                    idx[j]++;
                }
                
                if (idx[j] == words.get(j).length()) {
                    idx[j] = -1;
                }
            }
        }
        
        //遍历答案
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            if (idx[i] == -1) {
                res.add(words.get(i));
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().MatchingSubsequences("abcde", Arrays.asList("a", "bb", "acd", "ace")));
    }
}
