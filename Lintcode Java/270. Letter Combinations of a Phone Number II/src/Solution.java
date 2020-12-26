import java.util.Arrays;

public class Solution {
    
    class Node {
        boolean isWord;
        Node[] nexts;
        int count;
        
        public Node() {
            nexts = new Node[10];
        }
    }
    
    private Node root;
    
    private void insert(String s, int[] map) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = map[s.charAt(i) - 'a'];
            if (cur.nexts[pos] == null) {
                cur.nexts[pos] = new Node();
            }
            
            cur.nexts[pos].count++;
            cur = cur.nexts[pos];
        }
    }
    
    private int query(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int pos = s.charAt(i) - '0';
            if (cur.nexts[pos] == null) {
                return 0;
            }
            
            cur = cur.nexts[pos];
        }
        
        return cur.count;
    }
    
    /**
     * @param queries: the queries
     * @param dict:    the words
     * @return: return the queries' answer
     */
    public int[] letterCombinationsII(String[] queries, String[] dict) {
        // write your code here
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            if (i < 15) {
                map[i] = i / 3 + 2;
            } else if (i < 19) {
                map[i] = 7;
            } else if (i < 22) {
                map[i] = 8;
            } else {
                map[i] = 9;
            }
        }
        
        root = new Node();
        for (int i = 0; i < dict.length; i++) {
            insert(dict[i], map);
        }
        
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = query(queries[i]);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        String[] qs = {"2", "3", "4"}, dic = {"a", "abc", "de", "fg"};
        
        System.out.println(Arrays.toString(new Solution().letterCombinationsII(qs, dic)));
    }
}
