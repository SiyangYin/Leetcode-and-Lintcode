import java.util.Arrays;

public class Solution2 {
    
    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        
        System.out.println(Arrays.deepToString(new Solution2().kClosest(points, 1)));
    }
    
    public int[][] kClosest(int[][] points, int K) {
        int rank = 0, l = 0, r = points.length - 1;
        while ((rank = partition(points, l, r)) != K - 1) {
            if (rank < K - 1) {
                l = rank + 1;
            } else {
                r = rank - 1;
            }
        }
        
        int[][] res = new int[K][2];
        for (int i = 0; i < K; i++) {
            res[i][0] = points[i][0];
            res[i][1] = points[i][1];
        }
        
        return res;
    }
    
    private int partition(int[][] points, int l, int r) {
        swap(points, l, l + ((r - l) >> 1));
        int[] pivot = points[l];
        int pivotDistanceSquared = distanceSquared(pivot);
        while (l < r) {
            while (l < r && pivotDistanceSquared <= distanceSquared(points[r])) {
                r--;
            }
            points[l] = points[r];
            while (l < r && distanceSquared(points[l]) <= pivotDistanceSquared) {
                l++;
            }
            points[r] = points[l];
        }
        points[l] = pivot;
        return l;
    }
    
    private int distanceSquared(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int tmp = points[i][0];
        points[i][0] = points[j][0];
        points[j][0] = tmp;
        
        tmp = points[i][1];
        points[i][1] = points[j][1];
        points[j][1] = tmp;
    }
}
