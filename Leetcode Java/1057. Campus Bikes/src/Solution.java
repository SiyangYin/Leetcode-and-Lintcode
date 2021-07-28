import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        List<int[]> dist = new ArrayList<>();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int x1 = workers[i][0], y1 = workers[i][1];
                int x2 = bikes[j][0], y2 = bikes[j][1];
                int dis = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                dist.add(new int[]{dis, i, j});
            }
        }
        
        dist.sort((d1, d2) -> d1[0] != d2[0] ? Integer.compare(d1[0], d2[0]) : d1[1] != d2[1] ? Integer.compare(d1[1], d2[1]) : Integer.compare(d1[2], d2[2]));
        int[] res = new int[workers.length];
        Arrays.fill(res, -1);
        boolean[] used = new boolean[bikes.length];
        for (int[] d : dist) {
            int idxW = d[1], idxB = d[2];
            if (!used[idxB] && res[idxW] == -1) {
                res[idxW] = idxB;
                used[idxB] = true;
            }
        }
        
        return res;
    }
}
