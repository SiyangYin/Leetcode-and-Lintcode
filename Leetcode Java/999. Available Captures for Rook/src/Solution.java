public class Solution {
    public int numRookCaptures(char[][] board) {
        int[] rookPos = searchRook(board);
        int x = rookPos[0], y = rookPos[1];
        int res = 0;
        for (int i = x - 1; i >= 0; i--) {
            if (board[i][y] == 'p') {
                res += 1;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = x + 1; i < board.length; i++) {
            if (board[i][y] == 'p') {
                res += 1;
                break;
            } else if (board[i][y] == 'B') {
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (board[x][i] == 'p') {
                res += 1;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        for (int i = y + 1; i < board[0].length; i++) {
            if (board[x][i] == 'p') {
                res += 1;
                break;
            } else if (board[x][i] == 'B') {
                break;
            }
        }
        return res;
    }
    
    private int[] searchRook(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
