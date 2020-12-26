public class Solution2 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int oldColor = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        dfs(image, sr, sc, newColor, oldColor, visited, d);
        
        return image;
    }
    
    private void dfs(int[][] image, int x, int y, int newColor, int oldColor, boolean[][] visited, int[][] d) {
        image[x][y] = newColor;
        visited[x][y] = true;
    
        for (int i = 0; i < 4; i++) {
            int newX = x + d[i][0];
            int newY = y + d[i][1];
            
            if (0 <= newX && newX < image.length && 0 <= newY && newY < image[0].length
                    && image[newX][newY] == oldColor && !visited[newX][newY]) {
                dfs(image, newX, newY, newColor, oldColor, visited, d);
            }
        }
    }
}
