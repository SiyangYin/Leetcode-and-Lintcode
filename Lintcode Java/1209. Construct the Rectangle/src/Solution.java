public class Solution {
    /**
     * @param area: web page’s area
     * @return: the length L and the width W of the web page you designed in sequence
     */
    public int[] constructRectangle(int area) {
        // Write your code here
        for (int i = (int) Math.sqrt(area); i >= 1; i--) {
            if (area % i == 0) {
                return new int[]{area / i, i};
            }
        }
        
        return null;
    }
}
