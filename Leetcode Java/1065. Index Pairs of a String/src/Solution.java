import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Trie {
        class Node {
            boolean isWord;
            Node[] next;
            
            Node() {
                next = new Node[26];
            }
        }
        
        private Node root;
        
        Trie(String[] words) {
            root = new Node();
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
        
        public List<Integer> hasPrefix(String word, int start) {
            List<Integer> end = new ArrayList<>();
            Node cur = root;
            for (int i = start; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] == null) {
                    return end;
                }
                
                cur = cur.next[c - 'a'];
                if (cur.isWord) {
                    end.add(i);
                }
            }
            
            return end;
        }
    }
    
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        Trie trie = new Trie(words);
        
        for (int i = 0; i < text.length(); i++) {
            for (int end : trie.hasPrefix(text, i)) {
                list.add(new int[]{i, end});
            }
        }
        
        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] words = {"aba", "ab"};
        System.out.println(Arrays.deepToString(new Solution().indexPairs("ababa", words)));
    }
}
