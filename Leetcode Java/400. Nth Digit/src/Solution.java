public class Solution {
    public int findNthDigit(int n) {
        long pow = 1, dig = 1;
        while (n > 9 * pow * dig) {
            n -= 9 * pow * dig;
            pow *= 10;
            dig++;
        }
    
        long s = pow + (n - 1) / dig;
        return String.valueOf(s).charAt((int) ((n - 1) % dig)) - '0';
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(3));
        System.out.println(new Solution().findNthDigit(11));
        System.out.println(new Solution().findNthDigit(190));
        System.out.println(new Solution().findNthDigit(1000000000));
        System.out.println(new Solution().findNthDigit(Integer.MAX_VALUE));
    }
}
