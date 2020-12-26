public class Solution {
    /**
     * @param num: a positive integer
     * @return: if num is a perfect square else False
     */
    public boolean isPerfectSquare(int num) {
        // write your code here
        if (num < 0) {
            return false;
        }
        
        long i = 0;
        while (i * i < num) {
            i++;
        }
        
        return i * i == num;
    }
}
