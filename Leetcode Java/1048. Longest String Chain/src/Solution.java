import java.util.Arrays;

public class Solution {
    
    class Trie {
        class Node {
            Node[] nexts;
            boolean isWord;
            int idx;
    
            public Node() {
                nexts = new Node[26];
            }
        }
        
        private Node root;
    
        public Trie() {
            root = new Node();
        }
    
        public void put(String word, int idx) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    cur.nexts[ch - 'a'] = new Node();
                }
                
                cur = cur.nexts[ch - 'a'];
            }
            
            cur.isWord = true;
            cur.idx = idx;
        }
        
        public int get(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    return -1;
                }
                
                cur = cur.nexts[ch - 'a'];
            }
            
            return cur.isWord ? cur.idx : -1;
        }
    }
    
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (w1, w2) -> Integer.compare(w1.length(), w2.length()));
        int[] dp = new int[words.length];
        
        Trie mapToIdx = new Trie();
        for (int i = 0; i < words.length; i++) {
            mapToIdx.put(words[i], i);
        }
        
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            dp[i] = 1;
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                String pre = word.substring(0, j) + word.substring(j + 1);
                int idx = mapToIdx.get(pre);
                if (idx != -1) {
                    dp[i] = Math.max(dp[i], 1 + dp[idx]);
                }
                
            }
            
            res = Math.max(res, dp[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}));
    }
}
