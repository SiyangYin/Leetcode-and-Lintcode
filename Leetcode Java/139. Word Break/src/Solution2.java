import java.util.List;

public class Solution2 {
    
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
        
        public void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    cur.nexts[ch - 'a'] = new Node();
                }
                cur = cur.nexts[ch - 'a'];
            }
            
            cur.isWord = true;
        }
        
        public boolean contains(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    return false;
                }
                cur = cur.nexts[ch - 'a'];
            }
            
            return cur.isWord;
        }
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie trie = new Trie();
        int minl = Integer.MAX_VALUE, maxl = 0;
        for (String word : wordDict) {
            trie.insert(word);
            minl = Math.min(minl, word.length());
            maxl = Math.max(maxl, word.length());
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            if (trie.contains(s.substring(0, i))) {
                dp[i] = true;
                continue;
            }
            
            for (int j = minl; j <= maxl; j++) {
                if (j >= i) {
                    break;
                }
                
                dp[i] |= dp[i - j] && trie.contains(s.substring(i - j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
    
    public static void main(String[] args) {
    
    }
}
