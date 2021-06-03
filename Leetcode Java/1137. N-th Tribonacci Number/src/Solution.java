public class Solution {
    public int tribonacci(int n) {
        int[] f = {0, 1, 1};
        for (int i = 0; i < n - 2; i++) {
            f[i % 3] = f[0] + f[1] + f[2];
        }
        
        return f[n % 3];
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().tribonacci(4));
    }
}
