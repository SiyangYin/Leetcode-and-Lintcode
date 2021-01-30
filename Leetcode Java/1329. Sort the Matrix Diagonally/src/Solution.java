import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, n - 1});
        while (!queue.isEmpty()) {
            int size = queue.size();
            int diff = 0;
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                diff = x - y + 1;
                
                if (y > 0) {
                    queue.offer(new int[]{x, y - 1});
                    list.add(mat[x][y - 1]);
                }
                
                if (i == size - 1 && x + 1 < m) {
                    queue.offer(new int[]{x + 1, y});
                    list.add(mat[x + 1][y]);
                }
            }
            
            list.sort(null);
            for (int i = Math.max(0, diff); i < m && i - diff < n; i++) {
                mat[i][i - diff] = list.get(i - Math.max(0, diff));
            }
        }
        
        return mat;
    }
}
