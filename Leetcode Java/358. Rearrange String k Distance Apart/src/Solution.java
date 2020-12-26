import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public static String rearrangeString(String s, int k) {
        if (k <= 1) {
            return s;
        }
        
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - 'a';
            count[pos]++;
            if (count[pos] > (s.length() - 1) / k + 1) {
                return "";
            }
        }
        
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> {
            if (count[c1 - 'a'] != count[c2 - 'a']) {
                return -Integer.compare(count[c1 - 'a'], count[c2 - 'a']);
            }
            
            return Character.compare(c1, c2);
        });
        
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] > 0) {
                maxHeap.offer(ch);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        List<Character> list = new ArrayList<>();
        
        int len = s.length();
        while (!maxHeap.isEmpty()) {
            k = Math.min(len, k);
            for (int i = 0; i < k; i++) {
                if (!maxHeap.isEmpty()) {
                    char cur = maxHeap.poll();
                    sb.append(cur);
                    count[cur - 'a']--;
                    len--;
                    if (count[cur - 'a'] > 0) {
                        list.add(cur);
                    }
                    
                } else {
                    return "";
                }
            }
            
            maxHeap.addAll(list);
            list.clear();
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().rearrangeString("aabbcc", 3));
        // System.out.println(new Solution().rearrangeString("aa", 1));
        // System.out.println(new Solution().rearrangeString("aa", 0));
        // System.out.println(new Solution().rearrangeString("abcdabcdabdeac", 4));
        // System.out.println(new Solution().rearrangeString("abcdabcdabdeaa", 4));
        // System.out.println(new Solution().rearrangeString("abcdabcdabdea", 4));
        // System.out.println(rearrangeString("aabbccdbcddc", 3));
        String s1 = "aabbccdbcddc";
        String s2 = "abbccdbcdd";
        char[] ss = "aabbccdbcdd".toCharArray();
        Arrays.sort(ss);
        // System.out.println(ss);
        
        
        // System.out.println(new Solution().rearrangeString("aabbccdbcddd", 3));
        // System.out.println(rearrangeString("aabbccdbcd", 3));
        System.out.println(rearrangeString("bcbcbcadad", 2));
        System.out.println(rearrangeString("bcbcaa", 2));
        // System.out.println(new Solution().rearrangeString("a", 2));
        // System.out.println(new Solution().rearrangeString("abb", 2));
    }
    
    public static int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        
        int[][] dp = new int[l1 + 1][l2 + 1];
        dp[0][0] = 0;
        
        for (int i = 0; i < l1 + 1; i++) {
            for (int j = 0; j < l2 + 1; j++) {
                if (i == 0) {
                    dp[0][j] = j;
                } else if (j == 0) {
                    dp[i][0] = i;
                } else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int replace = 1 + dp[i - 1][j - 1];
                        int delete = 1 + dp[i - 1][j];
                        int insert = 1 + dp[i][j - 1];
                        dp[i][j] = Math.min(replace, Math.min(delete, insert));
                    }
                }
            }
        }
        
        return dp[l1][l2];
    }
}
