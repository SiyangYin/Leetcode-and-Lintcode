public class Solution {
    public int countOdds(int low, int high) {
        high -= high % 2 == 0 ? 1 : 0;
        low += low % 2 == 0 ? 1 : 0;
        return (high - low >> 1) + 1;
    }
}
