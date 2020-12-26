public class Solution {
    /**
     * @param a: a integer represent the length of one edge
     * @param b: a integer represent the length of one edge
     * @param c: a integer represent the length of one edge
     * @return: whether three edges can form a triangle
     */
    public boolean isValidTriangle(int a, int b, int c) {
        // write your code here
        if (a <= 0 || b <= 0 || c <= 0) {
            return false;
        }
        
        int sum = a + b + c;
        return sum > 2 * a && sum > 2 * b && sum > 2 * c;
    }
}
