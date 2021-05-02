import java.util.Arrays;

public class Solution {
    public int[] sortArrayByParity(int[] A) {
        for (int i = 0, j = A.length - 1; i < j; ) {
            while (i < j && A[i] % 2 == 0) {
                i++;
            }
            while (i < j && A[j] % 2 != 0) {
                j--;
            }
            
            swap(A, i, j);
        }
        
        return A;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().sortArrayByParity(new int[]{3, 1, 2, 4})));
    }
}
