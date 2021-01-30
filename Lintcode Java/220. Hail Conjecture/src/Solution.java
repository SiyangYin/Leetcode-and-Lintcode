public class Solution {
    /**
     * @param num: an integer
     * @return: return an integer
     */
    public int getAnswer(int num) {
        // write your code here.
        int res = 0;
        while (num != 1) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num = num * 3 + 1;
            }
            res++;
        }
        
        return res;
    }
}
