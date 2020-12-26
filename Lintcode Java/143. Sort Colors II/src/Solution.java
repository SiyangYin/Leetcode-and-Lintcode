import java.util.Arrays;

public class Solution {
    /**
     * @param colors: A list of integer
     * @param k:      An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length == 0) {
            return;
        }
        
        int[] count = new int[k];
        for (int color : colors) {
            count[color - 1]++;
        }
    
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                colors[idx++] = i + 1;
            }
        }
    
        System.out.println(Arrays.toString(colors));
    }
    
    public static void main(String[] args) {
        new Solution().sortColors2(new int[]{2, 1, 1, 2, 2}, 2);
    }
}