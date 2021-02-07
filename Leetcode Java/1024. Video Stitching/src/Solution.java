import java.util.Arrays;

public class Solution {
    public int videoStitching(int[][] clips, int T) {
        if (T == 0) {
            return 0;
        }
        
        Arrays.sort(clips, (c1, c2) -> Integer.compare(c1[0], c2[0]));
        int res = 0, st = 0, r = 0;
        for (int i = 0; i < clips.length; i++) {
            r = -1;
            int j = i;
            while (j < clips.length && clips[j][0] <= st) {
                r = Math.max(r, clips[j][1]);
                j++;
            }
            
            if (r < st) {
                return -1;
            }
            
            res++;
            if (r >= T) {
                return res;
            }
            
            st = r;
            i = j - 1;
        }
    
        return r >= T ? res : -1;
    }
    
    public static void main(String[] args) {
        int[][] c = {{0, 2}, {4, 8}};
        System.out.println(new Solution().videoStitching(c, 5));
    }
}
