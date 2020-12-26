import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        private Map<String, List<String>> map;
        
        public Trie() {
            root = new Node();
            map = new HashMap<>();
        }
        
        public Trie(String[] words) {
            this();
            for (String word : words) {
                insert(word);
            }
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
        
        
        public List<String> getPrefix(String pref) {
            if (map.containsKey(pref)) {
                return map.get(pref);
            }
            
            List<String> res = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            Node cur = root;
            for (int i = 0; i < pref.length(); i++) {
                char ch = pref.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    return res;
                }
                
                sb.append(ch);
                cur = cur.nexts[ch - 'a'];
            }
            
            dfs(cur, sb, res);
            map.putIfAbsent(pref, res);
            
            return res;
        }
        
        private void dfs(Node cur, StringBuilder sb, List<String> res) {
            if (cur.isWord) {
                res.add(sb.toString());
            }
            
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (cur.nexts[ch - 'a'] != null) {
                    sb.append(ch);
                    dfs(cur.nexts[ch - 'a'], sb, res);
                    sb.setLength(sb.length() - 1);
                }
            }
        }
    }
    
    /*
     * @param words: a set of words without duplicates
     * @return: all word squares
     */
    public List<List<String>> wordSquares(String[] words) {
        // write your code here
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0) {
            return res;
        }
        
        Trie trie = new Trie(words);
        
        dfs(0, new ArrayList<>(), words, res, trie);
        
        return res;
    }
    
    private void dfs(int pos, List<String> cur, String[] words, List<List<String>> res, Trie trie) {
        if (pos == words[0].length()) {
            res.add(new ArrayList<>(cur));
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            sb.append(cur.get(i).charAt(pos));
        }
        
        List<String> nextWord = trie.getPrefix(sb.toString());
        for (int i = 0; i < nextWord.size(); i++) {
            if (!checkPref(pos, nextWord.get(i), cur, words[0].length(), trie)) {
                continue;
            }
            
            cur.add(nextWord.get(i));
            dfs(pos + 1, cur, words, res, trie);
            cur.remove(cur.size() - 1);
        }
    }
    
    private boolean checkPref(int pos, String next, List<String> cur, int wordLen, Trie trie) {
        for (int i = pos + 1; i < wordLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < pos; j++) {
                sb.append(cur.get(j).charAt(i));
            }
            
            sb.append(next.charAt(i));
            if (trie.getPrefix(sb.toString()).isEmpty()) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] words = {"area", "lead", "wall", "lady", "ball"};
        System.out.println(new Solution().wordSquares(words));
        System.out.println("aa".hashCode());
    }
}
