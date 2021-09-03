public class Solution {
    /**
     * @param image: a binary matrix with '0' and '1'
     * @param x:     the location of one of the black pixels
     * @param y:     the location of one of the black pixels
     * @return: an integer
     */
    public int minArea(char[][] image, int x, int y) {
        int left, right, up, down;
        int l = 0, r = y;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (colHas1(image, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
    
        left = l;
    
        l = y;
        r = image[0].length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (colHas1(image, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        right = l;
    
        l = 0;
        r = x;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (rowHas1(image, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        up = l;
    
        l = x;
        r = image.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (rowHas1(image, m)) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        down = l;
    
        return (right - left + 1) * (down - up + 1);
    }
    
    private boolean rowHas1(char[][] image, int x) {
        for (int i = 0; i < image[0].length; i++) {
            if (image[x][i] == '1') {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean colHas1(char[][] image, int y) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][y] == '1') {
                return true;
            }
        }
        
        return false;
    }
}
