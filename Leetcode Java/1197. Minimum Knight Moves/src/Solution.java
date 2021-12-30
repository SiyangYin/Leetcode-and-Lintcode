public class Solution {
    public int minKnightMoves(int x, int y) {
        if (x == 0 && y == 0) {
            return 0;
        }
    
        x = Math.abs(x);
        y = Math.abs(y);
    
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
    
        return f(x, y);
    }
    
    int f(int x, int y) {
        if (x == 1 && y == 0) {
            return 3;
        }
        if (x == 2 && y == 2) {
            return 4;
        }
    
        int delta = x - y;
        if (y > delta) {
            return (int) (delta - 2 * Math.floor((double) (delta - y) / 3.0));
        } else {
            return (int) (delta - 2 * Math.floor((double) (delta - y) / 4.0));
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minKnightMoves(1325325 - 12, 325553 - 432));
    }
}
