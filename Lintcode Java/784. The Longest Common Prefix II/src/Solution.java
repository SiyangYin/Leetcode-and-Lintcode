import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param dic:    the n strings
     * @param target: the target string
     * @return: The ans
     */
    public int the_longest_common_prefix(List<String> dic, String target) {
        // write your code here
        int res = 0;
        for (String s : dic) {
            int len = Math.min(s.length(), target.length());
            for (int i = 0; i <= len; i++) {
                if (i == len || s.charAt(i) != target.charAt(i)) {
                    res = Math.max(res, i);
                    break;
                }
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().the_longest_common_prefix(Arrays.asList("abcba", "acc", "abwsf"), "abse"));
    }
}
