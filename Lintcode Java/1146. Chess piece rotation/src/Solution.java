public class Solution {
    /**
     * @param A: Initial chessboard
     * @param F: Flipped coordinates
     * @return: return to the flipped board.
     */
    public int[][] ChessPieceRotation(int[][] A, int[][] F) {
        // write your code here
        int[] d = {1, 0, -1, 0, 1};
        for (int[] pos : F) {
            for (int i = 0; i < 4; i++) {
                int nextX = pos[0] - 1 + d[i], nextY = pos[1] - 1 + d[i + 1];
                if (inBound(nextX, nextY, A)) {
                    A[nextX][nextY] ^= 1;
                }
            }
        }
        
        return A;
    }
    
    private boolean inBound(int x, int y, int[][] A) {
        return 0 <= x && x < A.length && 0 <= y && y < A[0].length;
    }
}
