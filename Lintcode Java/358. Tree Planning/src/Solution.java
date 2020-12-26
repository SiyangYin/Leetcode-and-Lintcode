public class Solution {
    /**
     * @param trees: the positions of trees.
     * @param d: the minimum beautiful interval.
     * @return: the minimum number of trees to remove to make trees beautiful.
     */
    public int treePlanning(int[] trees, int d) {
        // write your code here.
        int res = 0;
        for (int i = 1, last = trees[0]; i < trees.length; i++) {
            if (trees[i] - last < d) {
                res++;
            } else {
                last = trees[i];
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().treePlanning(new int[]{1, 2, 3, 5, 6}, 2));
    }
}
