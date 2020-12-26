import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Node {
        boolean isWord;
        Node[] nexts;
        
        public Node() {
            nexts = new Node[26];
        }
    }
    
    private Node root;
    private String res;
    
    /**
     * @param s: a string
     * @param d: List[str]
     * @return: return a string
     */
    public String findLongestWord(String s, List<String> d) {
        // write your code  here
        root = new Node();
        for (String w : d) {
            insert(w);
        }
        
        res = "";
        dfs(root, 0, s, new StringBuilder());
        return res;
    }
    
    private void dfs(Node cur, int pos, String s, StringBuilder sb) {
        if (cur.isWord) {
            String str = sb.toString();
            if (str.length() > res.length() || (str.length() == res.length() && str.compareTo(res) < 0)) {
                res = str;
            }
        }
        
        for (int i = pos; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (cur.nexts[ch - 'a'] != null) {
                dfs(cur.nexts[ch - 'a'], i + 1, s, sb.append(ch));
                sb.setLength(sb.length() - 1);
            }
        }
    }
    
    private void insert(String s) {
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
    
    public static void main(String[] args) {
        System.out.println(new Solution().findLongestWord("abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")));
    }
}
