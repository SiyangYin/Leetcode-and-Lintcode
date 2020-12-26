import java.util.Arrays;

public class Solution {
    /**
     * @param length:  the length of the array
     * @param updates: update operations
     * @return: the modified array after all k operations were executed
     */
    public int[] getModifiedArray(int length, int[][] updates) {
        // Write your code here
        int[] diff = new int[length];
        for (int[] update : updates) {
            diff[update[0]] += update[2];
            if (update[1] + 1 < length) {
                diff[update[1] + 1] -= update[2];
            }
        }
        
        for (int i = 1; i < length; i++) {
            diff[i] += diff[i - 1];
        }
        
        return diff;
    }
    
    public static void main(String[] args) {
        int[][] up = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
        System.out.println(Arrays.toString(new Solution().getModifiedArray(5, up)));
    }
}
