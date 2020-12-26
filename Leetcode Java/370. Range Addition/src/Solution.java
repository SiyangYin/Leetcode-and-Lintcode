import java.util.Arrays;

public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] diff = new int[length + 1];
    
        for (int[] update : updates) {
            int l = update[0], r = update[1], x = update[2];
            diff[l + 1] += x;
            if (r + 2 < diff.length) {
                diff[r + 2] -= x;
            }
        }
    
        System.out.println(Arrays.toString(diff));
        int[] res = new int[length];
        int sum = diff[0];
        for (int i = 0; i < res.length; i++) {
            sum += diff[i + 1];
            res[i] = sum;
        }
        
        return res;
    }
    
    public static void main(String[] args) {
        int[][] updates = {{1,3,2},{2,4,3},{0,2,-2}};
        new Solution().getModifiedArray(5, updates);
    }
}
