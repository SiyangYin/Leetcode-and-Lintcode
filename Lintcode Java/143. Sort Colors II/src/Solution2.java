import java.util.Arrays;

public class Solution2 {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        partition(colors, 0, colors.length - 1);
        System.out.println(Arrays.toString(colors));
    }
    
    private void partition(int[] colors, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int midCol = colors[l + (r - l >> 1)];
        
        int i = l - 1, j = l, k = r + 1;
        while (j < k) {
            if (colors[j] < midCol) {
                swap(colors, ++i, j++);
            } else if (colors[j] > midCol) {
                swap(colors, --k, j);
            } else {
                j++;
            }
        }
        
        partition(colors, l, i);
        partition(colors, k, r);
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public static void main(String[] args) {
        new Solution2().sortColors2(new int[]{3, 2, 2, 1, 4}, 4);
    }
}
