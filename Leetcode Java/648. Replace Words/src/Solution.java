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
        
        Node root;
        
        Trie(List<String> dict) {
            root = new Node();
            for (String word : dict) {
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
                
                if (cur.isWord) {
                    return;
                }
            }
            
            cur.isWord = true;
        }
        
        private String prefixOf(String word) {
            StringBuilder sb = new StringBuilder();
            Node cur = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (cur.next[c - 'a'] != null) {
                    cur = cur.next[c - 'a'];
                    sb.append(c);
                } else {
                    break;
                }
                
                if (cur.isWord) {
                    return sb.toString();
                }
            }
            
            return "";
        }
    }
    
    
    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie(dict);
        String[] words = sentence.split(" ");
    
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String pref = trie.prefixOf(word);
            if (!pref.isEmpty()) {
                words[i] = pref;
            }
        }
    
        return String.join(" ", words);
    }
    
    public static void main(String[] args) {
        List<String> dict = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        String sent = "the cattle was rattled by the battery";
        System.out.println(new Solution().replaceWords(dict, sent));
    }
}
