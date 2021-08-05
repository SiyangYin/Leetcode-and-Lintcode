public class Solution {
    public int mirrorReflection(int p, int q) {
        int x = p * q / gcd(p, q);
        if (x / q % 2 != 0) {
            return x / p % 2 != 0 ? 1 : 0;
        }
        return 2;
    }
    
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mirrorReflection(3, 1));
        System.out.println(new Solution().mirrorReflection(2, 1));
    }
}
