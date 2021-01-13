public class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (arr[m] - (m + 1) < k) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return arr[l] - (l + 1) >= k ? k : k + l + 1;
    }
}
