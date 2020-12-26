public class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        }
        
        while (sx <= tx && sy <= ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
            
            if (sx == tx && (sy - ty) % sx == 0) {
                return true;
            }
            if (sy == ty && (sx - tx) % sy == 0) {
                return true;
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().reachingPoints(1, 1, 3, 5));
    }
}
