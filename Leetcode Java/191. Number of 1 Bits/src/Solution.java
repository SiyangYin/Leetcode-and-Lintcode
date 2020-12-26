public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(5));
        System.out.println(new Solution().hammingWeight(5));
    }
}