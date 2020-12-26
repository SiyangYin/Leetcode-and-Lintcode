import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            while (i < A.length && j < B.length && (A[i][1] < B[j][0] || B[j][1] < A[i][0])) {
                if (A[i][1] < B[j][0]) {
                    i++;
                } else {
                    j++;
                }
            }
            
            if (i == A.length || j == B.length) {
                break;
            }
            
            int start = Math.max(A[i][0], B[j][0]), end = Math.min(A[i][1], B[j][1]);
            list.add(new int[]{start, end});
            
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        
        int[][] res = new int[list.size()][2];
        for (int k = 0; k < list.size(); k++) {
            res[k] = list.get(k);
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] A = {{0, 2}, {5, 10}, {13,23},{24,25}}, B = {{1, 5}, {8, 12},{15,24},{25,26}};
        // int[][] A = {{0, 2}, {5, 10}}, B = {};
        int[][] A = {{6, 7}, {8, 13}, {15, 19}}, B = {{1, 2}, {4, 5}, {11, 13}, {15, 16}, {17, 19}};
        System.out.println(Arrays.deepToString(new Solution2().intervalIntersection(A, B)));
    }
}
