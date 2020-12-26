import java.util.Arrays;

public class Solution {
    /**
     * @param array: an integer array
     * @return: nothing
     */
    public void pancakeSort(int[] array) {
        // Write your code here
        int idx = array.length - 1;
        while (idx > 0) {
            int maxIdx = 0, max = Integer.MIN_VALUE;
            for (int i = 0; i <= idx; i++) {
                if (array[i] > max) {
                    max = array[i];
                    maxIdx = i;
                }
            }
            
            if (maxIdx != idx) {
                flip(array, maxIdx);
                flip(array, idx);
            }
            
            idx--;
        }
    }
    
    private void flip(int[] array, int i) {
        for (int j = 0; j < i; j++, i--) {
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {6, 11, 10, 12, 7, 23, 20};
        new Solution().pancakeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
