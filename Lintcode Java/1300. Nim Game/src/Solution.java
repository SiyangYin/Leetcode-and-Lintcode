public class Solution {
    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */
    public boolean canWinNim(int n) {
        // Write your code here
        return n % 4 != 0;
    }
}
