import java.util.Arrays;

public class Solution4 {
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        
        int[] window = Arrays.copyOf(nums, k);
        Arrays.sort(window);
        res[0] = median(window);
    
        for (int i = k; i < nums.length; i++) {
            int ind = binarySearch(window, nums[i - k]);
            window[ind] = nums[i];
            int tmp = window[ind];
            if (ind + 1 < window.length && tmp > window[ind + 1]) {
                while (ind < window.length - 1 && tmp > window[ind + 1]) {
                    window[ind] = window[ind + 1];
                    ind++;
                }
                window[ind] = tmp;
            } else if (ind > 0 && tmp < window[ind - 1]) {
                while (ind > 0 && tmp < window[ind - 1]) {
                    window[ind] = window[ind - 1];
                    ind--;
                }
                window[ind] = tmp;
            }
            res[i - k + 1] = median(window);
        }
        
        return res;
    }
    
    private int binarySearch(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = l + ((r - l) >> 1);
            if (target < nums[m]) {
                r = m - 1;
            } else if (target > nums[m]) {
                l = m + 1;
            } else {
                return m;
            }
        }
        return l;
    }
    
    private double median(int[] nums) {
        int l = nums.length;
        if (l % 2 == 0) {
            return ((double) nums[l / 2 - 1] + (double) nums[l / 2]) / 2.0;
        } else {
            return nums[l / 2];
        }
    }
    
    public static void main(String[] args) {
        // int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] nums = {1, 4, 2, 3};
        System.out.println(Arrays.toString(new Solution4().medianSlidingWindow(nums, 4)));
        
    }
}
