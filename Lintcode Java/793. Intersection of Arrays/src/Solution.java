import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        // write your code here
        if (arrs == null || arrs.length == 0) {
            return 0;
        }
        int[] a1 = arrs[0];
        for (int i = 1; i < arrs.length; i++) {
            a1 = intersection(a1, arrs[i]);
        }
        return a1.length;
    }
    
    public int[] intersection(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            if (a[i] == b[j]) {
                list.add(a[i]);
                i++;
                j++;
            } else if (a[i] < b[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] intersection = new int[list.size()];
        for (int k = 0; k < intersection.length; k++) {
            intersection[k] = list.get(k);
        }
        return intersection;
    }
    
    public static void main(String[] args) {
        int[][] arrs = new int[][]{{1, 2, 3}, {3, 4, 5}};
        System.out.println(new Solution().intersectionOfArrays(arrs));
    }
    
}