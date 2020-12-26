import java.util.Arrays;

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        Pair[] pairs = new Pair[nums.length + 1];
        pairs[0] = new Pair(0, 0);
    
        for (int i = 0; i < nums.length; i++) {
            pairs[i + 1] = new Pair(pairs[i].sum + nums[i], i + 1);
        }
    
        Arrays.sort(pairs, (p1, p2) -> p1.sum < p2.sum ? -1 : 1);
    
        int[] res = new int[2];
        int cur = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int tmp = pairs[i + 1].sum - pairs[i].sum;
            if (tmp < cur) {
                cur = tmp;
                int begin = pairs[i + 1].index, end = pairs[i].index;
                if (begin > end) {
                    int swap = begin;
                    begin = end;
                    end = swap;
                }
                res[0] = end - 1;
                res[1] = begin;
            }
        }
        
        if (res[0] > res[1]) {
            int tmp = res[0];
            res[0] = res[1];
            res[1] = tmp;
        }
        
        return res;
    }
    
    private static class Pair {
        int sum, index;
        public Pair(int sum, int index) {
            this.sum = sum;
            this.index = index;
        }
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().
                subarraySumClosest(new int[]{-3, 1, 1, -3, 5})));
    }
}
