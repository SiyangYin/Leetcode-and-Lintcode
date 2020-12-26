public class Solution {
    /**
     * @param screen: a two-dimensional array of colors
     * @param x: the abscissa of the specified point
     * @param y: the ordinate of the specified point
     * @param newColor: the specified color
     * @return: Can it be filled
     */
    public boolean paintFill(int[][] screen, int x, int y, int newColor) {
        // write your code here.
        return screen[x][y] != newColor;
    }
}
