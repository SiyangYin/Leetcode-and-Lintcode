public class Solution {
    /**
     * @param ghosts: a 2D integer array
     * @param target: a integer array
     * @return: return boolean
     */
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // write your code here
        int dis = Math.abs(target[0]) + Math.abs(target[1]);
    
        for (int i = 0; i < ghosts.length; i++) {
            int[] ghost = ghosts[i];
            if (dis >= Math.abs(ghost[0] - target[0]) + Math.abs(ghost[1] - target[1])) {
                return false;
            }
        }
        
        return true;
    }
}
