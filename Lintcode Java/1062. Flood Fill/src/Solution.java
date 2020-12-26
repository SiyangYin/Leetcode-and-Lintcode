public class Solution {
    /**
     * @param image: a 2-D array
     * @param sr: an integer
     * @param sc: an integer
     * @param newColor: an integer
     * @return: the modified image
     */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Write your code here
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int oldColor, int newColor) {
        image[x][y] = newColor;
        int[] d = {-1, 0, 1, 0, -1};
        for (int i = 0; i < d.length - 1; i++) {
            int nextX = x + d[i], nextY = y + d[i + 1];
            if (inBound(image, nextX, nextY) && image[nextX][nextY] == oldColor) {
                dfs(image, nextX, nextY, oldColor, newColor);
            }
        }
    }
    
    private boolean inBound(int[][] image, int x, int y) {
        return 0 <= x && x < image.length && 0 <= y && y < image[0].length;
    }
}
