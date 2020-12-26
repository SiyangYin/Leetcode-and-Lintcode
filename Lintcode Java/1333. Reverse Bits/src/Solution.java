public class Solution {
    /**
     * @param n: an integer
     * @return: return an integer
     */
    public long reverseBits(long n) {
        // write your code here
        long res = 0;
        int count = 0;
        while (count < 32) {
            res = (res << 1) + (n & 1);
            n >>>= 1;
            count++;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reverseBits(1));
    }
}
