import java.util.*;

public class Solution {
    
    class Trie {
        class Node {
            boolean isWord;
            Map<Character, Node> next;
            
            Node() {
                next = new HashMap<>();
            }
        }
        
        Node root;
        
        Trie(String[] words) {
            root = new Node();
            for (String word : words) {
                add(word);
            }
        }
        
        private void add(String word) {
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (!cur.next.containsKey(c)) {
                    cur.next.put(c, new Node());
                }
                cur = cur.next.get(c);
            }
            
            cur.isWord = true;
        }
        
        public Set<String> search(String pattern) {
            Set<String> set = new HashSet<>();
            dfs(root, new StringBuilder(), pattern, 0, set);
            return set;
        }
        
        private void dfs(Node node, StringBuilder sb, String pattern, int start, Set<String> set) {
            if (start == pattern.length() && node.isWord) {
                set.add(sb.toString());
            }
            
            char ch = ' ';
            if (start < pattern.length()) {
                ch = pattern.charAt(start);
            }
            
            for (Map.Entry<Character, Node> entry : node.next.entrySet()) {
                if (entry.getKey() == ch) {
                    sb.append(ch);
                    dfs(node.next.get(ch), sb, pattern, start + 1, set);
                    sb.setLength(sb.length() - 1);
                } else {
                    char key = entry.getKey();
                    if (Character.isLowerCase(key)) {
                        sb.append(key);
                        dfs(node.next.get(key), sb, pattern, start, set);
                        sb.setLength(sb.length() - 1);
                    }
                }
            }
        }
    }
    
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        Trie trie = new Trie(queries);
        
        Set<String> set = trie.search(pattern);
        for (int i = 0; i < queries.length; i++) {
            res.add(set.contains(queries[i]));
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] q = {"FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack"};
        System.out.println(new Solution().camelMatch(q, "FB"));
    }
}
