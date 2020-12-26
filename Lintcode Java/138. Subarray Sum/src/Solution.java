import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        Pair[] pairs = new Pair[nums.length + 1];
        pairs[0] = new Pair(0, 0);
        for (int i = 0; i < nums.length; i++) {
            pairs[i + 1] = new Pair(pairs[i].sum + nums[i], i + 1);
        }
    
        Arrays.sort(pairs, (p1, p2) -> p1.sum < p2.sum ? -1 : 1);
        
        for (int i = 0; i < pairs.length - 1; i++) {
            if (pairs[i + 1].sum == pairs[i].sum) {
                int begin = pairs[i].index, end = pairs[i + 1].index;
                if (begin > end) {
                    int tmp = begin;
                    begin = end;
                    end = tmp;
                }
                res.add(begin);
                res.add(end - 1);
                break;
            }
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
}
