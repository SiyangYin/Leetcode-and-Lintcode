import java.util.Arrays;

public class Solution {
    
    class Trie {
        class Node {
            int count;
            Node[] nexts;
            
            public Node() {
                nexts = new Node[26];
            }
        }
        
        Node root;
    
        public Trie() {
            root = new Node();
        }
    
        public void insert(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.nexts[ch - 'a'] == null) {
                    cur.nexts[ch - 'a'] = new Node();
                }
                
                cur = cur.nexts[ch - 'a'];
                cur.count++;
            }
        }
        
        public String getUniquePrefix(String s) {
            Node cur = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (cur.nexts[ch - 'a'].count == 1) {
                    return s.substring(0, i + 1);
                }
                
                cur = cur.nexts[ch - 'a'];
            }
            
            return s;
        }
    }
    
    /**
     * @param stringArray: a string array
     * @return: return every strings'short peifix
     */
    public String[] ShortPerfix(String[] stringArray) {
        // write your code here
        Trie trie = new Trie();
        for (String s : stringArray) {
            trie.insert(s);
        }
        
        String[] res = new String[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            res[i] = trie.getUniquePrefix(stringArray[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().ShortPerfix(new String[]{"aaa", "bbc", "bcd"})));
    }
}
