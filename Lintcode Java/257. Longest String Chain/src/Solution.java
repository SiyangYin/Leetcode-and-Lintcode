public class Solution {
    
    class Trie {
        class Node {
            Node[] nexts;
            boolean isWord;
            int len;
            
            public Node() {
                nexts = new Node[26];
            }
        }
        
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void put(String word, int len) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    cur.nexts[ch - 'a'] = new Node();
                }
                cur = cur.nexts[ch - 'a'];
            }
            
            cur.isWord = true;
            cur.len = len;
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
            
            return cur.len;
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
    
    private int res;
    
    /**
     * @param words: the list of word.
     * @return: the length of the longest string chain.
     */
    public int longestStrChain(String[] words) {
        // write your code here
        Trie trie = new Trie();
        for (String word : words) {
            trie.put(word, -1);
        }
        
        for (String word : words) {
            if (trie.get(word) == -1) {
                dfs(word, trie);
            }
        }
        
        return res;
    }
    
    private int dfs(String cur, Trie trie) {
        int len = trie.get(cur);
        if (len != -1) {
            return len;
        }
        
        len = 1;
        for (int i = 0; i < cur.length(); i++) {
            String s1 = cur.substring(0, i), s2 = cur.substring(i + 1);
            String next = s1 + s2;
            if (!trie.contains(next)) {
                continue;
            }
            
            int nextLen = dfs(next, trie);
            len = Math.max(len, 1 + nextLen);
        }
        
        res = Math.max(res, len);
        
        trie.put(cur, len);
        return len;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().longestStrChain(new String[]{"ba", "a", "b", "bca", "bda", "bdca"}));
    }
}
