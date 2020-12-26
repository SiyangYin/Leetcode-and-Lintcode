import java.util.List;

public class Solution {
    /**
     * @param nums: the array to be scored.
     * @param k:    the requirement of subarray length.
     * @param u:    if the sum is less than u, get 1 score.
     * @param l:    if the sum is greater than l, lose 1 score.
     * @return: return the sum of scores for every subarray whose length is k.
     */
    public int arrayScore(List<Integer> nums, int k, long u, long l) {
        // write your code here.
        int res = 0, sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums.get(i);
        }
        
        if (sum < u) {
            res++;
        }
        if (sum > l) {
            res--;
        }
        
        for (int i = k; i < nums.size(); i++) {
            sum += nums.get(i);
            sum -= nums.get(i - k);
            if (sum < u) {
                res++;
            }
            if (sum > l) {
                res--;
            }
        }
        
        return res;
    }
}
