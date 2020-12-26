public class Solution {
    public boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            while (c % i == 0) {
                c /= i;
                count++;
            }
            
            if (i % 4 == 3 && count % 2 != 0) {
                return false;
            }
        }
        
        return c % 4 != 3;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(5));
    }
}
