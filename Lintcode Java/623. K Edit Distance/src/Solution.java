import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    class Node {
        Node[] next;
        boolean isWord;
        String word;
        
        public Node() {
            next = new Node[26];
        }
    }
    
    private Node root;
    
    private void insert(Node root, String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (cur.next[ch - 'a'] == null) {
                cur.next[ch - 'a'] = new Node();
            }
            cur = cur.next[ch - 'a'];
        }
        
        cur.isWord = true;
        cur.word = word;
    }
    
    
    /**
     * @param words:  a set of stirngs
     * @param target: a target string
     * @param k:      An integer
     * @return: output all the strings that meet the requirements
     */
    public List<String> kDistance(String[] words, String target, int k) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        root = new Node();
        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }
        
        int len = target.length();
        int[] dp = new int[len + 1];
        for (int i = 0; i <= len; i++) {
            dp[i] = i;
        }
        
        dfs(root, dp, res, target, k);
        
        return res;
    }
    
    // dp[cur][i]   t[0:i-1]
    private void dfs(Node cur, int[] dp, List<String> res, String target, int k) {
        int n = target.length();
        if (cur.isWord && dp[n] <= k) {
            res.add(cur.word);
        }
        
        int[] nextDp = new int[n + 1];
        for (int i = 0; i < 26; i++) {
            if (cur.next[i] == null) {
                continue;
            }
    
            nextDp[0] = dp[0] + 1;
            for (int j = 1; j <= n; j++) {
                if (i == target.charAt(j - 1) - 'a') {
                    nextDp[j] = dp[j - 1];
                } else {
                    nextDp[j] = Math.min(Math.min(1 + nextDp[j - 1], 1 + dp[j]), 1 + dp[j - 1]);
                }
            }
            
            dfs(cur.next[i], nextDp, res, target, k);
        }
    }
    
    public static void main(String[] args) {
        String[] w = {"abc", "abd", "abcd", "adc"};
        String t = "ac";
        int k = 1;
        System.out.println(new Solution().kDistance(w, t, k));
    }
}
