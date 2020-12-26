public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = 0;
        for (int i = 30; i >= 0; i--) {
            if ((m >> i & 1) == (n >> i & 1)) {
                res += (m >> i & 1) << i;
            } else {
                break;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        System.out.println("1111111111111111111111111111111".length());
    
        System.out.println(new Solution().rangeBitwiseAnd(5, 7));
    }
}
