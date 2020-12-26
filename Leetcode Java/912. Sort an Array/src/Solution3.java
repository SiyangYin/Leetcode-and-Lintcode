import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    
    public static void main(String[] args) {
        System.out.println(new Solution3().sortArray(new int[]{5, 2, 3, 1, 1, 2, 0}));
    }
    
    public List<Integer> sortArray(int[] nums) {
        mergeSort(nums);
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            res.add(num);
        }
        
        return res;
    }
    
    private void mergeSort(int[] nums) {
        int[] tmp = new int[nums.length];
    
        for (int i = 1; i < nums.length; i *= 2) {
            for (int j = 0; j + i < nums.length; j += i * 2) {
                int index = 0;
                int l = j, r = j + i;
                while (l < j + i && r < j + 2 * i && r < nums.length) {
                    if (nums[l] <= nums[r]) {
                        tmp[index++] = nums[l++];
                    } else {
                        tmp[index++] = nums[r++];
                    }
                }
                while (l < j + i) {
                    tmp[index++] = nums[l++];
                }
                while (r < j + 2 * i && r < nums.length) {
                    tmp[index++] = nums[r++];
                }
            
                index = 0;
                for (int k = j; k < r; k++) {
                    nums[k] = tmp[index++];
                }
            }
        }
    }
}
