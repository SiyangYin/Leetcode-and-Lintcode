import java.util.PriorityQueue;

public class Solution {
    
    class Trie {
        class Node {
            boolean isWord;
            Node[] next;
            Node() {
                next = new Node[26];
            }
        }
        
        Node root;
    
        Trie() {
            root = new Node();
        }
        
        Trie(String[] words) {
            root = new Node();
            root.isWord = true;
            for (String word : words) {
                insert(word);
            }
        }
    
        private void insert(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new Node();
                }
                cur = cur.next[c - 'a'];
            }
            
            cur.isWord = true;
        }
    }
    
    
    public String longestWord(String[] words) {
        Trie trie = new Trie(words);
        trie.root.isWord = true;
        PriorityQueue<String> pq = new PriorityQueue<>();
        dfs(trie.root, new StringBuilder(), pq);
     
        return pq.peek();
    }
    
    private void dfs(Trie.Node cur, StringBuilder sb, PriorityQueue<String> pq) {
        if (!cur.isWord) {
            return;
        }
    
        for (int i = 0; i < cur.next.length; i++) {
            if (cur.next[i] != null) {
                sb.append((char) ('a' + i));
                dfs(cur.next[i], sb, pq);
                sb.setLength(sb.length() - 1);
            }
        }
        
        if (pq.isEmpty() || sb.length() > pq.peek().length()) {
            pq.clear();
            pq.add(sb.toString());
        }
    }
    
    public static void main(String[] args) {
        // String[] words = {"w", "wo", "wor", "worl", "world"};
        // String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        String[] words = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        PriorityQueue<String> pq = new PriorityQueue<>();
        System.out.println(new Solution().longestWord(words));
    }
    
}
