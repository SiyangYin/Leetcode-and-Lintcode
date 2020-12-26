public class Solution3 {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        quickSort(A, 0, A.length - 1);
    }
    
    private void quickSort(int[] A, int l, int r) {
        if (l >= r) {
            return;
        }
        
        int start = l, end = r, mid = l + (r - l >> 1);
        swap(A, l, mid);
        int piv = A[l];
        
        while (l < r) {
            while (l < r && A[r] >= piv) {
                r--;
            }
            A[l] = A[r];
            
            while (l < r && A[l] <= piv) {
                l++;
            }
            A[r] = A[l];
        }
        
        A[l] = piv;
        
        quickSort(A, start, l - 1);
        quickSort(A, l + 1, end);
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
