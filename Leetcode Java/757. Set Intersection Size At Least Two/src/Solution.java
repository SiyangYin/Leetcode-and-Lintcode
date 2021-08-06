import java.util.Arrays;

public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[1], i2[1]));
        // last2 < last1
        int res = 0, last1 = -1, last2 = -1;
        for (int[] interval : intervals) {
            if (interval[0] > last1) {
                last2 = interval[1] - 1;
                last1 = interval[1];
                res += 2;
            } else if (interval[0] == last1 || interval[0] > last2) {
                if (interval[1] > last1) {
                    last2 = last1;
                    last1 = interval[1];
                } else {
                    last2 = last1 - 1;
                }
                
                res++;
            }
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        // int[][] in = {{1, 2}, {2, 3}, {2, 4}, {4, 5}};
        int[][] in = {{1, 3}, {3, 7}, {5, 7}, {7, 8}};
        System.out.println(new Solution().intersectionSizeTwo(in));
    }
}
