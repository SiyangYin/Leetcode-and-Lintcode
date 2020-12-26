public class Solution {
    /**
     * @param n: a postive Integer
     * @return: if two adjacent bits will always have different values
     */
    public boolean hasAlternatingBits(int n) {
        n = n ^ (n >> 1);
        return (n & n + 1) == 0;
    }
}
