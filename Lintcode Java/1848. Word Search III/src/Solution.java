import java.util.Arrays;
import java.util.List;

public class Solution {
    
    class Node {
        Node[] next;
        boolean isWord;
        
        public Node() {
            next = new Node[26];
        }
    }
    
    Node root;
    
    void insert(String s) {
        Node cur = root;
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node();
            }
            
            cur = cur.next[idx];
        }
        
        cur.isWord = true;
    }
    
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: return the maximum nunber
     */
    public int wordSearchIII(char[][] board, List<String> words) {
        // write your code here
        root = new Node();
        for (String word : words) {
            insert(word);
        }
        
        int m = board.length, n = board[0].length;
        int res = 0;
        int[] d = {-1, 0, 1, 0, -1};
        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = Math.max(res, dfs(i, j, i, j, root, vis, d, board));
            }
        }
        
        return res;
    }
    
    int dfs(int x, int y, int ox, int oy, Node cur, boolean[][] vis, int[] d, char[][] board) {
        if (cur.next[board[x][y] - 'a'] == null) {
            return 0;
        }
        
        cur = cur.next[board[x][y] - 'a'];
        int res = 0;
        vis[x][y] = true;
        if (cur.isWord) {
            cur.isWord = false;
            res = 1;
            for (int ny = oy + 1; ny < board[0].length; ny++) {
                if (!vis[ox][ny]) {
                    res = Math.max(res, 1 + dfs(ox, ny, ox, ny, root, vis, d, board));
                }
            }
            for (int nx = ox + 1; nx < board.length; nx++) {
                for (int ny = 0; ny < board[0].length; ny++) {
                    if (!vis[nx][ny]) {
                        res = Math.max(res, 1 + dfs(nx, ny, nx, ny, root, vis, d, board));
                    }
                }
            }
            
            cur.isWord = true;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + d[i], ny = y + d[i + 1];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && !vis[nx][ny]) {
                res = Math.max(res, dfs(nx, ny, ox, oy, cur, vis, d, board));
            }
        }
        
        vis[x][y] = false;
        return res;
    }
    
    public static void main(String[] args) {
        char[][] b = {
                "acabc".toCharArray(),
                "asdwf".toCharArray(),
                "bfeww".toCharArray()
        };
        
        List<String> list = Arrays.asList("abc", "aab", "dgdg", "can", "again");
        System.out.println(new Solution().wordSearchIII(b, list));
    }
}
