public class Solution {
    public int minMoves2(int[] nums) {
        int l = 0, r = nums.length - 1, part = 0, mid = nums.length >> 1;
        while ((part = partition(nums, l, r)) != mid) {
            if (part < mid) {
                l = part + 1;
            } else {
                r = part - 1;
            }
        }
        
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += Math.abs(nums[i] - nums[mid]);
        }
        
        return res;
    }
    
    private int partition(int[] A, int l, int r) {
        if (l >= r) {
            return l;
        }
        
        int m = l + (r - l >> 1);
        swap(A, l, m);
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
        return l;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
