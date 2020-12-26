import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    class Trie {
        
        class Node {
            Node[] nexts;
            boolean isWord;
            
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
            }
            
            cur.isWord = true;
        }
    }
    
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public List<String> wordSearchII(char[][] board, List<String> words) {
        // write your code here
        List<String> res = new ArrayList<>();
        
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (trie.root.nexts[board[i][j] - 'a'] != null) {
                    dfs(new StringBuilder(), board, i, j, trie.root.nexts[board[i][j] - 'a'], set);
                }
            }
        }
        
        res.addAll(set);
        return res;
    }
    
    private void dfs(StringBuilder sb, char[][] board, int x, int y, Trie.Node cur, Set<String> res) {
        sb.append(board[x][y]);
        if (cur.isWord) {
            res.add(sb.toString());
        }
        
        char old = board[x][y];
        board[x][y] = '#';
        
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(board, nextX, nextY) && board[nextX][nextY] != '#') {
                Trie.Node next = cur.nexts[board[nextX][nextY] - 'a'];
                if (next != null) {
                    dfs(sb, board, nextX, nextY, next, res);
                }
            }
        }
        
        sb.setLength(sb.length() - 1);
        board[x][y] = old;
    }
    
    private boolean inBound(char[][] board, int x, int y) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        char[][] b = {"doaf".toCharArray(), "agai".toCharArray(), "dcan".toCharArray()};
        List<String> words = new ArrayList<>() {{
            add("dog");
            add("dad");
            add("dgdg");
            add("can");
            add("again");
        }};
        
        System.out.println(new Solution().wordSearchII(b, words));
    }
}
