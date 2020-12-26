import java.util.Arrays;

public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
    public double findMedian(int[][] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            len += nums[i].length;
        }
        
        int find1 = -1, find2 = -1;
        if (len % 2 != 0) {
            find1 = len / 2;
        } else {
            find1 = len / 2 - 1;
            find2 = find1 + 1;
        }
        
        double[] arr = new double[len];
        for (int i = 0, idx = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                arr[idx++] = nums[i][j];
            }
        }
    
        if (arr.length == 0) {
            return 0;
        }
        
        Arrays.sort(arr);
        int count = 0;
        double res = 0;
        if (find1 != -1) {
            res += arr[find1];
            count++;
        }
        if (find2 != -1) {
            res += arr[find2];
            count++;
        }
        
        return res / count;
    }
    
    public static void main(String[] args) {
        // int[][] nums = {{1, 1, 2}, {2, 4, 8}, {3, 7, 10, 20}};
        // int[][] nums = {{1, 3}, {2147483646, 2147483647}};
        int[][] nums = {{1,1,2}, {2,4,8}, {3,7,10,20}};
        
        System.out.println(new Solution().findMedian(nums));
    }
}
