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
        
        if (y <= x - y) {
            if (x % 2 == 0) {
                return x / 2 + (x / 2 - y) % 2;
            } else {
                return (x + 1) / 2 + ((x + 1) / 2 - y + 1) % 2;
            }
        }
        
        int d = (2 * y - x) / 3;
        if (d == 0) {
            d = 1;
        }
        
        x += d;
        y -= d;
        return f(x, y);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().minKnightMoves(1325325 - 12, 325553 - 432));
    }
}
