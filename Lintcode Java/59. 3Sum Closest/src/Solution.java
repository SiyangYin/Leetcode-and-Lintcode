import java.util.Arrays;

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int res = numbers[0] + numbers[1] + numbers[2], minDiff = Math.abs(res - target);
        Arrays.sort(numbers);
    
        for (int i = 0; i < numbers.length - 2; i++) {
            int l = i + 1, r = numbers.length - 1;
            while (l < r) {
                int sum = numbers[i] + numbers[l] + numbers[r];
                if (Math.abs(sum - target) < minDiff) {
                    res = sum;
                    minDiff = Math.abs(sum - target);
                }
                
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return target;
                }
            }
        }
        
        return res;
    }
}
