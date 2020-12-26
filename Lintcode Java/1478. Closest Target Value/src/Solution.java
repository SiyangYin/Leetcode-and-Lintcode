import java.util.Arrays;

public class Solution {
    /**
     * @param target: the target
     * @param array: an array
     * @return: the closest value
     */
    public int closestTargetValue(int target, int[] array) {
        // Write your code here
        if (array == null || array.length < 2) {
            return -1;
        }
    
        Arrays.sort(array);
        int i = 0, j = array.length - 1;
        int res = Integer.MIN_VALUE;
        while (i < j) {
            int sum = array[i] + array[j];
            if (sum > target) {
                j--;
            } else if (sum < target) {
                res = Math.max(res, sum);
                i++;
            } else {
                return sum;
            }
        }
        
        return res == Integer.MIN_VALUE ? -1 : res;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().closestTargetValue(15, new int[]{1, 3, 5, 11, 7}));
    }
}
