public class Solution {
    private int l, r, u, d;
    
    public int minArea(char[][] image, int x, int y) {
        l = r = y;
        u = d = x;
        dfs(x, y, image);
        
        return (r - l + 1) * (d - u + 1);
    }
    
    private void dfs(int x, int y, char[][] image) {
        image[x][y] = '0';
        l = Math.min(l, y);
        r = Math.max(r, y);
        u = Math.min(u, x);
        d = Math.max(d, x);
        int[] d = {1, 0, -1, 0, 1};
        for (int i = 0; i < 4; i++) {
            int nextX  = x + d[i], nextY = y + d[i + 1];
            if (inBound(nextX, nextY, image) && image[nextX][nextY] == '1') {
                dfs(nextX, nextY, image);
            }
        }
    }
    
    private boolean inBound(int x, int y, char[][] image) {
        return 0 <= x && x < image.length && 0 <= y && y < image[0].length;
    }
    
    public static void main(String[] args) {
        char[][] img = {"0010".toCharArray(), "0110".toCharArray(), "0100".toCharArray()};
        System.out.println(new Solution().minArea(img, 0, 2));
    }
}
