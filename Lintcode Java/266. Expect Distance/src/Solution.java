public class Solution {
    /**
     * @param x: the distance from cave A to cave A.
     * @param y: the distance from cave B to cave B.
     * @param z: the distance from cave B to exit C.
     * @return: return the expect distance to go out of the cave.
     */
    public int expectDistance(int x, int y, int z) {
        // write your code here.
        return 2 * x + y + z + 4;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().expectDistance(1, 2, 1));
    }
}
