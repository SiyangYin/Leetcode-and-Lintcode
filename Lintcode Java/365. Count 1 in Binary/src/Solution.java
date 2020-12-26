public class Solution {
    /*
     * @param num: An integer
     * @return: An integer
     */
    public int countOnes(int num) {
        // write your code here
        int res = 0;
        while (num != 0) {
            res++;
            num -= lowbit(num);
        }
        
        return res;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
}
