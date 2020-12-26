import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int color = image[sr][sc];
        boolean[][] visited = new boolean[image.length][image[0].length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sr, sc});
        int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            image[cur[0]][cur[1]] = newColor;
            visited[cur[0]][cur[1]] = true;
            for (int i = 0; i < 4; i++) {
                int newX = cur[0] + d[i][0];
                int newY = cur[1] + d[i][1];
                if (0 <= newX && newX < image.length && 0 <= newY && newY < image[0].length
                        && image[newX][newY] == color && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
        
        return image;
    }
    
    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        System.out.println(Arrays.deepToString(new Solution().floodFill(image, 1, 1, 2)));
    }
}
