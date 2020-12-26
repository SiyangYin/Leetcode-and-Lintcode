public class Solution {
    /**
     * @param A: A an integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    public int totalOccurrence(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int l = 0, r = A.length - 1;
        int firstOcc = 0, lastOcc = 0;
        
        while (l < r) {
            int m = l + (r - l >> 1);
            if (target < A[m]) {
                r = m - 1;
            } else if (target > A[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        
        firstOcc = A[l] == target ? l : -1;
        if (firstOcc == -1) {
            return 0;
        }
    
        l = 0;
        r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (target < A[m]) {
                r = m - 1;
            } else if (target > A[m]) {
                l = m + 1;
            } else {
                l = m;
            }
        }
    
        lastOcc = A[r] == target ? r : -1;
        
        return lastOcc - firstOcc + 1;
    }
}
