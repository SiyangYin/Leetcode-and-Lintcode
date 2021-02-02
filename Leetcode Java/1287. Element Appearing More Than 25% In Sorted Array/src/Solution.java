public class Solution {
    public int findSpecialInteger(int[] arr) {
        int c = arr.length / 4;
        for (int i = c; i < arr.length; i += c) {
            if (count(arr, arr[i], i) > c) {
                return arr[i];
            }
        }
        
        return -1;
    }
    
    private int count(int[] A, int t, int idx) {
        int l = 0, r = idx;
        while (l < r) {
            int m = l + (r - l >> 1);
            if (A[m] >= t) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        
        int s = l;
        
        l = idx;
        r = A.length - 1;
        while (l < r) {
            int m = l + (r - l + 1 >> 1);
            if (A[m] <= t) {
                l = m;
            } else {
                r = m - 1;
            }
        }
        
        return l - s + 1;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().findSpecialInteger(new int[]{1, 2, 2, 6, 6, 6, 6, 7, 10}));
    }
}
