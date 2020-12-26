import java.util.Arrays;

public class Solution {
    /*
     * @param A: An integer array.
     * @return: nothing
     */
    public void rerange(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return;
        }
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        if (A.length % 2 == 0) {
            l++;
            r--;
        } else {
            int mid = A[A.length / 2];
            if (mid > 0) {
                r--;
            } else {
                l++;
            }
        }
        
        while (l < r) {
            swap(A, l, r);
            l += 2;
            r -= 2;
        }
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public static void main(String[] args) {
        int[] A = new int[]{-1, -2, -3, 4, 5, 6};
        A = new int[]{-1, -2, -3, 4, 5, 6, 7};
        new Solution().rerange(A);
        System.out.println(Arrays.toString(A));
    }
}
