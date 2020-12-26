import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    
    class Node {
        Node[] nexts;
        boolean isWord;
        
        public Node() {
            nexts = new Node[26];
        }
    }
    
    Node root;
    
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
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String word : words) {
            insert(word);
        }
        
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, new StringBuilder(), root, board, set);
            }
        }
        
        List<String> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }
    
    private void dfs(int x, int y, StringBuilder sb, Node cur, char[][] board, Set<String> set) {
        char ch = board[x][y];
        if (cur.nexts[ch - 'a'] == null) {
            return;
        }
        
        cur = cur.nexts[ch - 'a'];
        board[x][y] = '#';
        sb.append(ch);
        
        if (cur.isWord) {
            set.add(sb.toString());
        }
        
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, board) && board[nextX][nextY] != '#') {
                dfs(nextX, nextY, sb, cur, board, set);
            }
        }
        
        sb.setLength(sb.length() - 1);
        board[x][y] = ch;
    }
    
    private boolean inBound(int x, int y, char[][] board) {
        return 0 <= x && x < board.length && 0 <= y && y < board[0].length;
    }
    
    public static void main(String[] args) {
        char[][] b = {"oaan".toCharArray(), "etae".toCharArray(), "ihkr".toCharArray(), "iflv".toCharArray()};
        String[] s = {"oath", "pea", "eat", "rain"};
        System.out.println(new Solution().findWords(b, s));
    }
}
