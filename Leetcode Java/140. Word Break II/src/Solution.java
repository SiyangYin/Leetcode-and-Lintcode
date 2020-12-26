import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Trie {
        class Node {
            Node[] nexts;
            boolean isWord;
            
            public Node() {
                nexts = new Node[26];
            }
        }
        
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    cur.nexts[ch - 'a'] = new Node();
                }
                cur = cur.nexts[ch - 'a'];
            }
            
            cur.isWord = true;
        }
        
        public boolean contains(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[ch - 'a'];
            }
            
            return cur.isWord;
        }
    }
    
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        
        Trie trie = new Trie();
        int minl = Integer.MAX_VALUE, maxl = 0;
        for (String word : wordDict) {
            trie.insert(word);
            minl = Math.min(minl, word.length());
            maxl = Math.max(maxl, word.length());
        }
        
        // dp[i]表示s的后i个字符组成的字符串是否能被组合出来
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j >= minl && i - j <= maxl) {
                    dp[i] = dp[j] && trie.contains(s.substring(s.length() - i, s.length() - j));
                    if (dp[i]) {
                        break;
                    }
                }
            }
        }
        
        dfs(new StringBuilder(), s, 0, dp, trie, res, minl, maxl);
        return res;
    }
    
    private void dfs(StringBuilder sb, String s, int pos, boolean[] dp, Trie trie, List<String> res, int minl, int maxl) {
        if (pos == s.length()) {
            res.add(sb.substring(0, sb.length() - 1));
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            if (i - pos + 1 >= minl && i - pos + 1 <= maxl) {
                String cur = s.substring(pos, i + 1);
                if (trie.contains(cur) && dp[s.length() - i - 1]) {
                    sb.append(cur).append(' ');
                    dfs(sb, s, i + 1, dp, trie, res, minl, maxl);
                    sb.setLength(sb.length() - cur.length() - 1);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        List<String> list = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        List<String> res = new Solution().wordBreak("pineapplepenapple", list);
        System.out.println(res);
    }
}
