public class Solution {
    public String tictactoe(int[][] moves) {
        char[][] a = new char[3][3];
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0], y = moves[i][1];
            String s = check(a, i % 2 == 0 ? 'X' : 'O', x, y);
            if (s.length() == 1) {
                return s;
            }
        }
        
        return moves.length < 9 ? "Pending" : "Draw";
    }
    
    String check(char[][] a, char ch, int x, int y) {
        a[x][y] = ch;
        
        String res = ch == 'X' ? "A" : "B";
        if (a[x][0] == a[x][1] && a[x][0] == a[x][2]) {
            return res;
        }
        if (a[0][y] == a[1][y] && a[0][y] == a[2][y]) {
            return res;
        }
        if (x == y && a[0][0] == a[1][1] && a[0][0] == a[2][2]) {
            return res;
        }
        if (x + y == 2 && a[0][2] == a[1][1] && a[0][2] == a[2][0]) {
            return res;
        }
        
        return "";
    }
}
