public class Solution {
    public boolean check(int[] nums) {
        boolean flag = false;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                reverse(nums, 0, i);
                reverse(nums, i + 1, nums.length - 1);
                flag = true;
                break;
            }
        }
        
        if (!flag) {
            return true;
        }
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
    
    private void reverse(int[] A, int i, int j) {
        while (i < j) {
            int tmp = A[i];
            A[i] = A[j];
            A[j] = tmp;
            
            i++;
            j--;
        }
    }
}
