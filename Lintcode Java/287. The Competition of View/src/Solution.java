import java.util.Arrays;

public class Solution {
    /**
     * @param pos: the vision ward can control interval
     * @param L:   you need to control interval length
     * @return: return the minium number of vision ward to control the interval
     */
    public int getMiniumVisionWard(int[][] pos, int L) {
        // write your code here
        Arrays.sort(pos, (p1, p2) -> Integer.compare(p1[0], p2[0]));
        
        int res = 0, last = 0, cur = 0;
        for (int i = 0; i < pos.length && cur < L; ) {
            if (pos[i][0] > cur) {
                return -1;
            }
            
            while (i < pos.length && pos[i][0] <= last) {
                cur = Math.max(cur, pos[i][1]);
                i++;
            }
            
            last = cur;
            res++;
        }
        
        return cur <= L ? res : -1;
    }
    
    public static void main(String[] args) {
        // int[][] pos = {{0, 4}, {0, 3}, {2, 4}, {5, 5}};
        int[][] pos = {{0, 4}, {4, 5}};
        System.out.println(new Solution().getMiniumVisionWard(pos, 6));
        System.out.println(new Solution().getMiniumVisionWard(pos, 5));
    }
}
