public class Solution {
    /*
     * @param x: An integer
     * @return: An integer
     */
    public int swapOddEvenBits(int x) {
        // write your code here
        int[] map = {0, 2, 1, 3};
        int res = 0, i = 0;
        while (x != 0) {
            int lasttwo = x & 3;
            res += map[lasttwo] << i;
            x >>>= 2;
            i += 2;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(-2));
        System.out.println(new Solution().swapOddEvenBits(-2));
    }
}
