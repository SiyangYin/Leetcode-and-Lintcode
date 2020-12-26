public class Solution2 {
    
    public void sortIntegers2(int[] A) {
        for (int i = A.length; i >= 2; i--) {
            heapify(A, i);
            swap(A, 0, i - 1);
        }
    }
    
    private void heapify(int[] nums, int n) {
        for (int i = (n - 1) >> 1; i >= 0; i--) {
            percolateDown(nums, n, i);
        }
    }
    
    private void percolateDown(int[] nums, int n, int i) {
        int tmp = nums[i];
        while ((i << 1) + 1 < n) {
            int child = (i << 1) + 1;
            if ((i << 1) + 2 < n && nums[(i << 1) + 2] > nums[child]) {
                child++;
            }
            if (tmp >= nums[child]) {
                break;
            }
            nums[i] = nums[child];
            i = child;
        }
        nums[i] = tmp;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}
