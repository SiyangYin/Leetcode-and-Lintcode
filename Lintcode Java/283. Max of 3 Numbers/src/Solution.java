public class Solution {
    /**
     * @param num1: An integer
     * @param num2: An integer
     * @param num3: An integer
     * @return: an interger
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        int res = num1;
        if (num2 > res) {
            res = num2;
        }
        if (num3 > res) {
            res = num3;
        }
        
        return res;
    }
}
