public class Solution {
    public int mirrorReflection(int p, int q) {
        int lcm = p * q / gcd(p, q);
        int[][] a = {{2, 1}, {1, 0}};
        return a[(lcm / q) & 1][(lcm / p + 1) & 1];
    }
    
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().mirrorReflection(3, 1));
        System.out.println(new Solution().mirrorReflection(2, 1));
    }
}
