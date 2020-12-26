public class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z) {
            return false;
        }
        
        if (y > x) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        while (y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        
        return z % x == 0;
    }
    
    public static void main(String[] args) {
        // System.out.println(new Solution().canMeasureWater(1, 1, 12));
        System.out.println(new Solution().canMeasureWater(3, 5, 4));
    }
}
