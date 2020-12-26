public class Solution {
    /**
     * @param carrot: an integer matrix
     * @return: Return the number of steps that can be moved.
     */
    public int PickCarrots(int[][] carrot) {
        // write your code here
        int m = carrot.length, n = carrot[0].length;
        int x = (m - 1) >> 1, y = (n - 1) >> 1;
        
        int res = carrot[x][y], dir = 0;
        int[] d = {1, 0, -1, 0, 1};
        while ((dir = getDir(x, y, carrot, d)) != -1) {
            carrot[x][y] = 0;
            x += d[dir];
            y += d[dir + 1];
            res += carrot[x][y];
        }
        
        return res;
    }
    
    private int getDir(int x, int y, int[][] carrot, int[] d) {
        int max = 0, maxDir = -1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, carrot)) {
                if (carrot[nextX][nextY] > max) {
                    max = carrot[nextX][nextY];
                    maxDir = i;
                }
            }
        }
        
        return max == 0 ? -1 : maxDir;
    }
    
    private boolean inBound(int x, int y, int[][] carrot) {
        return 0 <= x && x < carrot.length && 0 <= y && y < carrot[0].length;
    }
}
