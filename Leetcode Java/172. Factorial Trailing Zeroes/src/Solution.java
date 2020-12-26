public class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            count += n / 5;
            n /= 5;
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(1000));
    }
}
