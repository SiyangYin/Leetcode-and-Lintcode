import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        
        Arrays.sort(nums);
        
        int[] dp = new int[nums.length], prev = new int[nums.length];
        dp[0] = 1;
        prev[0] = 0;
    
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            prev[i] = i;
            int maxLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] > maxLen) {
                    maxLen = dp[j];
                    prev[i] = j;
                    dp[i] = 1 + maxLen;
                }
            }
        }
    
        int maxIdx = 0, maxLen = 0;
        for (int i = 0; i < dp.length; i++) {
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                maxIdx = i;
            }
        }
        
        int idx = maxIdx;
        res.add(nums[idx]);
        while (prev[idx] != idx) {
            idx = prev[idx];
            res.add(nums[idx]);
        }
    
        Collections.reverse(res);
        return res;
    }
}
