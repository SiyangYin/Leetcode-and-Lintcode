public class Solution {
    /**
     * @param x: the given number x
     * @param y: the given number y
     * @param z: the given number z
     * @return: whether it is possible to measure exactly z litres using these two jugs
     */
    public boolean canMeasureWater(int x, int y, int z) {
        // Write your code here
        if (z > x + y) {
            return false;
        }
        
        return z % gcd(x, y) == 0;
    }
    
    private int gcd(int x, int y) {
        if (x < y) {
            int tmp = x;
            x = y;
            y = tmp;
        }
        
        while (y != 0) {
            int r = x % y;
            x = y;
            y = r;
        }
        
        return x;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().canMeasureWater(2, 6, 5));
    }
}
