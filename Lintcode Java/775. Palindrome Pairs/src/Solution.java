import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Node {
        int idx;
        Node[] nexts;
        List<Integer> pos;
        
        Node() {
            idx = -1;
            nexts = new Node[26];
            pos = new ArrayList<>();
        }
    }
    
    private Node root;
    
    /**
     * @param words: a list of unique words
     * @return: all pairs of distinct indices
     */
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        
        root = new Node();
        
        for (int i = 0; i < words.length; i++) {
            insert(words[i], i);
        }
        
        for (int i = 0; i < words.length; i++) {
            search(words[i], i, res);
        }
        
        return res;
    }
    
    private void search(String s, int idx, List<List<Integer>> res) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            if (cur.idx != -1 && cur.idx != idx && isPalin(s, i, s.length() - 1)) {
                res.add(Arrays.asList(idx, cur.idx));
            }
            
            if (cur.nexts[s.charAt(i) - 'a'] == null) {
                return;
            }
            
            cur = cur.nexts[s.charAt(i) - 'a'];
        }
        
        //Trie str is longer than word
        for (int i : cur.pos) {
            if (i == idx) {
                continue;
            }
            
            res.add(Arrays.asList(idx, i));
        }
    }
    
    private void insert(String word, int idx) {
        Node cur = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            if (isPalin(word, 0, i)) {
                cur.pos.add(idx);
            }
            
            char ch = word.charAt(i);
            if (cur.nexts[ch - 'a'] == null) {
                cur.nexts[ch - 'a'] = new Node();
            }
            
            cur = cur.nexts[ch - 'a'];
        }
        
        cur.idx = idx;
        cur.pos.add(idx);
    }
    
    private boolean isPalin(String s, int i, int j) {
        for (; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[] words = {"bat", "tab", "cat"};
        // String[] words = {"sssll"};
        // String[] words = {"bab", ""};
        System.out.println(new Solution().palindromePairs(words));
    }
}
