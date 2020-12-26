public class Solution {
    
    class Trie {
        class Node {
            Node[] nexts;
            Node() {
                nexts = new Node[26];
            }
        }
        
        Node root;
        
        public Trie() {
            root = new Node();
        }
        
        public void insert(String s) {
            Node cur = root;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (cur.nexts[c - 'a'] == null) {
                    cur.nexts[c - 'a'] = new Node();
                }
                cur = cur.nexts[c - 'a'];
            }
        }
        
        public int dfs() {
            return dfs(root, 0);
        }
        
        private int dfs(Node root, int depth) {
            int res = 0;
            boolean isLeaf = true;
            for (int i = 0; i < root.nexts.length; i++) {
                if (root.nexts[i] != null) {
                    isLeaf = false;
                    res += dfs(root.nexts[i], depth + 1);
                }
            }
            
            if (isLeaf) {
                return depth + 1;
            } else {
                return res;
            }
        }
    }
    
    /**
     * @param words:
     * @return: nothing
     */
    public int minimumLengthEncoding(String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        return trie.dfs();
    }
    
    public static void main(String[] args) {
        String[] words = {"time", "me", "bell"};
        System.out.println(new Solution().minimumLengthEncoding(words));
    }
}
