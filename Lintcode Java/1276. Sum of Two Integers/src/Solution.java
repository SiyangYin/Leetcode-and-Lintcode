public class Solution {
    /**
     * @param a:
     * @param b:
     * @return: return an integer
     */
    public int getSum(int a, int b) {
        // wirte your code here
        int res = a;
        while (b != 0) {
            res = a ^ b;
            b = (a & b) << 1;
            a = res;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().getSum(1, -1));
    }
}
