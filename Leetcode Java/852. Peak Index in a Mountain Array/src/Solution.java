public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 1, r = arr.length - 2;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (arr[m] > arr[m - 1]) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l;
    }
}