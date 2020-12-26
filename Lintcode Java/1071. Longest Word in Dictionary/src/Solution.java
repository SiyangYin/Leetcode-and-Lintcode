public class Solution {
    
    class Trie {
        class Node {
            boolean isWord;
            Node[] nexts;
            
            public Node() {
                nexts = new Node[26];
            }
        }
        
        private Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                int idx = s.charAt(i) - 'a';
                if (cur.nexts[idx] == null) {
                    cur.nexts[idx] = new Node();
                }
                
                cur = cur.nexts[idx];
            }
            
            cur.isWord = true;
        }
        
        private String res;
        
        public void dfs(Node cur, StringBuilder sb) {
            if (cur != root && !cur.isWord) {
                return;
            }
            
            for (int i = 0; i < cur.nexts.length; i++) {
                if (cur.nexts[i] != null) {
                    sb.append((char) ('a' + i));
                    dfs(cur.nexts[i], sb);
                    sb.setLength(sb.length() - 1);
                }
            }
            
            if (cur.isWord && res == null || sb.length() > res.length()) {
                res = sb.toString();
            }
        }
    }
    
    /**
     * @param words: a list of strings
     * @return: the longest word in words that can be built one character at a time by other words in words
     */
    public String longestWord(String[] words) {
        // Write your code here
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        trie.dfs(trie.root, new StringBuilder());
        
        return trie.res;
    }
    
    public static void main(String[] args) {
        String[] ss = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(new Solution().longestWord(ss));
    }
}
