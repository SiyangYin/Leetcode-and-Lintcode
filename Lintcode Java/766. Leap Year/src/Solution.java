public class Solution {
    /**
     * @param n: a number represent year
     * @return: whether year n is a leap year.
     */
    public boolean isLeapYear(int n) {
        // write your code here
        return n % 400 == 0 || (n % 4 == 0 && n % 100 != 0);
    }
}
